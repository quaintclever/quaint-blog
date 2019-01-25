package com.quaint.blog.utils;

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

    //起始页
    private int page;
    //页数大小
    private int limit;
    private Integer code=0;
    private String msg;
    //总条数
    private Long count;
    //装前台当前页的数据
    private List<T> data = new ArrayList();
    //任何类型条件
    private T example;

}

