package com.quaint.blogback.controller;

import com.quaint.blogback.pojo.Mood;
import com.quaint.blogback.service.MoodService;
import com.quaint.blogback.util.LayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 说说控制器
 * @author quaint
 * @Date 2019/1/16
 */
@RequestMapping("/mood")
@RestController
public class MoodController {

    @Autowired
    private MoodService moodService;

    /**
     * 测试get     查询
     * @return 查询出来的心情
     */
    @GetMapping("data")
    public LayJson<Mood> select(){
        //获取心情(未完成)
        LayJson<Mood> list = new LayJson<>();
        list.setData(moodService.select());
        return list;
    }
    /**
     * 测试Post    添加
     * @return 添加一个心情
     */
    @PostMapping("data/{userId}/{moodContent}")
    public String insertSelective(
            @PathVariable("userId") Integer userId,
            @PathVariable("moodContent") String moodContent ){
        Mood mood = new Mood();
        mood.setMoodContent(moodContent);
        mood.setUserId(userId);
        mood.setMoodIp("127.0.0.1");
        mood.setMoodTime(new Date());
        moodService.insertSelective(mood);
        return "ok";
    }
    /**
     * 测试put请求  修改
     * @return
     */
    @PutMapping("dataById")
    public void updateMood(){
        //修改权限列表(未完成)
    }

    /**
     * 测试delete  删除
     * @return
     */
    @DeleteMapping("dataById")
    public void deleteMood(){
        //删除权限列表(未完成)
    }


}
