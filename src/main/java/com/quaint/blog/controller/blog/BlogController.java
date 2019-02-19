package com.quaint.blog.controller.blog;

import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.UserService;
import com.quaint.blog.utils.IPKit;
import com.quaint.blog.utils.JavaMailUtil;
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
import java.util.Date;

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


    /**
     * 添加
     * @return
     */
    @PostMapping("register")
    @ResponseBody
    public Users insertSelective(@RequestBody Users user, HttpServletRequest request){
        //获取用户ip地址,并设置给user
        String registerIP = IPKit.getIpAddressByRequest1(request);
        user.setUserRegisterIp(registerIP);
        //设置注册时间
        user.setUserRegisterTime(new Date());
        //默认昵称为账号
        user.setUserNickName(user.getUserName());
        //默认签名
        user.setUserSays("这家伙很懒,什么都没留下.");
        user.setUserLastLoginIp(registerIP);
        //TODO 这里 需要与邮件的验证码验证
        if(!"1234".equals(user.getCode()+"")){
            return new Users(-501);
        }else{
            userService.insertSelective(user);
            //注册完成自动登录
            return login(user.getUserName(),user.getUserPwd(),"old",request);
        }

    }
    /**
     * 发送验证码到邮箱
     * @return
     */
    @PostMapping("sendCode/{email}")
    @ResponseBody
    public Users sendCode(@PathVariable("email") String email){
        //获取一个4位的验证码
        String code = QuaintUtils.getCode(4);
        System.out.println(email);
        try {
            JavaMailUtil.sendCode(email,code);
        } catch (Exception e) {
            e.printStackTrace();
            return new Users(-701);
        }
        //TODO  考虑 存储验证码 用来做判断 例如redis 或者 数据库
        return new Users(-200,code);
    }
    //测试登陆  登陆跳转界面
    @PostMapping("login")
    @ResponseBody
    public Users login(@RequestParam String userName, @RequestParam String userPwd,@RequestParam (value="type",defaultValue="new")String type, HttpServletRequest request){

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
            //返回前台数据时把 密码去掉
            loginUser.setUserPwd("******");
            return loginUser;
        } catch (UnknownAccountException e) {
            System.out.println("404,博客用户名不存在！");
            return new Users(-404);
        } catch (IncorrectCredentialsException e){
            System.out.println("500,博客密码错误！");
            return new Users(-500);
        }
    }

    /**
     * 注销用户功能(退出登录)
     * @return
     */
    @GetMapping(value = "exit")
    @ResponseBody
    public Users exit() {
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //从subject中获取登录的用户信息.
//        Users user = (Users) subject.getPrincipal();
        //测试输出
//        System.out.println(user.getUserName()+"正在退出...");
        //退出登录,清除用户信息.
        subject.logout();
        return new Users(-200);
    }

}
