package com.example.manage.framework.security.service;

import com.example.manage.common.core.domain.AjaxResult;
import com.example.manage.system.domain.model.LoginBody;

public interface ILoginService {
    /**
     * 登录
     */
    AjaxResult login(LoginBody loginBody);

    /**
     * 退出
     */
    AjaxResult logout();
} 