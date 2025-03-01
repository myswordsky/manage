package com.example.manage.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.manage.system.domain.SysUser;
import com.example.manage.system.mapper.SysUserMapper;
import com.example.manage.system.service.ISysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public SysUser selectUserByUserName(String userName) {
        return getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUserName, userName)
                .eq(SysUser::getDelFlag, "0")
                .last("limit 1"));
    }

    @Override
    public boolean registerUser(SysUser sysUser) {
        return save(sysUser);
    }

    @Override
    public boolean checkUsernameUnique(String username) {
        return count(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUserName, username)) == 0;
    }

    @Override
    public boolean checkPhoneUnique(SysUser user) {
        return count(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getPhonenumber, user.getPhonenumber())
                .ne(user.getUserId() != null, SysUser::getUserId, user.getUserId())) == 0;
    }

    @Override
    public boolean checkEmailUnique(SysUser user) {
        return count(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getEmail, user.getEmail())
                .ne(user.getUserId() != null, SysUser::getUserId, user.getUserId())) == 0;
    }
} 