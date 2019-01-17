package com.quaint.blogback.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 用户评论表 实体类
 * quaint 2019年1月17日13:43:17
 */
@Data
public class UserComment {

    private Integer cId;

    private Integer userId;

    private Integer blogId;

    private Integer commitId;

    private String commitContent;

    private Integer commitUserId;

    private Date commitTime;

    private String commitIp;

}