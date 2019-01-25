package com.quaint.blog.mapper;

import com.quaint.blog.pojo.Visitor;

import java.util.List;

public interface VisitorMapper {
    int deleteByPrimaryKey(Integer vId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer vId);

    List<Visitor> select();

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);
}