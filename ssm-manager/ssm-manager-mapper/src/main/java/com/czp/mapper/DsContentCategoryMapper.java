package com.czp.mapper;

import com.czp.pojo.DsContentCategory;
import com.czp.pojo.DsContentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsContentCategoryMapper {
    int countByExample(DsContentCategoryExample example);

    int deleteByExample(DsContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsContentCategory record);

    int insertSelective(DsContentCategory record);

    List<DsContentCategory> selectByExample(DsContentCategoryExample example);

    DsContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsContentCategory record, @Param("example") DsContentCategoryExample example);

    int updateByExample(@Param("record") DsContentCategory record, @Param("example") DsContentCategoryExample example);

    int updateByPrimaryKeySelective(DsContentCategory record);

    int updateByPrimaryKey(DsContentCategory record);
}