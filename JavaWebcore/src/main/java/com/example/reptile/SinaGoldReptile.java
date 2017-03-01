package com.example.reptile;

import com.example.model.SinaGoldNew;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Created by Guo on 2017/3/1.
 */
public class SinaGoldReptile {
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
        String url = "http://tools.2345.com/rili.htm";
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
        Document document = Jsoup.parse(html);
        return null;
    }

}