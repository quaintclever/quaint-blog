package com.quaint.blogback.pojo;

/**
 * 好友表 实体类
 * quaint 2019年1月17日13:41:40
 */
public class Friend {
    private Integer fId;

    private Integer userId;

    private Integer friendId;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }
}