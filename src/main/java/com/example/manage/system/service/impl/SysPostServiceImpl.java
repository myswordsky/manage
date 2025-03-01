package com.example.manage.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.manage.system.domain.SysPost;
import com.example.manage.system.mapper.SysPostMapper;
import com.example.manage.system.service.ISysPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {

    @Override
    public List<SysPost> selectPostsByUserId(Long userId) {
        return baseMapper.selectPostsByUserId(userId);
    }

    @Override
    public boolean checkPostNameUnique(SysPost post) {
        return count(new LambdaQueryWrapper<SysPost>()
                .eq(SysPost::getPostName, post.getPostName())
                .ne(post.getPostId() != null, SysPost::getPostId, post.getPostId())) == 0;
    }

    @Override
    public boolean checkPostCodeUnique(SysPost post) {
        return count(new LambdaQueryWrapper<SysPost>()
                .eq(SysPost::getPostCode, post.getPostCode())
                .ne(post.getPostId() != null, SysPost::getPostId, post.getPostId())) == 0;
    }

    @Override
    public boolean checkPostExistUser(Long postId) {
        return baseMapper.checkPostExistUser(postId) > 0;
    }
} 