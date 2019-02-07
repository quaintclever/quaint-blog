package com.quaint.blog.service.impl;

import com.quaint.blog.mapper.UsersMapper;
import com.quaint.blog.pojo.Users;
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
    private UsersMapper userMapper;

    @Override
    public Users selectByName(String userName) {
        return userMapper.selectByName(userName);
    }

    @Override
    public int insertSelective(Users user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<Users> select() {
        return userMapper.select();
    }
}
