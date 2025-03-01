package com.example.manage.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.manage.system.domain.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {
    
    /**
     * 根据角色ID查询部门树信息
     */
    List<Long> selectDeptListByRoleId(@Param("roleId") Long roleId);
    
    /**
     * 查询部门是否存在用户
     */
    int checkDeptExistUser(@Param("deptId") Long deptId);
} 