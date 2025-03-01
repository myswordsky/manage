package com.example.manage.framework.security.service.impl;

import com.example.manage.common.core.domain.AjaxResult;
import com.example.manage.common.utils.JwtUtils;
import com.example.manage.framework.security.service.ILoginService;
import com.example.manage.system.domain.model.LoginBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public AjaxResult login(LoginBody loginBody) {
        // 用户验证
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginBody.getUsername(), loginBody.getPassword()));
        } catch (Exception e) {
            return AjaxResult.error("用户名或密码错误");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 生成token
        String token = jwtUtils.generateToken(authentication.getName());
        
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        return AjaxResult.success("登录成功", data);
    }

    @Override
    public AjaxResult logout() {
        SecurityContextHolder.clearContext();
        return AjaxResult.success("退出成功");
    }
} 