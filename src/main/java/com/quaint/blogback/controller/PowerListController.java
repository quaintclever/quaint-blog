package com.quaint.blogback.controller;

import com.quaint.blogback.pojo.PowerList;
import com.quaint.blogback.service.PowerListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限表控制器
 * @author quaint
 * @Date 2019/1/16
 */
@RequestMapping("/powerList")
@Controller
public class PowerListController {

    @Autowired
    private PowerListService powerListService;

    /**
     * 测试get     查询
     * @return 查询出来的权限列表
     */
    @GetMapping("data")
    public ModelAndView select(){
        //获取权限列表(未完成)
        ModelAndView mav = new ModelAndView ();
        mav.addObject("list", powerListService.select());
        mav.setViewName("powerList");
        return mav;
    }
    /**
     * 测试Post    添加
     * @return 添加一个权限列表
     */
    @PostMapping("data")
    public String insertSelective(){
        PowerList pl = new PowerList();
        pl.setPowerName("test");
        powerListService.insertSelective(pl);
        return "main";
    }
    /**
     * 测试put请求  修改
     * @return
     */
    @PutMapping("dataById")
    public String updatePowerList(){
        //修改权限列表(未完成)
        return "main";
    }

    /**
     * 测试delete  删除
     * @return
     */
    @DeleteMapping("dataById")
    public String deletePowerList(){
        //删除权限列表(未完成)
        return "main";
    }
    /**
     * 测试get     通过id查询
     * @return
     */
    @GetMapping("dataById")
    public String getPowerListById(){
        //通过id查询(未完成)
        return "main";
    }

}
