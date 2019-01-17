package com.quaint.blogback.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * LayUI  返回json 格式 通用工具类
 * @author quaint
 * @Date 2019/1/17
 */
@Data
public class LayJson<T> {

    private int code=0;
    private String msg;
    private Long count; //总条数
    private List<T> data = new ArrayList(); //装前台当前页的数据

}

