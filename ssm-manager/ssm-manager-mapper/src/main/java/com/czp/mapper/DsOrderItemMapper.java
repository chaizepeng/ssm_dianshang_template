package com.czp.mapper;

import com.czp.pojo.DsOrderItem;
import com.czp.pojo.DsOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsOrderItemMapper {
    int countByExample(DsOrderItemExample example);

    int deleteByExample(DsOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(DsOrderItem record);

    int insertSelective(DsOrderItem record);

    List<DsOrderItem> selectByExample(DsOrderItemExample example);

    DsOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DsOrderItem record, @Param("example") DsOrderItemExample example);

    int updateByExample(@Param("record") DsOrderItem record, @Param("example") DsOrderItemExample example);

    int updateByPrimaryKeySelective(DsOrderItem record);

    int updateByPrimaryKey(DsOrderItem record);
}