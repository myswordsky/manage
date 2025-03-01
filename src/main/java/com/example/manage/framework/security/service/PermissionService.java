package com.example.manage.framework.security.service;

import com.example.manage.framework.security.LoginUser;
import com.example.manage.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Set;

@Service("ss")
public class PermissionService {
    
    @Autowired
    private ISysMenuService menuService;
    
    public boolean hasPermi(String permission) {
        if (!StringUtils.hasText(permission)) {
            return false;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        if (loginUser == null) {
            return false;
        }
        return loginUser.getPermissions().contains(permission);
    }
} 