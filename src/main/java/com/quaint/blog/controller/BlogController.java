package com.quaint.blog.controller;

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
     * 初始化界面
     * @param request
     * @param page
     * @param limit
     * @return
     */
    @GetMapping(value = "/")
    public String index(
            HttpServletRequest request,
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int page,
            @RequestParam(name = "limit", required = false, defaultValue = "5")
                    int limit
    ) {
        request.setAttribute("articles","quaint");
        return "blog/index";
    }

    /**
     * 默认界面访问
     * @return
     */
    @GetMapping(value = "{page}")
    public String showPage(@PathVariable("page") String page){
        //如果访问的是blog前台展示公共页面
        return "blog/"+page;
    }

}
