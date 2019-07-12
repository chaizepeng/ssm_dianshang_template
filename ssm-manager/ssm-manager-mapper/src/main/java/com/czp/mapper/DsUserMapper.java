package com.czp.mapper;

import com.czp.pojo.DsUser;
import com.czp.pojo.DsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DsUserMapper {
    int countByExample(DsUserExample example);

    int deleteByExample(DsUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DsUser record);

    int insertSelective(DsUser record);

    List<DsUser> selectByExample(DsUserExample example);

    DsUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DsUser record, @Param("example") DsUserExample example);

    int updateByExample(@Param("record") DsUser record, @Param("example") DsUserExample example);

    int updateByPrimaryKeySelective(DsUser record);

    int updateByPrimaryKey(DsUser record);
}