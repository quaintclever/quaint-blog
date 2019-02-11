package com.quaint.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 博客实体类
 * quaint 2019年1月17日17:29:43
 */
@Data
public class BlogInfo {
    //博客id
    private Integer blogId;
    //发表用户id
    private Integer userId;
    //关键词，标签
    private String blogKeyword;
    //博客分类，类型 +
    private String blogType;
    //博客描述，简述
    private String blogDescription;
    //博客标题
    private String blogTitle;
    //博客内容（通过富文本存储）
    private String blogContent;
    //访问数量,阅读量
    private Integer blogCount;
    //点赞数
    private Integer praiseCount;
    //发表时间 +
    private Date blogTime;
    //博客标题图片 +
    private String blogTitleImg;

}