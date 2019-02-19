package com.quaint.blog.service;

import com.quaint.blog.pojo.MailCode;

public interface MailCodeService {

    /**
     * 记录一个邮箱
     * @return
     */
    int insert(MailCode mailCode);

    /**
     * 修改一个邮箱验证码
     * @return
     */
    int update(MailCode mailCode);

    /**
     * 查询该邮箱的验证码
     * @param mail
     * @return
     */
    MailCode selectByMail(String mail);

}
