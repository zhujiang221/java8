package com.hospital.admin.service;

import com.hospital.admin.beans.Billing;

import java.util.List;

public interface BillingService {

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
