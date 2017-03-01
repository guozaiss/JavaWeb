package com.example.dao;

import com.example.model.SinaGoldNew;

public interface SinaGoldNewMapper {
    int deleteByPrimaryKey(String newId);

    int insert(SinaGoldNew record);

    int insertSelective(SinaGoldNew record);

    SinaGoldNew selectByPrimaryKey(String newId);

    int updateByPrimaryKeySelective(SinaGoldNew record);

    int updateByPrimaryKey(SinaGoldNew record);
}