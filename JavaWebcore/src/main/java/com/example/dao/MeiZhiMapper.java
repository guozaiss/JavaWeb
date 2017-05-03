package com.example.dao;

import com.example.model.MeiZhi;
import com.example.model.MeiZhiExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeiZhiMapper {
    int countByExample(MeiZhiExample example);

    int deleteByExample(MeiZhiExample example);

    int deleteByPrimaryKey(String id);

    int insert(MeiZhi record);

    int insertSelective(MeiZhi record);

    List<MeiZhi> selectByExample(MeiZhiExample example);

    MeiZhi selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MeiZhi record, @Param("example") MeiZhiExample example);

    int updateByExample(@Param("record") MeiZhi record, @Param("example") MeiZhiExample example);

    int updateByPrimaryKeySelective(MeiZhi record);

    int updateByPrimaryKey(MeiZhi record);
}