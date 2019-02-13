package com.quaint.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quaint.blog.pojo.Mood;
import com.quaint.blog.service.MoodService;
import com.quaint.blog.utils.LayJson;
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
     * 后台分页查询 心情
     * @return 查询出来的心情
     */
    @GetMapping("data")
    public LayJson<Mood> select(LayJson<Mood> layJson, Mood example){
        //获取心情(未完成)
        PageHelper.startPage(layJson.getPage(), layJson.getLimit());//传入起始页与页数大小
//        layJson.setExample(example);//设置条件
        LayJson<Mood> list = moodService.select(layJson);//带条件查询
        PageInfo page = new PageInfo(list.getData());//将用户数据封装到PageInfo 中
        layJson.setCode(0);//设置成功代码
        layJson.setCount(page.getTotal());//设置数据数量
        return layJson;
    }

    /**
     * 前台分页查询 心情
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("selectMoodList")
    public PageInfo<Mood> selectMoodList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                                    @RequestParam(value="pageSize",defaultValue="7")int pageSize){
        PageInfo<Mood> page = moodService.selectMoodList(pageNo,pageSize);
        return page;
    }

    /**
     * 前台 查询最新发表的心情说说
     * old blog使用
     * @return
     */
    @GetMapping("selectNewMood")
    public Mood selectNewMood(){
        Mood mood = moodService.selectNewMood();
        return mood;
    }

    /**
     * 测试Post    添加
     * @return 添加一个心情
     */
    @PostMapping("data")
    public String insertSelective(@RequestBody Mood mood){
        mood.setMoodIp("127.0.0.1");
        mood.setMoodTime(new Date());
        return moodService.insertSelective(mood)>0?"ok":"error";
    }
    /**
     * 测试put请求  修改
     * @return
     */
    @PutMapping("dataById/{moodId}")
    public void updateMood(@PathVariable("moodId") Integer moodId){
        //修改心情(未完成)
        System.out.println(moodId);
    }

    /**
     * 测试delete  删除
     * @return
     */
    @DeleteMapping("dataById/{moodId}")
    public String deleteMood(@PathVariable("moodId") Integer moodId){
        //删除心情(未完成)
        return moodService.deleteByPrimaryKey(moodId)>0?"ok":"error";
    }


}
