package com.example.utils;

import org.junit.Test;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by Guo on 2017/4/28.
 */
public class ExcelUtilsTest {

    @Test
    public void read() {
        ExcelUtils excelUtils = FactoryUtils.getInstance().getBean("excelUtils", ExcelUtils.class);
        SendEmailUtil sendEmailUtil = FactoryUtils.getInstance().getBean("sendEmailUtil", SendEmailUtil.class);
        List<String> strings = excelUtils.readEmailAddress();
        try {
            sendEmailUtil.sendEmails(strings.toString().replace("[", "").replace("]", "").replace("\"", ""));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        LogUtils.log(strings.toString().replace("[", "").replace("]", "").replace("\"", ""));
    }
}