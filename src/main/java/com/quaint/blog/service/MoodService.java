package com.quaint.blog.service;

import com.quaint.blog.pojo.Mood;
import com.quaint.blog.utils.LayJson;

public interface MoodService {

    /**
     * 增加一个心情
     * @param mood
     * @return
     */
    int insertSelective(Mood mood);

    /**
     * 查询全部心情
     * @return
     */
    LayJson<Mood> select(LayJson<Mood> layJson);

    /**
     * 删除一个心情
     * @param moodId
     * @return
     */
    int deleteByPrimaryKey(Integer moodId);

}
