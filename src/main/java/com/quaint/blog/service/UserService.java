package com.quaint.blog.service;

import com.quaint.blog.pojo.Users;

import java.util.List;

public interface UserService {

    /**
     * 增加一个用户
     * @param user
     * @return
     */
    int insertSelective(Users user);

    /**
     * 查询全部用户
     * @return
     */
    List<Users> select();

}
