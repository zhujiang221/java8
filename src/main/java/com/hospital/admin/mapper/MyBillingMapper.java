package com.hospital.admin.mapper;

import com.hospital.admin.beans.Billing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyBillingMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Billing record);

    int insertSelective(Billing record);

    Billing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Billing record);

    int updateByPrimaryKey(Billing record);

    List<Billing> selectfeyongy(int id);

    List<Billing> selectfeyongw(int id);

    List<Billing> selectfeyong(int id);

}