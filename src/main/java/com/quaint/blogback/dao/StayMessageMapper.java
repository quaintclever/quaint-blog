package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.StayMessage;

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