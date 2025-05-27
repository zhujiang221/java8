package com.hospital.admin.service;


import com.hospital.admin.beans.Staff;

import java.util.List;

public interface StaffService {

    int deleteByPrimaryKey(Integer id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

    List<Staff > findall();
}
