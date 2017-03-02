package com.example.reptile;

import com.example.model.SinaGoldNew;
import com.example.task.ReptileTask;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Guo on 2017/3/1.
 */
public class SinaGoldReptile {
    private final static Logger logger = LoggerFactory.getLogger(ReptileTask.class);

    /**
     * 单例工具类
     */
    private SinaGoldReptile() {
    }

    /**
     * 获取万年历信息
     *
     * @return List<SinaGoldNew>
     */
    public static List<SinaGoldNew> getSinaGoldNews() {
        String url = "http://roll.finance.sina.com.cn/finance/gjs/hjfx/index.shtml";
        String html = pickData(url);
        return analyzeHTMLByString(html);
    }

    /**
     * 爬取网页信息
     */
    private static String pickData(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            try (CloseableHttpResponse response = httpclient.execute(httpget)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity);
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 使用jsoup解析网页信息
     */
    private static List<SinaGoldNew> analyzeHTMLByString(String html) {
        List<SinaGoldNew> sinaGoldNews = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements list_009 = document.getElementsByClass("list_009");
        for (Element e : list_009) {
            Elements childrens = e.children();
            for (Element children : childrens) {
                Element a = children.select("a").first();
                String link = a.attr("abs:href");
                String title = a.html();
                String time = children.select("span").html();
                try {
                    title = new String(title.getBytes("ISO8859-1"), "gb2312");
                    time = new String(time.getBytes("ISO8859-1"), "gb2312");
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                sinaGoldNews.add(new SinaGoldNew(title.hashCode() + time.hashCode() + "", title, time, new Date(), link));
            }
        }
        return sinaGoldNews;
    }

}