package com.example.manage.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.manage.system.domain.SysRole;

import java.util.List;
import java.util.Set;

public interface ISysRoleService extends IService<SysRole> {
    
    /**
     * 根据用户ID查询角色列表
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 根据用户ID查询角色权限
     */
    Set<String> selectRolePermissionByUserId(Long userId);

    /**
     * 校验角色名称是否唯一
     */
    boolean checkRoleNameUnique(SysRole role);

    /**
     * 校验角色权限是否唯一
     */
    boolean checkRoleKeyUnique(SysRole role);
} 