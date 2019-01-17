package com.quaint.blogback.pojo;

/**
 * 用户关注表  实体类
 * quaint 2019年1月17日13:51:08
 */
public class UserAttention {
    private Integer aId;

    private Integer userId;

    private Integer attentionId;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(Integer attentionId) {
        this.attentionId = attentionId;
    }
}