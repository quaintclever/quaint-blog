package com.quaint.blog.controller.admin;

import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.UserService;
import com.quaint.blog.utils.IPKit;
import com.quaint.blog.utils.QuaintUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台主页控制器，通用功能控制器，
 * @author quaint
 * @Date 2019/1/12
 */
@Controller
@RequestMapping("quaint")
public class AdminController {

    @Autowired
    private UserService userService;

    //登陆  登陆跳转界面
    @PostMapping("login")
    public String login(@RequestParam String userName, @RequestParam String userPwd,@RequestParam (value="type",defaultValue="user")String type, HttpServletRequest request){

        //获取登录名称  临时
        System.out.println(userName);
        //获取登录ip
        System.out.println(IPKit.getIpAddressByRequest1(request));
        if(!"quaint".equals(userName)&&"admin".equals(type)){
            return "blog/index";
        }

        //使用shiro 来编写认证操作
        Subject subject = SecurityUtils.getSubject();
        //封住用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName,userPwd);
        //是否记住用户  暂未测试理解
        //token.setRememberMe(true);
        //执行登陆方法
        try {
            subject.login(token);
            //如果登陆成功,修改最后登录的ip
            Users loginUser = (Users) subject.getPrincipal();
            loginUser.setUserLastLoginIp(IPKit.getIpAddressByRequest1(request));
            userService.updateByPrimaryKeySelective(loginUser);
            //没有异常则登陆成功  根据类型判断在哪个系统登陆的，返回指定页面。
            if("admin".equals(type)){
                return "redirect:admin/index";
            }else if("user".equals(type)){
                return "redirect:blog/quaint-sayingYK";
            }else{
                return "blog/index";
            }
        } catch (UnknownAccountException e) {
            return "admin/login";
        } catch (IncorrectCredentialsException e){
            return "admin/login";
        }
    }

    /**
     * 注销用户功能(退出登录)
     * @return
     */
    @GetMapping(value = "exit")
    public String exit() {
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //从subject中获取登录的用户信息.
        Users user = (Users) subject.getPrincipal();
        //测试输出
        System.out.println(user.getUserName()+"正在退出...");
        //退出登录,清除用户信息.
        subject.logout();
        return "admin/login";
    }

    /**
     * 后台跳转界面通用方法1级
     * @param page
     * @return
     */
    @RequestMapping("{path}/{page}")
    public String showPage(@PathVariable("path") String path,@PathVariable("page") String page){
        return QuaintUtils.getRetrunPath(path,page);
    }
    /**
     * 后台跳转界面通用方法2级
     * @param page
     * @return
     */
    @RequestMapping("{path}/{path2}/{page}")
    public String showPage(@PathVariable("path") String path,@PathVariable("path2") String path2,@PathVariable("page") String page){
        return QuaintUtils.getRetrunPath(path,path2,page);
    }
    /**
     * 后台跳转界面通用方法 admin 下面3级页面跳转
     * @param page
     * @return
     */
    @RequestMapping("{path}/{path2}/{path3}/{page}")
    public String showPage(@PathVariable("path") String path,@PathVariable("path2") String path2,@PathVariable("path3") String path3,@PathVariable("page") String page){
        return QuaintUtils.getRetrunPath(path,path2,path3,page);
    }
    /**
     * 回到后台登陆界面
     * @return
     */
    @GetMapping("toLogin")
    public String showLogin(){
        return "admin/login";
    }


}
