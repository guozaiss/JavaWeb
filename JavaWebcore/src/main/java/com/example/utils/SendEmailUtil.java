package com.example.utils;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Guo on 2017/4/27.
 * 发送Email工具类
 */
@Component
public class SendEmailUtil {

    public void sendEmails(String emailS) throws MessagingException {
        String subject = "通知";
        String content = "益万家Android 内测版本 应用更新了，内测地址：<br/>" +
                "<a href=\"https://fir.im/p4l9\">https://fir.im/p4l9</a><br/>" +
                "密码：readyidu";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        Authenticator authenticator = new Email_Authenticator("492321329@qq.com", "tyezjcsxnatbcbaa");
        javax.mail.Session sendMailSession = javax.mail.Session.getDefaultInstance(properties, authenticator);
        MimeMessage mailMessage = new MimeMessage(sendMailSession);
        mailMessage.setFrom(new InternetAddress("492321329@qq.com"));
        // Message.RecipientType.TO属性表示接收者的类型为TO
        mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailS));
        mailMessage.setSubject(subject, "UTF-8");
        mailMessage.setSentDate(new Date());
        // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart mainPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart html = new MimeBodyPart();
        html.setContent(content.trim(), "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        mailMessage.setContent(mainPart);
        Transport.send(mailMessage);

    }

    static class Email_Authenticator extends Authenticator {
        String userName = null;
        String password = null;

        public Email_Authenticator() {
        }

        public Email_Authenticator(String username, String password) {
            this.userName = username;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(userName, password);
        }
    }
}
