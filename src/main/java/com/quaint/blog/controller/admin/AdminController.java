package com.quaint.blog.controller.admin;

import com.quaint.blog.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 后台主页控制器，通用功能控制器，
 * @author quaint
 * @Date 2019/1/12
 */
@Controller
public class AdminController {


    /**
     * 跳转界面通用方法
     * @param page
     * @param session
     * @return
     */
    @RequestMapping("quaint/{page}")
    public String showPage(@PathVariable("page") String page, HttpSession session){

        //测试使用
        if("quaint".equals(page)){
            session.setAttribute("user",new Users());
            return "admin/main";
        }
        if("404".equals(page)){
            return "error/404";
        }
        if("500".equals(page)){
            return "error/500";
        }

        //如果用户退出，则返回登陆界面，清除登陆的用户
        if("exit".equals(page)){
            session.removeAttribute("user");
            return "admin/admin";
        }else if(session.getAttribute("user")!=null){
            //如果访问的是添加界面
            if("moodAdd".equals(page)){
                return "admin/addPage/"+page;
            }
            //如果访问的是公共页面
            return "admin/"+page;
        }else{
            //如果用户没有登陆，则跳转到登陆界面
            return "admin/admin";
        }



    }
    //测试登陆  登陆跳转界面
    @PostMapping("login")
    public String showMain(HttpSession session){
        session.setAttribute("user",new Users());
        return "admin/main";
    }


}
