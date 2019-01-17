package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.UserAttention;

import java.util.List;

public interface UserAttentionMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(UserAttention record);

    int insertSelective(UserAttention record);

    UserAttention selectByPrimaryKey(Integer aId);

    List<UserAttention> select();

    int updateByPrimaryKeySelective(UserAttention record);

    int updateByPrimaryKey(UserAttention record);
}