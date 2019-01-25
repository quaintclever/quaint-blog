package com.quaint.blog.controller.admin;

import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.UserService;
import com.quaint.blog.utils.LayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表控制器
 * @author quaint
 * @Date 2019/1/16
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("view")
    public String view(){
        return "user";
    }

    /**
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
    /**
     * 添加
     * @return
     */
    @PostMapping("data")
    public String insertSelective(){
        Users user = new Users();
        user.setUserId(1);
        user.setUserName("quaint");
        user.setUserPwd("123465");
        userService.insertSelective(user);
        return view();
    }
    /**
     * 测试put请求  修改
     * @return
     */
    @PutMapping("dataById")
    public String updateUser(){
        //修改权限列表(未完成)
        return view();
    }

    /**
     * 测试delete  删除
     * @return
     */
    @DeleteMapping("dataById")
    public String deleteUser(){
        //删除权限列表(未完成)
        return view();
    }


}
