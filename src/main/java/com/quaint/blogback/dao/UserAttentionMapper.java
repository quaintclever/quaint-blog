package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.UserAttention;

public interface UserAttentionMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(UserAttention record);

    int insertSelective(UserAttention record);

    UserAttention selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(UserAttention record);

    int updateByPrimaryKey(UserAttention record);
}