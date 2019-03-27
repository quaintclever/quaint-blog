package com.quaint.blog.mapper;

import com.quaint.blog.pojo.Article;

/**
 * 文章接口
 * quaint -0326
 */
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    /**
     * 根据传递的非空增加
     * @param record
     * @return
     */
    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}