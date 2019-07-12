package com.czp.mapper;

import com.czp.pojo.DsOrder;
import com.czp.pojo.DsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsOrderMapper {
    int countByExample(DsOrderExample example);

    int deleteByExample(DsOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(DsOrder record);

    int insertSelective(DsOrder record);

    List<DsOrder> selectByExample(DsOrderExample example);

    DsOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") DsOrder record, @Param("example") DsOrderExample example);

    int updateByExample(@Param("record") DsOrder record, @Param("example") DsOrderExample example);

    int updateByPrimaryKeySelective(DsOrder record);

    int updateByPrimaryKey(DsOrder record);
}