package com.example.service;

import com.example.model.SinaGoldNew;

/**
 * Created by Guo on 2017/3/1.
 */
public interface SinaGoldNewService {
    SinaGoldNew getNewById(String userId);

    int insert(SinaGoldNew sinaGoldNew);
}
