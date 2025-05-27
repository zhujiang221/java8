package com.hospital.admin.service;

import com.hospital.admin.beans.Billing;
import com.hospital.admin.beans.DischargeApplication;

import java.util.List;

public interface DischargeApplicationService {

    int deleteByPrimaryKey(Integer id);

    int insert(DischargeApplication record);

    int insertSelective(DischargeApplication record);

    DischargeApplication selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(DischargeApplication record);
}
