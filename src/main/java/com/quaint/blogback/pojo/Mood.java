package com.quaint.blogback.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户心情说说表 实体类
 * quaint 2019年1月17日13:43:48
 */
@Data
public class Mood {

    private Integer moodId;     //说说id

    private Integer userId;     //发布的用户

    private Date moodTime;      //发布说说的时间

    private String moodIp;      //发布说说的ip

    private String moodContent; //说说内容

    private Byte typeId;    //隐私id

}