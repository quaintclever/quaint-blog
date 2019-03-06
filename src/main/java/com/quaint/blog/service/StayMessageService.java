package com.quaint.blog.service;

import com.github.pagehelper.PageInfo;
import com.quaint.blog.pojo.StayMessage;
import com.quaint.blog.utils.LayJson;

import java.util.List;

public interface StayMessageService {

    /**
     * 记录一个留言
     * @return
     */
    int insertSelective(StayMessage stayMessage);

    /**
     * 通过id查询留言
     * @param sId
     * @return
     */
    StayMessage selectByPrimaryKey(Integer sId);
    /**
     * 前台分页查询留言
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<StayMessage> selectStayMessageList(int pageNo, int pageSize);

    /**
     * 查询全部留言回复
     * @return留言留言dto集合对象
     */
    List<StayMessage> selectByRe(Integer sid);

    /**
     * 后台查询全部留言
     * @return
     */
    LayJson<StayMessage> select(LayJson<StayMessage> layJson);

    /**
     * 通过id删除留言
     * @param sId
     * @return
     */
    int deleteByPrimaryKey(Integer sId);

    /**
     * 修改留言内容
     * @param stayMessage
     * @return
     */
    int updateByPrimaryKeySelective(StayMessage stayMessage);
}
