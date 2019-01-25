package com.quaint.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 最近访客表 实体类
 * quaint 2019年1月17日13:43:31
 */
@Data
public class Visitor {

    private Integer vId;

    private Integer visitorId;

    private Date visitorTime;

    private Integer userId;

    private String visitorIp;

}