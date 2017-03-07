package com.example.service.impl;

import com.example.model.SinaGoldNew;
import com.example.service.SinaGoldNewService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Guo on 2017/3/2.
 */
public class SinaGoldNewServiceImplTest {
    private final static Logger logger = LoggerFactory.getLogger(SinaGoldNewServiceImplTest.class);
    @Autowired
    SinaGoldNewService sinaGoldNewService;

    @Before
    public void before() {
        sinaGoldNewService = (SinaGoldNewService) new ClassPathXmlApplicationContext("spring-mybatis.xml").getBean("sinaGoldNewService");
    }
    @Test
    public void getNewById() throws Exception {
        SinaGoldNew newById = sinaGoldNewService.getNewById(1);
        logger.info(new Gson().toJson(newById));
    }

    @Test
    public void insert() throws Exception {

    }

}