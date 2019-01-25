package com.quaint.blog.service;

import com.quaint.blog.pojo.PowerList;

import java.util.List;

/**
 * 权限类表业务层 接口
 * quaint 2019年1月16日12:56:16
 */
public interface PowerListService {

    /**
     * 增加一个权限列表
     * @param power
     * @return
     */
    int insertSelective(PowerList power);

    /**
     * 查询全部权限列表
     * @return
     */
    List<PowerList> select();

}
