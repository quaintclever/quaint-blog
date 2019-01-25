package com.quaint.blog.dao;

import com.quaint.blog.pojo.StayMessage;

import java.util.List;

public interface StayMessageMapper {
    int deleteByPrimaryKey(Integer stayId);

    int insert(StayMessage record);

    int insertSelective(StayMessage record);

    StayMessage selectByPrimaryKey(Integer stayId);

    List<StayMessage> select();

    int updateByPrimaryKeySelective(StayMessage record);

    int updateByPrimaryKey(StayMessage record);
}