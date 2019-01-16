package com.quaint.blogback.controller;

import com.quaint.blogback.pojo.PowerList;
import com.quaint.blogback.service.PowerListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 权限表控制器
 * @author quaint
 * @Date 2019/1/16
 */
@Controller
public class PowerListController {

    @Autowired
    private PowerListService powerListService;

    //测试添加
    @RequestMapping("addPowerList")
    @ResponseBody
    public String addPowerList(){
        PowerList pl = new PowerList();
        pl.setPowerName("test");
        int test = powerListService.addPowerList(pl);
        return test>0?"ok":"error";
    }



}
