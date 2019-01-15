package com.quaint.blogback.dao;

import com.quaint.blogback.pojo.SecretMessage;

public interface SecretMessageMapper {
    int deleteByPrimaryKey(Integer secretId);

    int insert(SecretMessage record);

    int insertSelective(SecretMessage record);

    SecretMessage selectByPrimaryKey(Integer secretId);

    int updateByPrimaryKeySelective(SecretMessage record);

    int updateByPrimaryKey(SecretMessage record);
}