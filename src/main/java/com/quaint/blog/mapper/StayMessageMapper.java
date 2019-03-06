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
    /**
     * 查询全部留言
     * @return留言dto集合对象
     */
    List<StayMessage> select();
    /**
     * 查询全部留言回复
     * @return留言留言dto集合对象
     */
    List<StayMessage> selectByRe(Integer sid);
}