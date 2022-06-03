package com.apontem.template.application.security;

import com.apontem.template.application.security.exception.ForbiddenAccess;
import com.apontem.template.application.security.exception.UnAuthorizedAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AuthRequestFilter extends OncePerRequestFilter {
    private final IdentityProvider identityProvider;

    public AuthRequestFilter(IdentityProvider identityProvider) {
        this.identityProvider = identityProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpRequest,
            HttpServletResponse httpResponse,
            FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = httpRequest.getHeader("Authorization");
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
            token = authorizationHeader.substring(7);

        if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                Identity identity = identityProvider.getIdentity(token);
                AuthUser authenticatedUser = new AuthUser();
                authenticatedUser.setUserId(identity.getUserId());
                authenticatedUser.setName(identity.getName());
                authenticatedUser.setAccounts(identity.getAccounts());
                authenticatedUser.setToken(token);
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        authenticatedUser, null, authenticatedUser.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } catch (UnAuthorizedAccess e) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            } catch (ForbiddenAccess e) {
                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
