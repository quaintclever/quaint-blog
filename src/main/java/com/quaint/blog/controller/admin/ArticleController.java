package com.quaint.blog.controller.admin;

import com.quaint.blog.pojo.Article;
import com.quaint.blog.pojo.Mood;
import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.ArticleService;
import com.quaint.blog.service.MoodService;
import com.quaint.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    public ArticleService articleService;
    @Autowired
    private MoodService moodService;
    @Autowired
    private UserService userService;
    /**
     * Post添加
     * @return 添加一个文章
     */
    @PostMapping("data")
    @ResponseBody
    public String insertSelective(@RequestBody Article article){
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //从subject中获取登录的用户信息
        Users tokenUser = (Users) subject.getPrincipal();
        Users newIpUser = userService.selectByPrimaryKey(tokenUser.getUserId());

        if(articleService.insertSelective(article)>0){
            Mood mood = new Mood();
            mood.setUserId(newIpUser.getUserId());
            mood.setUserName(newIpUser.getUserName());
            mood.setMoodIp(newIpUser.getUserLastLoginIp());
            mood.setMoodTime(new Date());
            mood.setMoodContent(article.getMoodContent());
            mood.setArticleId(article.getArticleId());
            if(moodService.insertSelective(mood)>0){
                return "ok";
            }else{
                return "error";
            }
        }else{
            return "error";
        }
    }

    /**
     * 获取文章内容
     * @param moodId 心情id
     * @param modelMap  返回数据映射
     * @return
     */
    @GetMapping("dataById/{moodId}")
    public String getArticleById(@PathVariable("moodId") Integer moodId, ModelMap modelMap){
        //获取该文章对应的说说
        Mood mood = moodService.selectByPrimaryKey(moodId);
        if(mood!=null){
            //获取文章id对应的文章
            Article article = articleService.selectByPrimaryKey(mood.getArticleId());
            //防止用户修改超链接地址 使得文章为空
            if(article==null){
                //重定向到主页
                return "redirect:/quaint-home";
            }
            //获取该文章的博主信息
            Users user = userService.selectByPrimaryKey(mood.getUserId());
            modelMap.addAttribute("article", article);
            modelMap.addAttribute("mood", mood);
            modelMap.addAttribute("user", user);
            return "blog/quaint-article";
        }else{
            //重定向到主页
            return "redirect:/quaint-home";
        }
    }

}
