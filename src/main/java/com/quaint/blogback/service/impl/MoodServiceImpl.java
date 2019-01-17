package com.quaint.blogback.service.impl;

import com.quaint.blogback.dao.MoodMapper;
import com.quaint.blogback.pojo.Mood;
import com.quaint.blogback.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author quaint
 * @Date 2019/1/17
 */
@Component("MoodService")
public class MoodServiceImpl implements MoodService {


    @Autowired
    private MoodMapper moodMapper;

    @Override
    public int insertSelective(Mood mood) {
        return moodMapper.insertSelective(mood);
    }

    @Override
    public List<Mood> select() {
        return moodMapper.select();
    }

}
