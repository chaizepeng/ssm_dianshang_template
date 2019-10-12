package com.czp.rest.mapper;

import com.czp.pojo.DsItemParamItem;
import com.czp.pojo.DsItemParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsItemParamItemMapper {
    int countByExample(DsItemParamItemExample example);

    int deleteByExample(DsItemParamItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsItemParamItem record);

    int insertSelective(DsItemParamItem record);

    List<DsItemParamItem> selectByExampleWithBLOBs(DsItemParamItemExample example);

    List<DsItemParamItem> selectByExample(DsItemParamItemExample example);

    DsItemParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsItemParamItem record, @Param("example") DsItemParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") DsItemParamItem record, @Param("example") DsItemParamItemExample example);

    int updateByExample(@Param("record") DsItemParamItem record, @Param("example") DsItemParamItemExample example);

    int updateByPrimaryKeySelective(DsItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(DsItemParamItem record);

    int updateByPrimaryKey(DsItemParamItem record);
}