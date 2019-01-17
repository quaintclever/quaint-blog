package com.quaint.blogback.service.impl;

import com.quaint.blogback.dao.PowerListMapper;
import com.quaint.blogback.pojo.PowerList;
import com.quaint.blogback.service.PowerListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author quaint
 * @Date 2019/1/16
 */
@Component("PowerListService")
public class PowerListServiceImpl implements PowerListService {

    @Autowired
    private PowerListMapper powerListMapper;

    @Override
    public int insertSelective(PowerList power) {
        return powerListMapper.insertSelective(power);
    }

    @Override
    public List<PowerList> select() {
        return powerListMapper.select();
    }
}
