package com.czp.rest.mapper;

import com.czp.pojo.DsItemDesc;
import com.czp.pojo.DsItemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsItemDescMapper {
    int countByExample(DsItemDescExample example);

    int deleteByExample(DsItemDescExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(DsItemDesc record);

    int insertSelective(DsItemDesc record);

    List<DsItemDesc> selectByExampleWithBLOBs(DsItemDescExample example);

    List<DsItemDesc> selectByExample(DsItemDescExample example);

    DsItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") DsItemDesc record, @Param("example") DsItemDescExample example);

    int updateByExampleWithBLOBs(@Param("record") DsItemDesc record, @Param("example") DsItemDescExample example);

    int updateByExample(@Param("record") DsItemDesc record, @Param("example") DsItemDescExample example);

    int updateByPrimaryKeySelective(DsItemDesc record);

    int updateByPrimaryKeyWithBLOBs(DsItemDesc record);

    int updateByPrimaryKey(DsItemDesc record);
}