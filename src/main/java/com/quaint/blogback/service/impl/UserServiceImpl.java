package com.quaint.blogback.service.impl;

import com.quaint.blogback.dao.PowerListMapper;
import com.quaint.blogback.dao.UserMapper;
import com.quaint.blogback.pojo.PowerList;
import com.quaint.blogback.pojo.User;
import com.quaint.blogback.service.PowerListService;
import com.quaint.blogback.service.UserService;
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
