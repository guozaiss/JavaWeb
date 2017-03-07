package com.example.service.impl;

import com.example.dao.SinaGoldNewMapper;
import com.example.model.SinaGoldNew;
import com.example.service.SinaGoldNewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Guo on 2017/3/1.
 */
@Service("sinaGoldNewService")
public class SinaGoldNewServiceImpl implements SinaGoldNewService {

    @Resource
    SinaGoldNewMapper sinaGoldNewMapper;

    @Override
    public SinaGoldNew getNewById(int newId) {
        return sinaGoldNewMapper.selectByPrimaryKey(newId);
    }

    @Override
    public int insert(SinaGoldNew sinaGoldNew) {
        return sinaGoldNewMapper.insert(sinaGoldNew);
    }
}