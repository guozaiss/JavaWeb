package com.example.reptile;

import com.example.model.SinaGoldNew;
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
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Guo on 2017/3/1.
 */
@Component
public class SinaGoldReptile {

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
        final List<SinaGoldNew> sinaGoldNews = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements list_009 = document.getElementsByClass("list_009");
//        Observable.from(list_009)
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.computation())
//                .flatMap(new Func1<Element, Observable<Element>>() {
//                    @Override
//                    public Observable<Element> call(Element element) {
//                        return Observable.from(element.children());
//                    }
//                }).map(new Func1<Element, SinaGoldNew>() {
//            @Override
//            public SinaGoldNew call(Element element) {
//                Element a = element.select("a").first();
//                String link = a.attr("abs:href");
//                String title = a.html();
//                String time = element.select("span").html();
//                try {
//                    title = new String(title.getBytes("ISO8859-1"), "utf-8");
//                    time = new String(time.getBytes("ISO8859-1"), "utf-8");
//                    time = time.substring(time.indexOf("(") + 1, time.indexOf(")"));
//                } catch (UnsupportedEncodingException e1) {
//                    e1.printStackTrace();
//                }
//                return new SinaGoldNew(0, time, new Date(), title, link);
//            }
//        }).subscribe(new Action1<SinaGoldNew>() {
//            @Override
//            public void call(SinaGoldNew sinaGoldNew) {
//                sinaGoldNews.add(sinaGoldNew);
//            }
//        });
        for (Element e : list_009) {
            Elements childrens = e.children();
            for (Element children : childrens) {
                Element a = children.select("a").first();
                String link = a.attr("abs:href");
                String title = a.html();
                String time = children.select("span").html();
                try {
                    title = new String(title.getBytes("ISO8859-1"), "utf-8");
                    time = new String(time.getBytes("ISO8859-1"), "utf-8");
                    time = time.substring(time.indexOf("(") + 1, time.indexOf(")"));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
                sinaGoldNews.add(new SinaGoldNew(0, title, new Date(), time, link));
            }
        }
        return sinaGoldNews;
    }

}