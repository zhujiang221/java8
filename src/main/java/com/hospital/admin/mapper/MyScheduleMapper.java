package com.hospital.admin.mapper;

import com.hospital.admin.beans.Schedules;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyScheduleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Schedules record);

    int insertSelective(Schedules record);

    Schedules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Schedules record);

    int updateByPrimaryKey(Schedules record);

}