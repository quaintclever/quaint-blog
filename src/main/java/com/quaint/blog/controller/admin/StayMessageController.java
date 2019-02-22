package com.quaint.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quaint.blog.pojo.StayMessage;
import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.StayMessageService;
import com.quaint.blog.service.UserService;
import com.quaint.blog.utils.LayJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author quaint
 * @Date 2019/2/20
 */
@RequestMapping("stayMessage")
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
     * 后台分页查询 心情
     * @return 查询出来的心情
     */
    @GetMapping("data")
    public LayJson<StayMessage> select(LayJson<StayMessage> layJson, StayMessage example){
        //获取心情(未完成)
        PageHelper.startPage(layJson.getPage(), layJson.getLimit());//传入起始页与页数大小
//        layJson.setExample(example);//设置条件
        LayJson<StayMessage> list = stayMessageService.select(layJson);//带条件查询
        PageInfo page = new PageInfo(list.getData());//将用户数据封装到PageInfo 中
        layJson.setCode(0);//设置成功代码
        layJson.setCount(page.getTotal());//设置数据数量
        return layJson;
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
