package com.quaint.blog.controller.admin;

import com.quaint.blog.base.Msg;
import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.UserService;
import com.quaint.blog.utils.LayJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表控制器
 * @author quaint
 * @Date 2019/1/16
 */
@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 同过主键id查询用户
     * @return
     */
    @GetMapping("dataById")
    public Users selectByPrimaryKey(Integer id){
        return userService.selectByPrimaryKey(id);
    }

    /**
     * 获取当前用户登录信息
     * 也可以直接调用BlogController 下的isLogin 方法
     * @return
     */
    @GetMapping("getLoginUser")
    public Users getLoginUser(){
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //从subject中获取登录的用户信息.
        Users user = (Users) subject.getPrincipal();
        //返回数据库中最新的用户信息
        Users user_new = userService.selectByPrimaryKey(user.getUserId());
        //消除用户密码
        user_new.setUserPwd("*******");
        return user_new;
    }

    /**
     * 修改用户信息
     * @return
     */
    @PutMapping("dataById")
    public Msg updateUser(@RequestBody Users users){
        return userService.updateByPrimaryKeySelective(users)>0
                ?Msg.getInstanceWithText("修改用户信息成功！")
                :Msg.getInstanceWithText("用户信息修改失败！");
    }

    /**
     * ------------------下面暂时未使用到---------------------
     * 查询
     * @return
     */
    @GetMapping("data")
    @ResponseBody
    public LayJson<Users> select(){
        //获取用户(未完成)
        LayJson<Users> list = new LayJson<>();
        list.setData(userService.select());
        return list;
    }


}
