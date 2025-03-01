package com.example.manage.framework.security;

import com.example.manage.system.domain.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
public class LoginUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String username;
    private SysUser user;
    private Set<String> permissions;
    private Collection<? extends GrantedAuthority> authorities;

    public LoginUser(SysUser user, Set<String> permissions) {
        this.user = user;
        this.userId = user.getUserId();
        this.username = user.getUserName();
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
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