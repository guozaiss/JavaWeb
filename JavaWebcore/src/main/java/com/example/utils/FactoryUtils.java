package com.example.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Guo on 2017/4/24.
 * Bean工厂类
 * singleton    prototype   request     session     globalsession
 */
public class FactoryUtils {

    private FactoryUtils() {
    }

    public static ApplicationContext getInstance() {
        return FactoryViewHolder.applicationContext;
    }

    static class FactoryViewHolder {
        static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    }
}