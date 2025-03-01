package com.example.manage.system.controller;

import com.example.manage.common.core.domain.AjaxResult;
import com.example.manage.framework.security.service.ILoginService;
import com.example.manage.system.domain.model.LoginBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @PostMapping("/auth/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        return loginService.login(loginBody);
    }

    @PostMapping("/auth/logout")
    public AjaxResult logout() {
        return loginService.logout();
    }
} 