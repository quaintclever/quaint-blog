package com.quaint.blogback.pojo;

import lombok.Data;

/**
 * 博客实体类
 * quaint 2019年1月17日17:29:43
 */
@Data
public class BlogInfo {

    private Integer blogId;

    private Integer userId;

    private String blogKeyword;

    private String blogDescription;

    private String blogTitle;

    private String blogContent;

    private Integer blogCount;      //访问数量

    private Integer praiseCount;    //点赞数

}