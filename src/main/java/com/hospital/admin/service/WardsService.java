package com.hospital.admin.service;


import com.hospital.admin.beans.Wards;

import java.util.List;

public interface WardsService {

    int deleteByPrimaryKey(Integer id);

    int insert(Wards record);

    int insertSelective(Wards record);

    Wards selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wards record);

    int updateByPrimaryKey(Wards record);

    List<Wards> findall();
}
