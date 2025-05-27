package com.hospital.admin.mapper;

import com.hospital.admin.beans.Shifts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyShiftMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Shifts record);

    int insertSelective(Shifts record);

    Shifts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shifts record);

    int updateByPrimaryKey(Shifts record);

}