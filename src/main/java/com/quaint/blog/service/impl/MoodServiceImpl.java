package com.quaint.blog.service.impl;

import com.quaint.blog.dao.MoodMapper;
import com.quaint.blog.pojo.Mood;
import com.quaint.blog.service.MoodService;
import com.quaint.blog.utils.LayJson;
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
