package com.apontem.template;

import com.apontem.template.application.security.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private Config config;

    public SecurityConfig(Config config) {
        this.config = config;
    }

    @Bean
    public IdentityProvider getIdentityProvider() {
        if (config.getEnvironment().isMock())
            return new MockIdentityProvider();
        return new DefaultIdentityProvider();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin();
        http.addFilterBefore(new AuthRequestFilter(getIdentityProvider()), UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().authenticationEntryPoint( (request, response, authException) -> {
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=UTF-8");
            if(response.getStatus() == HttpServletResponse.SC_UNAUTHORIZED)
                response.getWriter().write(mapper.writeValueAsString(Map.of("message", "Not authenticated. " +
                        "Please authenticate to continue")));
            if(response.getStatus() == HttpServletResponse.SC_FORBIDDEN)
                response.getWriter().write(mapper.writeValueAsString(Map.of("message", "Access denied")));
        });
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/controller/manage/health").permitAll()
                .antMatchers(HttpMethod.GET, "/controller/get-time").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
