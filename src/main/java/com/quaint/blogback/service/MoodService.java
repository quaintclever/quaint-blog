package com.quaint.blogback.service;

import com.quaint.blogback.pojo.Mood;

import java.util.List;

public interface MoodService {

    /**
     * 增加一个心情
     * @param mood
     * @return
     */
    int insertSelective(Mood mood);

    /**
     * 查询全部心情
     * @return
     */
    List<Mood> select();

}
