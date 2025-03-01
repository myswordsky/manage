package com.example.manage.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.manage.system.domain.SysDept;

import java.util.List;

public interface ISysDeptService extends IService<SysDept> {
    
    /**
     * 构建前端所需要的部门树结构
     */
    List<SysDept> buildDeptTree(List<SysDept> depts);
    
    /**
     * 根据角色ID查询部门树信息
     */
    List<Long> selectDeptListByRoleId(Long roleId);
    
    /**
     * 根据部门ID查询信息
     */
    SysDept selectDeptById(Long deptId);
    
    /**
     * 校验部门名称是否唯一
     */
    boolean checkDeptNameUnique(SysDept dept);
    
    /**
     * 查询部门是否存在用户
     */
    boolean checkDeptExistUser(Long deptId);
    
    /**
     * 查询部门是否有子部门
     */
    boolean hasChildByDeptId(Long deptId);
} 