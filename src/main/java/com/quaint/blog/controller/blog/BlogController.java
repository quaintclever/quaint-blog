package com.quaint.blog.controller.blog;

import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.UserService;
import com.quaint.blog.utils.IPKit;
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
 * 博客前台控制器
 * @author quaint
 * @Date 2019/1/24
 */
@Controller
public class BlogController {

    @Autowired
    private UserService userService;
    /**
     * 初始化新博客界面
     * @return
     */
    @GetMapping(value = "/")
    public String index() {
        return "blogtemp/index";
    }

    /**
     * 默认新博客界面访问
     * @return
     */
    @GetMapping(value = "{page}.html")
    public String showPage(@PathVariable("page") String page){
        //如果访问的是blog前台展示公共页面
        return "blogtemp/"+page;
    }

    /**
     * 进入旧版本的控制器
     * @return
     */
    @GetMapping(value = "/old")
    public String oldIndex() {
        return "blog/index";
    }

    /**
     * 旧版本页面跳转使用不带.html的页面
     * @param page
     * @return
     */
    @GetMapping(value = "{page}")
    public String showOldPage(@PathVariable("page") String page){
        //如果访问的是blog前台展示公共页面
        return "blog/"+page;
    }

    //测试登陆  登陆跳转界面
    @PostMapping("login")
    @ResponseBody
    public String login(@RequestParam String userName, @RequestParam String userPwd,@RequestParam (value="type",defaultValue="new")String type, HttpServletRequest request){

        //使用shiro 来编写认证操作
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
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
            return "ok";
        } catch (UnknownAccountException e) {
            System.out.println("博客用户名不存在！");
            return "用户名不存在！";
        } catch (IncorrectCredentialsException e){
            System.out.println("博客密码错误！");
            return "密码错误！";
        }
    }

}
