package com.quaint.blogback.pojo;

/**
 * 权限表 实体类
 * quaint 2019年1月16日12:43:27
 */
public class PowerList {
    //权限id
    private Integer powerId;
    //权限名称
    private String powerName;

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName == null ? null : powerName.trim();
    }
}