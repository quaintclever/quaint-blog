package com.quaint.blog.service;

import com.github.pagehelper.PageInfo;
import com.quaint.blog.pojo.StayMessage;
import com.quaint.blog.utils.LayJson;

public interface StayMessageService {

    /**
     * 记录一个留言
     * @return
     */
    int insertSelective(StayMessage stayMessage);

    /**
     * 前台分页查询留言
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<StayMessage> selectStayMessageList(int pageNo, int pageSize);

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
