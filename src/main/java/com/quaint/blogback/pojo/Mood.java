package com.quaint.blogback.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户心情说说表 实体类
 * quaint 2019年1月17日13:43:48
 */
@Data
public class Mood {

    private Integer moodId;

    private Integer userId;

    private Date moodTime;

    private String moodIp;

    private String moodContent;

    private Byte typeId;

}