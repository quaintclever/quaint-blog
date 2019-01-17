package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.PowerList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 权限表 接口
 * quaint 2019年1月16日12:45:19
 */
@Mapper
@Component("PowerListMapper")
public interface PowerListMapper {

    int deleteByPrimaryKey(Integer powerId);

    int insert(PowerList record);

    int insertSelective(PowerList record);

    PowerList selectByPrimaryKey(Integer powerId);

    List<PowerList> select();

    int updateByPrimaryKeySelective(PowerList record);

    int updateByPrimaryKey(PowerList record);
}