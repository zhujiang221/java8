package com.hospital.admin.mapper;

import com.hospital.admin.beans.Patient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPatientMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);

}