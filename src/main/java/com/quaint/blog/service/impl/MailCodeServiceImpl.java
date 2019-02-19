package com.quaint.blog.service.impl;

import com.quaint.blog.mapper.MailCodeMapper;
import com.quaint.blog.pojo.MailCode;
import com.quaint.blog.service.MailCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MailCodeService")
public class MailCodeServiceImpl implements MailCodeService {

    @Autowired
    private MailCodeMapper mailCodeMapper;

    @Override
    public int insert(MailCode mailCode) {
        return mailCodeMapper.insertSelective(mailCode);
    }

    @Override
    public int update(MailCode mailCode) {
        return mailCodeMapper.updateByPrimaryKeySelective(mailCode);
    }

    @Override
    public MailCode selectByMail(String mail) {
        return mailCodeMapper.selectByMail(mail);
    }
}
