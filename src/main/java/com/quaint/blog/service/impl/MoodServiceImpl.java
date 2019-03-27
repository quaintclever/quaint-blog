package com.quaint.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quaint.blog.mapper.MoodMapper;
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
    public Mood selectByPrimaryKey(Integer moodId) {
        return moodMapper.selectByPrimaryKey(moodId);
    }

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

    @Override
    public int updateByPrimaryKeySelective(Mood record) {
        return moodMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Mood selectNewMood() {
        return moodMapper.selectNewMood();
    }
    @Override
    public PageInfo<Mood> selectMoodList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Mood> list = moodMapper.select(); //用PageInfo对结果进行包装
        PageInfo<Mood> page = new PageInfo<Mood>(list);
        return page;
    }
}
