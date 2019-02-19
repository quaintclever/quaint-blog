package com.quaint.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 邮箱验证码实体类
 */
@Data
public class MailCode {
    private Integer mcId;

    private String emailUrl;

    private String emailCode;

    private Date createTime;

    public MailCode(String emailUrl, String emailCode, Date createTime) {
        this.emailUrl = emailUrl;
        this.emailCode = emailCode;
        this.createTime = createTime;
    }

    public MailCode() {
    }
}