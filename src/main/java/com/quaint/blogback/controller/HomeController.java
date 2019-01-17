package com.quaint.blogback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author quaint
 * @Date 2019/1/12
 */
@Controller
public class HomeController {


    //测试使用
    @RequestMapping("/test")
    public String showBack(){
        return "main";
    }
    //测试使用
    @RequestMapping("/home")
    public String showHome(){
        return "home";
    }
    //返回json 数据
    @RequestMapping("/hello")
    @ResponseBody
    public String showHello(){
        return "hello word!";
    }
    @PostMapping(value = "login")
    public String showMain(){
        return "main";
    }


}
