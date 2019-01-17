package com.quaint.blogback.controller;

import com.quaint.blogback.pojo.Mood;
import com.quaint.blogback.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 权限表控制器
 * @author quaint
 * @Date 2019/1/16
 */
@RequestMapping("/mood")
@Controller
public class MoodController {

    @Autowired
    private MoodService moodService;

    /**
     * 测试get     查询
     * @return 查询出来的权限列表
     */
    @GetMapping("data")
    public ModelAndView select(){
        //获取权限列表(未完成)
        ModelAndView mav = new ModelAndView ();
        mav.addObject("list", moodService.select());
        mav.setViewName("mood");
        return mav;
    }
    /**
     * 测试Post    添加
     * @return 添加一个权限列表
     */
    @PostMapping("data")
    public ModelAndView insertSelective(){
        Mood mood = new Mood();
        mood.setMoodContent("lombok mood test");
        mood.setUserId(1);
        mood.setMoodIp("127.0.0.1");
        mood.setMoodTime(new Date());
        moodService.insertSelective(mood);
        return select();
    }
    /**
     * 测试put请求  修改
     * @return
     */
    @PutMapping("dataById")
    public ModelAndView updateMood(){
        //修改权限列表(未完成)
        return select();
    }

    /**
     * 测试delete  删除
     * @return
     */
    @DeleteMapping("dataById")
    public ModelAndView deleteMood(){
        //删除权限列表(未完成)
        return select();
    }
    /**
     * 测试get     通过id查询
     * @return
     */
    @GetMapping("dataById")
    public ModelAndView getMoodById(){
        //通过id查询(未完成)
        ModelAndView mav = new ModelAndView ();
        mav.addObject("list", moodService.select());
        mav.setViewName("mood");
        return mav;
    }

}
