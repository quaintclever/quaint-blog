package com.quaint.blog.utils;

import java.util.Random;

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

    /**
     * 获取一个随机数
     * @return
     */
    public static String getCode(int n){
        String string = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//保存数字0-9 和 大小写字母
        StringBuffer sb = new StringBuffer(); //声明一个StringBuffer对象sb 保存 验证码
        for (int i = 0; i < n; i++) {
            Random random = new Random();//创建一个新的随机数生成器
            int index = random.nextInt(string.length());//返回[0,string.length)范围的int值    作用：保存下标
            char ch = string.charAt(index);//charAt() : 返回指定索引处的 char 值   ==》赋值给char字符对象ch
            sb.append(ch);// append(char c) :将 char 参数的字符串表示形式追加到此序列  ==》即将每次获取的ch值作拼接
        }
        return sb.toString();
    }

}
