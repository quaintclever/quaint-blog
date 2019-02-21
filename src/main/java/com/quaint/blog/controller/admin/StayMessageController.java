package com.quaint.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.quaint.blog.pojo.StayMessage;
import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.StayMessageService;
import com.quaint.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author quaint
 * @Date 2019/2/20
 */
@RequestMapping("/stayMessage")
@RestController
public class StayMessageController {

    @Autowired
    private StayMessageService stayMessageService;
    @Autowired
    private UserService userService;

    /**
     * 前台分页查询 留言
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("selectStayMessageList")
    public PageInfo<StayMessage> selectStayMessageList(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                                                @RequestParam(value="pageSize",defaultValue="7")int pageSize){
        PageInfo<StayMessage> page = stayMessageService.selectStayMessageList(pageNo,pageSize);
        return page;
    }

    /**
     * Post     添加
     * @return 添加一个留言
     */
    @PostMapping("data")
    public Users insertSelective(@RequestBody StayMessage stayMessage){
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //从subject中获取登录的用户信息
        Users tokenUser = (Users) subject.getPrincipal();
        Users newIpUser = userService.selectByPrimaryKey(tokenUser.getUserId());
        newIpUser.setUserPwd("******");
        stayMessage.setStayUserId(newIpUser.getUserId());
        stayMessage.setStayUserIp(newIpUser.getUserLastLoginIp());
        stayMessage.setMessageStayTime(new Date());
        //这里留做扩展 ,暂时 不知道如何从ip获取地区
        stayMessage.setPlace("");
        //不是回复这里就设置成0
        stayMessage.setStayId(0);
        return stayMessageService.insertSelective(stayMessage)>0?newIpUser:new Users(-500);
    }

}
