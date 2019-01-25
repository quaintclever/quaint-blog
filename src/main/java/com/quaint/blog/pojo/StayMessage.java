package com.quaint.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户留言表 实体类
 * quaint 2019年1月17日13:42:47
 */
@Data
public class StayMessage {

    private Integer stayId;

    private Integer userId;

    private Integer stayUserId;

    private String messageContent;

    private String stayUserIp;

    private Date messageStayTime;

    private String place;

}