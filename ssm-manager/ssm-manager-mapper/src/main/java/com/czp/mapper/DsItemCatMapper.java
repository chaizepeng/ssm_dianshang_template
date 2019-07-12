package com.czp.mapper;

import com.czp.pojo.DsItemCat;
import com.czp.pojo.DsItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsItemCatMapper {
    int countByExample(DsItemCatExample example);

    int deleteByExample(DsItemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsItemCat record);

    int insertSelective(DsItemCat record);

    List<DsItemCat> selectByExample(DsItemCatExample example);

    DsItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsItemCat record, @Param("example") DsItemCatExample example);

    int updateByExample(@Param("record") DsItemCat record, @Param("example") DsItemCatExample example);

    int updateByPrimaryKeySelective(DsItemCat record);

    int updateByPrimaryKey(DsItemCat record);
}