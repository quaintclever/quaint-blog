package com.quaint.blog.service;

import com.quaint.blog.pojo.Article;

/**
 * 文章业务类接口
 */
public interface ArticleService {

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
