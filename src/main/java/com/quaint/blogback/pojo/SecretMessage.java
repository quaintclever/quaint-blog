package com.quaint.blogback.pojo;

import lombok.Data;

/**
 * 用户私信表 实体类
 * quaint 2019年1月17日13:42:31
 */
@Data
public class SecretMessage {

    private Integer secretId;

    private Integer sendId;

    private Integer receiveId;

    private String messageTopic;

    private String messageContent;

}