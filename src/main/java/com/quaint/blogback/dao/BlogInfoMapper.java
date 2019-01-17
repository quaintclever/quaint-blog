package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.BlogInfo;
import java.util.List;

public interface BlogInfoMapper {
    int deleteByPrimaryKey(Integer blogId);

    int insert(BlogInfo record);

    int insertSelective(BlogInfo record);

    BlogInfo selectByPrimaryKey(Integer blogId);

    List<BlogInfo> select();

    int updateByPrimaryKeySelective(BlogInfo record);

    int updateByPrimaryKey(BlogInfo record);
}