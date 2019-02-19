package com.quaint.blog.mapper;

import com.quaint.blog.pojo.MailCode;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface MailCodeMapper {
    int deleteByPrimaryKey(Integer mcId);

    int insert(MailCode record);

    int insertSelective(MailCode record);

    MailCode selectByPrimaryKey(Integer mcId);

    int updateByPrimaryKeySelective(MailCode record);

    int updateByPrimaryKey(MailCode record);

    /**
     * 查询最新的mood
     * @return
     */
    @Results({
            @Result( property="mcId",column="mc_id"),
            @Result( property="emailUrl",column="email_url"),
            @Result( property="emailCode",column="email_code"),
            @Result( property="createTime",column="create_time")
    })
    @Select("SELECT mc_id,email_url,email_code,create_time from quaint_mail_code where email_url = #{mail}")
    MailCode selectByMail(String mail);
}