package com.quaint.blogback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author quaint
 * @Date 2019/1/12
 */
@Controller
public class HomeController {


    //测试使用  直接进入后台
    @RequestMapping("test")
    public String showBack(){
        return "main";
    }
    //测试使用  主页显示界面
    @RequestMapping("home")
    public String showHome(){
        return "home";
    }
    //测试退出  退出返回界面
    @RequestMapping(value={"exit","admin"})
    public String showHello(){
        return "admin";
    }
    //测试登陆  登陆跳转界面
    @PostMapping("login")
    public String showMain(){
        return "main";
    }


}
