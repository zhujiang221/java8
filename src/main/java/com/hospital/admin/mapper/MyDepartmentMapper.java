package com.hospital.admin.mapper;

import com.hospital.admin.beans.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyDepartmentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

}