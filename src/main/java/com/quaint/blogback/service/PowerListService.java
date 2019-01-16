package com.quaint.blogback.service;

import com.quaint.blogback.pojo.PowerList;

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
    public int addPowerList(PowerList power);

}
