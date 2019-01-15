package com.quaint.blogback.pojo;

import java.util.Date;

public class Visitor {
    private Integer vId;

    private Integer visitorId;

    private Date visitorTime;

    private Integer userId;

    private String visitorIp;

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Date getVisitorTime() {
        return visitorTime;
    }

    public void setVisitorTime(Date visitorTime) {
        this.visitorTime = visitorTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVisitorIp() {
        return visitorIp;
    }

    public void setVisitorIp(String visitorIp) {
        this.visitorIp = visitorIp == null ? null : visitorIp.trim();
    }
}