package com.hospital.admin.mapper;

import com.hospital.admin.beans.DischargeApplication;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyDischargeApplicationMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DischargeApplication record);

    int insertSelective(DischargeApplication record);

    DischargeApplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DischargeApplication record);

    int updateByPrimaryKey(DischargeApplication record);

}