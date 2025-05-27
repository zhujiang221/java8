package com.hospital.admin.mapper;

import com.hospital.admin.beans.Admission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyAdmissionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Admission record);

    int insertSelective(Admission record);

    Admission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admission record);

    int updateByPrimaryKey(Admission record);

}