package com.example.manage.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.manage.system.domain.SysMenu;

import java.util.List;
import java.util.Set;

public interface ISysMenuService extends IService<SysMenu> {
    
    /**
     * 根据用户ID查询菜单树信息
     */
    List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 根据用户ID查询权限
     */
    Set<String> selectMenuPermsByUserId(Long userId);

    /**
     * 构建前端所需要的菜单树
     */
    List<SysMenu> buildMenuTree(List<SysMenu> menus);

    /**
     * 根据角色ID查询菜单树信息
     */
    List<Long> selectMenuListByRoleId(Long roleId);
} 