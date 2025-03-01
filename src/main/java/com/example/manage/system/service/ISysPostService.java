package com.example.manage.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.manage.system.domain.SysPost;

import java.util.List;

public interface ISysPostService extends IService<SysPost> {
    
    /**
     * 根据用户ID获取岗位选择框列表
     */
    List<SysPost> selectPostsByUserId(Long userId);

    /**
     * 校验岗位名称是否唯一
     */
    boolean checkPostNameUnique(SysPost post);

    /**
     * 校验岗位编码是否唯一
     */
    boolean checkPostCodeUnique(SysPost post);

    /**
     * 查询岗位是否存在用户
     */
    boolean checkPostExistUser(Long postId);
} 