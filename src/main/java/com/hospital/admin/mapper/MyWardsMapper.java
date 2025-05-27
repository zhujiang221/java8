package com.hospital.admin.mapper;

import com.hospital.admin.beans.Staff;
import com.hospital.admin.beans.Wards;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MyWardsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Wards record);

    int insertSelective(Wards record);

    Wards selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wards record);

    int updateByPrimaryKey(Wards record);

    List<Wards> findall();
}