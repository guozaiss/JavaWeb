package com.example.reptile;

import com.example.model.SinaGoldNew;
import com.example.service.SinaGoldNewService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Lenovo on 2017/3/2.
 */
public class SinaGoldReptileTest {
    private final static Logger logger = LoggerFactory.getLogger(SinaGoldReptileTest.class);

    @Autowired
    SinaGoldNewService sinaGoldNewService;

    @Before
    public void before() {
        sinaGoldNewService = (SinaGoldNewService) new ClassPathXmlApplicationContext("spring-mybatis.xml").getBean("sinaGoldNewService");
    }

    @Test
    public void getSinaGoldNews() throws Exception {
        List<SinaGoldNew> sinaGoldNews = SinaGoldReptile.getSinaGoldNews();
        for (SinaGoldNew sinaGoldNew : sinaGoldNews) {
            try {
                sinaGoldNewService.insert(sinaGoldNew);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}