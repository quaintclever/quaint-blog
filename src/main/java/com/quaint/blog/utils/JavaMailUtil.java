package com.quaint.blog.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;

/**
 * javamail 工具类
 * @author quaint
 * @Date 2019/2/18
 */
@Component
public class JavaMailUtil {

    private static JavaMailSenderImpl mailSender;

    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @PostConstruct
    public void init(){
        mailSender = javaMailSender;
    }

    /**
     * 发送包含简单文本的邮件
     * @param title
     * @param text
     */
    public static void sendText(String title,String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置收件人
        simpleMailMessage.setTo(new String[] {"123456789@qq.com"});
        //寄件人
        simpleMailMessage.setFrom("quaint@quaint-aini.com");
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(text);
        // 发送邮件
        mailSender.send(simpleMailMessage);
        System.out.println("JavaMailUtil类提示:---邮件已发送---");
    }

    /**
     * 发送包含简单html文本的邮件
     * @param title
     * @param text
     */
    public static void sendHtml(String email,String title,String text) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        //发送到传进来的邮箱
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setFrom("quaint@quaint-aini.com");
        mimeMessageHelper.setSubject(title);
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head></head><body>");
        sb.append(text);
        sb.append("</body></html>");
        // 启用html
        mimeMessageHelper.setText(sb.toString(), true);
        // 发送邮件
        mailSender.send(mimeMessage);

        System.out.println("邮件已发送");
    }

    /**
     * 发送包含验证码的邮件
     */
    public static void sendCode(String email,String code) throws Exception{
        //调用方法前传递随机生成的code
        code = "<h3>如果非本人操作，请忽略此验证码。</h3><p>验证码："+code+"</p><p>博客连接：www.quaint-aini.com</p>";
        sendHtml(email,"Quaint博客用户注册邮件",code);
    }

    /**
     * 发送留言回复提醒
     */
    public static void sendReRemind(String email,String msg) throws Exception{
        //调用方法前传递随机生成的code
        msg = "<h3>尊敬的Quaint博客用户,您好</h3><p>您的留言收到了一条回复消息,内容为：<br/>"+msg+"</p><p>我在这里等着你哦~博客连接：www.quaint-aini.com</p>";
        sendHtml(email,"Quaint博客用户留言回复邮件",msg);
    }

}
