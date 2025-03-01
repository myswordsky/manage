package com.example.manage.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.manage.system.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    
    /**
     * 根据用户ID查询菜单树信息
     */
    List<SysMenu> selectMenuTreeByUserId(@Param("userId") Long userId);

    /**
     * 根据用户ID查询权限
     */
    List<String> selectMenuPermsByUserId(@Param("userId") Long userId);

    /**
     * 根据角色ID查询菜单树信息
     */
    List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId);
} 