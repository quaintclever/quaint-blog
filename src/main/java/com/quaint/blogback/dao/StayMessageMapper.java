package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.StayMessage;

public interface StayMessageMapper {
    int deleteByPrimaryKey(Integer stayId);

    int insert(StayMessage record);

    int insertSelective(StayMessage record);

    StayMessage selectByPrimaryKey(Integer stayId);

    int updateByPrimaryKeySelective(StayMessage record);

    int updateByPrimaryKey(StayMessage record);
}