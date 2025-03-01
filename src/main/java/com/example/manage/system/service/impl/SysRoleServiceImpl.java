package com.example.manage.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.manage.system.domain.SysRole;
import com.example.manage.system.mapper.SysRoleMapper;
import com.example.manage.system.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public List<SysRole> selectRolesByUserId(Long userId) {
        return baseMapper.selectRolesByUserId(userId);
    }

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        List<SysRole> roles = selectRolesByUserId(userId);
        return roles.stream()
                .map(SysRole::getRoleKey)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean checkRoleNameUnique(SysRole role) {
        return count(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleName, role.getRoleName())
                .ne(role.getRoleId() != null, SysRole::getRoleId, role.getRoleId())) == 0;
    }

    @Override
    public boolean checkRoleKeyUnique(SysRole role) {
        return count(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleKey, role.getRoleKey())
                .ne(role.getRoleId() != null, SysRole::getRoleId, role.getRoleId())) == 0;
    }
} 