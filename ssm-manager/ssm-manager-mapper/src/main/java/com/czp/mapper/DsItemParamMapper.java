package com.czp.mapper;

import com.czp.pojo.DsItemParam;
import com.czp.pojo.DsItemParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsItemParamMapper {
    int countByExample(DsItemParamExample example);

    int deleteByExample(DsItemParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsItemParam record);

    int insertSelective(DsItemParam record);

    List<DsItemParam> selectByExampleWithBLOBs(DsItemParamExample example);

    List<DsItemParam> selectByExample(DsItemParamExample example);

    DsItemParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsItemParam record, @Param("example") DsItemParamExample example);

    int updateByExampleWithBLOBs(@Param("record") DsItemParam record, @Param("example") DsItemParamExample example);

    int updateByExample(@Param("record") DsItemParam record, @Param("example") DsItemParamExample example);

    int updateByPrimaryKeySelective(DsItemParam record);

    int updateByPrimaryKeyWithBLOBs(DsItemParam record);

    int updateByPrimaryKey(DsItemParam record);
}