package com.example.manage.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.manage.system.domain.SysUser;

public interface ISysUserService extends IService<SysUser> {
    
    /**
     * 通过用户名查询用户
     */
    SysUser selectUserByUserName(String userName);

    /**
     * 注册用户信息
     */
    boolean registerUser(SysUser sysUser);

    /**
     * 校验用户名称是否唯一
     */
    boolean checkUsernameUnique(String username);

    /**
     * 校验手机号码是否唯一
     */
    boolean checkPhoneUnique(SysUser user);

    /**
     * 校验email是否唯一
     */
    boolean checkEmailUnique(SysUser user);
} 