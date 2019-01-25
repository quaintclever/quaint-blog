package com.quaint.blog.dao;

import com.quaint.blog.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> select();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}