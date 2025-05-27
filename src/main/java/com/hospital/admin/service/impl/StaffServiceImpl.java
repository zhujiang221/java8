package com.hospital.admin.service.impl;

import com.hospital.admin.beans.Billing;
import com.hospital.admin.beans.Staff;
import com.hospital.admin.mapper.MyBillingMapper;
import com.hospital.admin.mapper.MyStaffMapper;
import com.hospital.admin.service.BillingService;
import com.hospital.admin.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

//保证Contorller找到这个Service，这里加上注释@Service，不然Contorller找不到这个类
@Service
public class StaffServiceImpl implements StaffService {
    //这里需要实例化，mapper只有接口，接口不能实例化
    //这里实例化面向接口，用到spring的技术IOC或者DI，IOC是控制反转，这里把控制权交给spring的容器 DI是依赖注入
    //这里使用@Autowired注解不可以实现，@Autowired就代表可以把接口实例化
    @Autowired
    private MyStaffMapper myusermapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Staff record) {
        return 0;
    }

    @Override
    public int insertSelective(Staff record) {
        return 0;
    }

    @Override
    public Staff selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Staff record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Staff record) {
        return 0;
    }

    @Override
    public List<Staff> findall() {
        return myusermapper.findall();
    }
}
