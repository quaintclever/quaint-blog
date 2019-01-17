package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.UserComment;

import java.util.List;

public interface UserCommentMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(UserComment record);

    int insertSelective(UserComment record);

    UserComment selectByPrimaryKey(Integer cId);

    List<UserComment> select();

    int updateByPrimaryKeySelective(UserComment record);

    int updateByPrimaryKey(UserComment record);
}