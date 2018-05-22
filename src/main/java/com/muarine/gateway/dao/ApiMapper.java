package com.muarine.gateway.dao;

import com.muarine.gateway.model.Api;
import com.muarine.gateway.model.ApiExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiMapper {
    int countByExample(ApiExample example);

    int deleteByExample(ApiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Api record);

    int insertSelective(Api record);

    List<Api> selectByExample(ApiExample example);

    Api selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByExample(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByPrimaryKeySelective(Api record);

    int updateByPrimaryKey(Api record);
}