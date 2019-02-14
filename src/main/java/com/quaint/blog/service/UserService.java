package com.quaint.blog.service;

import com.quaint.blog.pojo.Users;

import java.util.List;

/**
 * 用户信息处理业务层
 */
public interface UserService {

    /**
     * 通过用户名查询用户信息
     * @param userName
     * @return
     */
    Users selectByName(String userName);
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

    /**
     * 通过主键修改属性不为空的user 信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     * 通过主键查询用户
     * @param userId
     * @return
     */
    Users selectByPrimaryKey(Integer userId);
}
