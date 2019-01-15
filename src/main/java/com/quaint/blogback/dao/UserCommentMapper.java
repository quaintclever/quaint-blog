package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.UserComment;

public interface UserCommentMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(UserComment record);

    int insertSelective(UserComment record);

    UserComment selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(UserComment record);

    int updateByPrimaryKey(UserComment record);
}