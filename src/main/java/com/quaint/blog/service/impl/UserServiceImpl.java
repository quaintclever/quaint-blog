package com.quaint.blog.service.impl;

import com.quaint.blog.dao.UserMapper;
import com.quaint.blog.pojo.User;
import com.quaint.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author quaint
 * @Date 2019/1/16
 */
@Component("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> select() {
        return userMapper.select();
    }
}
