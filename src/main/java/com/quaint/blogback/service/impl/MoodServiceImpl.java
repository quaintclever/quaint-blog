package com.quaint.blogback.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quaint.blogback.dao.MoodMapper;
import com.quaint.blogback.pojo.Mood;
import com.quaint.blogback.service.MoodService;
import com.quaint.blogback.util.LayJson;
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
    public LayJson<Mood> select(LayJson<Mood> layJson) {
        //暂时先查询全部  下面先不传参数
        //Mood mood = layJson.getExample();
        List<Mood> list =moodMapper.select();
        //设置查询出来的全部数据
        layJson.setData(list);
        return layJson;
    }

    @Override
    public int deleteByPrimaryKey(Integer moodId) {
        return moodMapper.deleteByPrimaryKey(moodId);
    }

}
