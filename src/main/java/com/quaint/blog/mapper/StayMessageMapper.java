package com.quaint.blog.mapper;

import com.quaint.blog.pojo.StayMessage;

import java.util.List;

public interface StayMessageMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(StayMessage record);

    int insertSelective(StayMessage record);

    StayMessage selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(StayMessage record);

    int updateByPrimaryKey(StayMessage record);

    List<StayMessage> select();
}