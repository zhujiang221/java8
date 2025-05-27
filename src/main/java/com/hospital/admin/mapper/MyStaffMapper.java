package com.hospital.admin.mapper;

import com.hospital.admin.beans.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyStaffMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff > findall();

}