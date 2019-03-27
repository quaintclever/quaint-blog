package com.quaint.blog.service;

import com.github.pagehelper.PageInfo;
import com.quaint.blog.pojo.Mood;
import com.quaint.blog.utils.LayJson;

public interface MoodService {

    /**
     * 通过id查询心情
     * @param moodId
     * @return
     */
    Mood selectByPrimaryKey(Integer moodId);

    /**
     * 后台增加一个心情
     * @param mood
     * @return
     */
    int insertSelective(Mood mood);

    /**
     * 后台查询全部心情
     * @return
     */
    LayJson<Mood> select(LayJson<Mood> layJson);

    /**
     * 后台删除一个心情
     * @param moodId
     * @return
     */
    int deleteByPrimaryKey(Integer moodId);

    /**
     * 后台修改一个心情
     * @return
     */
    int updateByPrimaryKeySelective(Mood record);

    /**
     * 前台查询最新的一个心情
     * @return
     */
    Mood selectNewMood();

    /**
     * 前台分页查询心情
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Mood> selectMoodList(int pageNo, int pageSize);
}
