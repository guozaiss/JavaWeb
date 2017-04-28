package com.example.utils;

import org.junit.Test;

/**
 * Created by Guo on 2017/4/27.
 */
public class SendEmailUtilTest {

    @Test
    public void sendEmails() {
        SendEmailUtil sendEmailUtil = FactoryUtils.getInstance().getBean("sendEmailUtil", SendEmailUtil.class);
    }
}