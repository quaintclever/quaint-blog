package com.quaint.blogback.service.impl;

import com.quaint.blogback.dao.PowerListMapper;
import com.quaint.blogback.pojo.PowerList;
import com.quaint.blogback.service.PowerListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author quaint
 * @Date 2019/1/16
 */
@Component("PowerListService")
public class PowerListServiceImpl implements PowerListService {

    @Autowired
    private PowerListMapper plmapper;

    @Override
    public int addPowerList(PowerList power) {
        return plmapper.insert(power);
    }
}
