package com.example.task;

import com.example.service.SinaGoldNewService;
import com.example.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/3/1.
 */
@Service
@Lazy(false)
public class ReptileTask {

    @Autowired
    private SinaGoldNewService sinaGoldNewService;

    /**
     * 获取腾讯新闻数据
     */
    @Scheduled(cron = "0 0/1 * * * *")
    public void virtualThumbUp() {
        LogUtils.log("<<-----------------------财经开始读取并入库----------------->>");
//        try {
//            List<SinaGoldNew> sinaGoldNews = SinaGoldReptile.getSinaGoldNews();
//            for (SinaGoldNew sendEmails : sinaGoldNews) {
//                int insert = sinaGoldNewService.insert(sendEmails);
//            }
//        } catch (Exception e) {
//            logger.error("virtualThumbUp() error: ", e);
//        }
        LogUtils.log("<<-----------------------财经新闻读取并入库完毕----------------->>");

    }
}