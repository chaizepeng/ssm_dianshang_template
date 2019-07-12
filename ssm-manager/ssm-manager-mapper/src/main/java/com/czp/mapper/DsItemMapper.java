package com.czp.mapper;

import com.czp.pojo.DsItem;
import com.czp.pojo.DsItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsItemMapper {
    int countByExample(DsItemExample example);

    int deleteByExample(DsItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsItem record);

    int insertSelective(DsItem record);

    List<DsItem> selectByExample(DsItemExample example);

    DsItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsItem record, @Param("example") DsItemExample example);

    int updateByExample(@Param("record") DsItem record, @Param("example") DsItemExample example);

    int updateByPrimaryKeySelective(DsItem record);

    int updateByPrimaryKey(DsItem record);
}