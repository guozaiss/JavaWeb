package com.example.dao;

import com.example.model.SinaGoldNew;

public interface SinaGoldNewMapper {
    int deleteByPrimaryKey(Integer newId);

    int insert(SinaGoldNew record);

    int insertSelective(SinaGoldNew record);

    SinaGoldNew selectByPrimaryKey(Integer newId);

    int updateByPrimaryKeySelective(SinaGoldNew record);

    int updateByPrimaryKey(SinaGoldNew record);
}