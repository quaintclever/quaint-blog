package com.quaint.blog.pojo;

import lombok.Data;

@Data
public class Article {

    private Integer articleId;

    private String articleTitle;

    private String articleType;

    private String articleContent;

    //------扩展属性-------

    private String moodContent; //文章简介，心情说说

}