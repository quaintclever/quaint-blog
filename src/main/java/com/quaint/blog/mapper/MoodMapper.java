package com.quaint.blog.mapper;

import com.quaint.blog.pojo.Mood;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MoodMapper {

    int deleteByPrimaryKey(Integer moodId);

    int insert(Mood record);

    int insertSelective(Mood record);

    Mood selectByPrimaryKey(Integer moodId);

    List<Mood> select();

    int updateByPrimaryKeySelective(Mood record);

    int updateByPrimaryKey(Mood record);

    /**
     * 查询最新的mood
     * @return
     */


    @Results({
            @Result( property="moodTime",column="mood_time"),
            @Result( property="moodContent",column="mood_content")
    })
    @Select("SELECT mood_time,mood_content from quaint_mood ORDER BY mood_time DESC LIMIT 1")
    Mood selectNewMood();
}