package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.Friend;

import java.util.List;

public interface FriendMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(Friend record);

    int insertSelective(Friend record);

    Friend selectByPrimaryKey(Integer fId);

    List<Friend> select();

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
}