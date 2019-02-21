package com.quaint.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quaint.blog.mapper.StayMessageMapper;
import com.quaint.blog.pojo.StayMessage;
import com.quaint.blog.service.StayMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 留言实现类
 * @author quaint
 * @Date 2019/2/20
 */
@Component("StayMessageService")
public class StayMessageServiceImpl implements StayMessageService {

    @Autowired
    private StayMessageMapper stayMessageMapper;

    @Override
    public int insertSelective(StayMessage stayMessage) {
        return stayMessageMapper.insertSelective(stayMessage);
    }

    @Override
    public PageInfo<StayMessage> selectStayMessageList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<StayMessage> list = stayMessageMapper.select(); //用PageInfo对结果进行包装
        PageInfo<StayMessage> page = new PageInfo<StayMessage>(list);
        return page;
    }
}
