package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.BlogInfo;

public interface BlogInfoMapper {
    int deleteByPrimaryKey(Integer blogId);

    int insert(BlogInfo record);

    int insertSelective(BlogInfo record);

    BlogInfo selectByPrimaryKey(Integer blogId);

    int updateByPrimaryKeySelective(BlogInfo record);

    int updateByPrimaryKey(BlogInfo record);
}