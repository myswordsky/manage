package com.example.manage.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_post")
public class SysPost {
    @TableId(type = IdType.AUTO)
    private Long postId;
    private String postCode;
    private String postName;
    private Integer postSort;
    private String status;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remark;
} 