package com.retocp.security;

import com.retocp.entity.Cliente;
import com.retocp.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserPrincipal implements UserDetails {

    private String username;
    private String password;

    public UserPrincipal(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static UserPrincipal create(Usuario usuario) {
        return new UserPrincipal(
                usuario.getUsername(),
                usuario.getPassword()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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