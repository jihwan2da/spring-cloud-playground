package com.msa.user.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.security.auth.Subject;
import java.util.Collection;

public class JwtAuthentication implements Authentication {

    private final JwtUserAdapter useDetails;
    private final String email;

    public JwtAuthentication(UserDetails useDetails, String email) {
        this.useDetails = (JwtUserAdapter) useDetails;
        this.email = email;
    }

    @Override
    public String getName() {
        return email;
    }

    @Override
    public boolean implies(Subject subject) {
        return Authentication.super.implies(subject);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return useDetails.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return email;
    }

    @Override
    public Object getDetails() {
        return useDetails;
    }

    @Override
    public Object getPrincipal() {
        return useDetails.getUser().getId();
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }
}
