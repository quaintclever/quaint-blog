package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.PowerList;

public interface PowerListMapper {
    int deleteByPrimaryKey(Integer powerId);

    int insert(PowerList record);

    int insertSelective(PowerList record);

    PowerList selectByPrimaryKey(Integer powerId);

    int updateByPrimaryKeySelective(PowerList record);

    int updateByPrimaryKey(PowerList record);
}