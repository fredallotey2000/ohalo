package com.apontem.template.application.security;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class AuthUser implements UserDetails {
    @Getter @Setter (AccessLevel.PACKAGE)
    private String userId;
    @Getter @Setter (AccessLevel.PACKAGE)
    private String token;
    @Getter @Setter (AccessLevel.PACKAGE)
    private Identity.Name name;
    @Getter @Setter (AccessLevel.PACKAGE)
    private List<Identity.Account> accounts;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
