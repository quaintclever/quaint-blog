package com.quaint.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 留言实体类
 */
@Data
public class StayMessage {
    private Integer sId;

    private Integer stayId;

    private Integer stayUserId;

    private String messageContent;

    private String stayUserIp;

    private Date messageStayTime;

    private String place;

    //--------扩展字段------------

    private String userName;

    private String userNickName;

    public StayMessage() {
    }

    public StayMessage(Integer sId) {
        this.sId = sId;
    }
}