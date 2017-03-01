package com.example.model;

import java.util.Date;

public class SinaGoldNew {
    private String newId;

    private String title;

    private String publishTime;

    private Date createTime;

    private String url;

    public SinaGoldNew(String newId, String title, String publishTime, Date createTime, String url) {
        this.newId = newId;
        this.title = title;
        this.publishTime = publishTime;
        this.createTime = createTime;
        this.url = url;
    }

    public SinaGoldNew() {
        super();
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId == null ? null : newId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime == null ? null : publishTime.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}