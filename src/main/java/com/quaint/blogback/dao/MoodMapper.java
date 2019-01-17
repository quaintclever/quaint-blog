package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.Mood;

import java.util.List;

public interface MoodMapper {

    int deleteByPrimaryKey(Integer moodId);

    int insert(Mood record);

    int insertSelective(Mood record);

    Mood selectByPrimaryKey(Integer moodId);

    List<Mood> select();

    int updateByPrimaryKeySelective(Mood record);

    int updateByPrimaryKey(Mood record);
}