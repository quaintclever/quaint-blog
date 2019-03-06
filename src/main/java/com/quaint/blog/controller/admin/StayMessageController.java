package com.quaint.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quaint.blog.base.Msg;
import com.quaint.blog.pojo.StayMessage;
import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.StayMessageService;
import com.quaint.blog.service.UserService;
import com.quaint.blog.utils.JavaMailUtil;
import com.quaint.blog.utils.LayJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
     * 留言回复展示
     * @return
     */
    @GetMapping("selectReMessageList")
    public List<StayMessage> selectReMessageList(@RequestParam(value="sid") Integer sid){
        List<StayMessage> reMessageList = stayMessageService.selectByRe(sid);
        return reMessageList;
    }

    /**
     * 后台分页查询 留言
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
        //如果不是留言而是回复,则给被回复的用户发送邮件提醒
        Integer stayId = stayMessage.getStayId();
        if(stayId!=null){
            //通过留言id查询用户,获取邮箱,并发送提示信息
            StayMessage getEmail = stayMessageService.selectByPrimaryKey(stayId);
            Users re2user = userService.selectByPrimaryKey(getEmail.getStayUserId());
            //如果是其他人回复自己,则发送邮件
            if(re2user.getUserId()!=tokenUser.getUserId()){
                //给该用户发送邮件提醒留言已经被回复
                try {
                    JavaMailUtil.sendReRemind(re2user.getUserEmail(),stayMessage.getMessageContent());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return stayMessageService.insertSelective(stayMessage)>0?newIpUser:new Users(-500);
    }

    /**
     * delete  删除
     * @return
     */
    @DeleteMapping("dataById/{sId}")
    public Msg deleteStayMessage(@PathVariable("sId") Integer sId){
        return stayMessageService.deleteByPrimaryKey(sId)>0?Msg.getInstanceWithText("ok"):Msg.getInstanceWithText("error");
    }
    /**
     * update  修改
     * @return
     */
    @PutMapping("dataById")
    public Msg updateStayMessage(@RequestBody StayMessage stayMessage){
        return stayMessageService.updateByPrimaryKeySelective(stayMessage)>0?Msg.getInstanceWithText("ok"):Msg.getInstanceWithText("error");
    }

}
