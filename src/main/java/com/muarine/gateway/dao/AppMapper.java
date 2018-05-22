package com.muarine.gateway.dao;

import com.muarine.gateway.model.App;
import com.muarine.gateway.model.AppExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppMapper {
    int countByExample(AppExample example);

    int deleteByExample(AppExample example);

    int deleteByPrimaryKey(String appKey);

    int insert(App record);

    int insertSelective(App record);

    List<App> selectByExample(AppExample example);

    App selectByPrimaryKey(String appKey);

    int updateByExampleSelective(@Param("record") App record, @Param("example") AppExample example);

    int updateByExample(@Param("record") App record, @Param("example") AppExample example);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);
}