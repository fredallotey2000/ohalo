package com.apontem.template.application.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private Authentication authentication;

    public String getUserId() {
        getSpringAuthenticationObject();
        return ((AuthUser)authentication.getPrincipal()).getUserId();
    }

    public String getAccessToken() {
        getSpringAuthenticationObject();
        return ((AuthUser)authentication.getPrincipal()).getToken();
    }

    private void getSpringAuthenticationObject() {
        if(authentication == null)
            authentication = SecurityContextHolder.getContext().getAuthentication();
    }
}
