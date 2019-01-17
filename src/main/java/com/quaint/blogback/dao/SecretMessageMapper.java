package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.SecretMessage;

import java.util.List;

public interface SecretMessageMapper {
    int deleteByPrimaryKey(Integer secretId);

    int insert(SecretMessage record);

    int insertSelective(SecretMessage record);

    SecretMessage selectByPrimaryKey(Integer secretId);

    List<SecretMessage> select();

    int updateByPrimaryKeySelective(SecretMessage record);

    int updateByPrimaryKey(SecretMessage record);
}