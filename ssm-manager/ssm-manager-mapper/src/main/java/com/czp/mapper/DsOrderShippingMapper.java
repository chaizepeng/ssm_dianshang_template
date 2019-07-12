package com.czp.mapper;

import com.czp.pojo.DsOrderShipping;
import com.czp.pojo.DsOrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsOrderShippingMapper {
    int countByExample(DsOrderShippingExample example);

    int deleteByExample(DsOrderShippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(DsOrderShipping record);

    int insertSelective(DsOrderShipping record);

    List<DsOrderShipping> selectByExample(DsOrderShippingExample example);

    DsOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") DsOrderShipping record, @Param("example") DsOrderShippingExample example);

    int updateByExample(@Param("record") DsOrderShipping record, @Param("example") DsOrderShippingExample example);

    int updateByPrimaryKeySelective(DsOrderShipping record);

    int updateByPrimaryKey(DsOrderShipping record);
}