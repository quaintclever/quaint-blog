package com.quaint.blog.mapper;

import com.quaint.blog.pojo.Users;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    List<Users> select();

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}