package com.quaint.blogback.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户个人信息实体类
 * quaint 2019年1月17日13:40:25
 */
@Data
public class User {

    private Integer userId;

    private String userName;

    private String userPwd;

    private String userEmail;

    private String userImageUrl;

    private String userNickName;

    private String userSays;

    private String userPhone;

    private Byte userSex;

    private String userQq;

    private String userAddress;

    private String userLastLoginIp;

    private Date userBirthday;

    private String userDescription;

    private String userSchool;

    private Date userRegisterTime;

    private String userRegisterIp;

    private Byte userLock;

    private Byte userFreeze;

    private Byte userRank;

}