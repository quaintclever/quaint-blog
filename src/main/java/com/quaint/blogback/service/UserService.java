package com.quaint.blogback.service;

import com.quaint.blogback.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 增加一个用户
     * @param user
     * @return
     */
    int insertSelective(User user);

    /**
     * 查询全部用户
     * @return
     */
    List<User> select();

}
