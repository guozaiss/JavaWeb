package com.example.task;

import com.example.model.SinaGoldNew;
import com.example.reptile.SinaGoldReptile;
import com.example.service.SinaGoldNewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2017/3/1.
 */
@Service
@Lazy(false)
public class ReptileTask {
    public final static Logger logger = LoggerFactory.getLogger(ReptileTask.class);

    @Autowired
    private SinaGoldNewService sinaGoldNewService;

    /**
     * 获取腾讯新闻数据
     */
    @Scheduled(cron = "0 0/1 * * * *")
    public void virtualThumbUp() {
        logger.info("<<-----------------------财经开始读取并入库----------------->>");
        try {
            List<SinaGoldNew> sinaGoldNews = SinaGoldReptile.getSinaGoldNews();
            for (SinaGoldNew s : sinaGoldNews) {
                int insert = sinaGoldNewService.insert(s);
            }
        } catch (Exception e) {
            logger.error("virtualThumbUp() error: ", e);
        }
        logger.info("<<-----------------------财经新闻读取并入库完毕----------------->>");

    }
}