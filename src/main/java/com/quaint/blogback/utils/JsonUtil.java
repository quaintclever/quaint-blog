package com.quaint.blogback.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quaint.blogback.base.Msg;

/**
 * Json工具类
 * @author quaint
 * @Date 2018/12/29
 */
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();
    private static Msg msg = new Msg();

    /**
     * 将对象转换为Json
     * @param object 要转换的对象
     * @return 转换后的Json对象
     */
    public static String ObjToJson(Object object){
        String reJson = null;
        try {
            reJson = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(reJson);
        return reJson;
    }

    /**
     * 返回json信息
     * @param m
     * @return
     */
    public static String MsgToJson(String m){
        msg.setMsg(m);
        return ObjToJson(msg);
    }

}
