package com.example.dao;

import com.example.model.MeiZhi;

public interface MeiZhiMapper {
    int deleteByPrimaryKey(String id);

    int insert(MeiZhi record);

    int insertSelective(MeiZhi record);

    MeiZhi selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MeiZhi record);

    int updateByPrimaryKey(MeiZhi record);
}