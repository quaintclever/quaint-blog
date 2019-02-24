package com.quaint.blog.base;

/**
 * 返回消息使用（单例）
 * @author quaint
 * @Date 2018/12/30
 */
public class Msg {

    private String text;//返回消息内容

    // 私有构造
    private Msg() {}

    private static Msg msg = null;

    public static Msg getInstance() {
        if(msg == null){
            msg = new Msg();
        }
        return msg;
    }

    /**
     * 获取实例并，默认一个消息
     * @param text
     * @return
     */
    public static Msg getInstanceWithText(String text) {
        Msg msg = getInstance();
        msg.setText(text);
        return msg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
