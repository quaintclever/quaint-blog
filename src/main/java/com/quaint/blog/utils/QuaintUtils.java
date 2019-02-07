package com.quaint.blog.utils;

/**
 * 自定义工具类
 * quaint's util
 */
public class QuaintUtils {

    /**
     * 拼接控制器的返回页面
     * @return
     */
    public static String getRetrunPath(String... path){
        String url="";
        for(int i = 0;i<path.length;i++){
            url+="/"+path[i];
        }
        return url;
    }

}
