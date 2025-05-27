package com.hospital.admin.mapper;

import com.hospital.admin.beans.MedicalOrders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyMedicalordersMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MedicalOrders record);

    int insertSelective(MedicalOrders record);

    MedicalOrders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicalOrders record);

    int updateByPrimaryKey(MedicalOrders record);

}