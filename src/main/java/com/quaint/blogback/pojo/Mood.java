package com.quaint.blogback.pojo;

import java.util.Date;

/**
 * 用户心情说说表 实体类
 * quaint 2019年1月17日13:43:48
 */
public class Mood {
    private Integer moodId;

    private Integer userId;

    private Date moodTime;

    private String moodIp;

    private String moodContent;

    private Byte typeId;

    public Integer getMoodId() {
        return moodId;
    }

    public void setMoodId(Integer moodId) {
        this.moodId = moodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getMoodTime() {
        return moodTime;
    }

    public void setMoodTime(Date moodTime) {
        this.moodTime = moodTime;
    }

    public String getMoodIp() {
        return moodIp;
    }

    public void setMoodIp(String moodIp) {
        this.moodIp = moodIp == null ? null : moodIp.trim();
    }

    public String getMoodContent() {
        return moodContent;
    }

    public void setMoodContent(String moodContent) {
        this.moodContent = moodContent == null ? null : moodContent.trim();
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }
}