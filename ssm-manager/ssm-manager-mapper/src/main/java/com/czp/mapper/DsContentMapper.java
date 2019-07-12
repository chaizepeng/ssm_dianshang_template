package com.czp.mapper;

import com.czp.pojo.DsContent;
import com.czp.pojo.DsContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsContentMapper {
    int countByExample(DsContentExample example);

    int deleteByExample(DsContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsContent record);

    int insertSelective(DsContent record);

    List<DsContent> selectByExampleWithBLOBs(DsContentExample example);

    List<DsContent> selectByExample(DsContentExample example);

    DsContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsContent record, @Param("example") DsContentExample example);

    int updateByExampleWithBLOBs(@Param("record") DsContent record, @Param("example") DsContentExample example);

    int updateByExample(@Param("record") DsContent record, @Param("example") DsContentExample example);

    int updateByPrimaryKeySelective(DsContent record);

    int updateByPrimaryKeyWithBLOBs(DsContent record);

    int updateByPrimaryKey(DsContent record);
}