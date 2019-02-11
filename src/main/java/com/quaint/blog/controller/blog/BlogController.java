package com.quaint.blog.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 博客前台控制器
 * @author quaint
 * @Date 2019/1/24
 */
@Controller
public class BlogController {

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
}
