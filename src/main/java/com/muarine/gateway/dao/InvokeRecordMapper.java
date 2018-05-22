package com.muarine.gateway.dao;

import com.muarine.gateway.model.InvokeRecord;
import com.muarine.gateway.model.InvokeRecordExample;
import com.muarine.gateway.model.InvokeRecordWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvokeRecordMapper {
    int countByExample(InvokeRecordExample example);

    int deleteByExample(InvokeRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InvokeRecordWithBLOBs record);

    int insertSelective(InvokeRecordWithBLOBs record);

    List<InvokeRecordWithBLOBs> selectByExampleWithBLOBs(InvokeRecordExample example);

    List<InvokeRecord> selectByExample(InvokeRecordExample example);

    InvokeRecordWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InvokeRecordWithBLOBs record, @Param("example") InvokeRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") InvokeRecordWithBLOBs record, @Param("example") InvokeRecordExample example);

    int updateByExample(@Param("record") InvokeRecord record, @Param("example") InvokeRecordExample example);

    int updateByPrimaryKeySelective(InvokeRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(InvokeRecordWithBLOBs record);

    int updateByPrimaryKey(InvokeRecord record);
}