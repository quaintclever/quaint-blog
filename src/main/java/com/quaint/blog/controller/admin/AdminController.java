package com.quaint.blog.controller.admin;

import com.quaint.blog.utils.QuaintUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 后台主页控制器，通用功能控制器，
 * @author quaint
 * @Date 2019/1/12
 */
@Controller
@RequestMapping("quaint")
public class AdminController {


    //测试登陆  登陆跳转界面
    @PostMapping("login")
    public String login(@RequestParam String userName,@RequestParam String userPwd){

        System.out.println(userName);
        //使用shiro 来编写认证操作
        Subject subject = SecurityUtils.getSubject();
        //封住用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName,userPwd);
        //执行登陆方法
        try {
            subject.login(token);
            //没有异常则登陆成功
            return "redirect:admin/main";
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在！");
            return "admin/login";
        } catch (IncorrectCredentialsException e){
            System.out.println("密码错误！");
            return "admin/login";
        }
    }

    /**
     * 后台跳转界面通用方法
     * @param page
     * @return
     */
    @RequestMapping("{path}/{page}")
    public String showPage(@PathVariable("path") String path,@PathVariable("page") String page){
        return QuaintUtils.getRetrunPath(path,page);
    }
    /**
     * 后台跳转界面通用方法
     * @param page
     * @return
     */
    @RequestMapping("{path}/{path2}/{page}")
    public String showPage(@PathVariable("path") String path,@PathVariable("path2") String path2,@PathVariable("page") String page){
        return QuaintUtils.getRetrunPath(path,path2,page);
    }
    /**
     * 回到后台登陆界面
     * @return
     */
    @GetMapping("toLogin")
    public String showLogin(){
        return "/admin/login";
    }


}
