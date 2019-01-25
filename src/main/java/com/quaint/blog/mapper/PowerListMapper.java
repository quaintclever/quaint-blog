package com.quaint.blog.mapper;

import com.quaint.blog.pojo.PowerList;
import java.util.List;

/**
 * 权限表 接口
 * quaint 2019年1月16日12:45:19
 */
public interface PowerListMapper {

    int deleteByPrimaryKey(Integer powerId);

    int insert(PowerList record);

    int insertSelective(PowerList record);

    PowerList selectByPrimaryKey(Integer powerId);

    List<PowerList> select();

    int updateByPrimaryKeySelective(PowerList record);

    int updateByPrimaryKey(PowerList record);
}