package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.Mood;

public interface MoodMapper {
    int deleteByPrimaryKey(Integer moodId);

    int insert(Mood record);

    int insertSelective(Mood record);

    Mood selectByPrimaryKey(Integer moodId);

    int updateByPrimaryKeySelective(Mood record);

    int updateByPrimaryKey(Mood record);
}