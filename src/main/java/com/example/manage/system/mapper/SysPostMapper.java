package com.example.manage.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.manage.system.domain.SysPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysPostMapper extends BaseMapper<SysPost> {
    
    /**
     * 根据用户ID查询岗位
     */
    List<SysPost> selectPostsByUserId(@Param("userId") Long userId);
    
    /**
     * 查询岗位是否存在用户
     */
    int checkPostExistUser(@Param("postId") Long postId);
} 