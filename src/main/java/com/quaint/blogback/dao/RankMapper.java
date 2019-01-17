package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.Rank;

import java.util.List;

public interface RankMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Rank record);

    int insertSelective(Rank record);

    Rank selectByPrimaryKey(Integer rId);

    List<Rank> select();

    int updateByPrimaryKeySelective(Rank record);

    int updateByPrimaryKey(Rank record);
}