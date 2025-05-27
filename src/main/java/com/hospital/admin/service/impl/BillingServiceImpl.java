package com.hospital.admin.service.impl;

import com.hospital.admin.beans.Billing;
import com.hospital.admin.beans.Users;
import com.hospital.admin.mapper.MyBillingMapper;
import com.hospital.admin.mapper.MyUserMapper;
import com.hospital.admin.service.BillingService;
import com.hospital.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

//保证Contorller找到这个Service，这里加上注释@Service，不然Contorller找不到这个类
@Service
public class BillingServiceImpl implements BillingService {
    //这里需要实例化，mapper只有接口，接口不能实例化
    //这里实例化面向接口，用到spring的技术IOC或者DI，IOC是控制反转，这里把控制权交给spring的容器 DI是依赖注入
    //这里使用@Autowired注解不可以实现，@Autowired就代表可以把接口实例化
    @Autowired
    private MyBillingMapper myusermapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return myusermapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Billing record) {
        return myusermapper.insert(record);
    }

    @Override
    public int insertSelective(Billing record) {
        return myusermapper.insertSelective(record);
    }

    @Override
    public Billing selectByPrimaryKey(Integer id) {
        return myusermapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Billing record) {
        return myusermapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Billing record) {
        return myusermapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Billing> selectfeyongy(int id) {
        return myusermapper.selectfeyongy(id);
    }

    @Override
    public List<Billing> selectfeyongw(int id) {
        return myusermapper.selectfeyongw(id);
    }

    @Override
    public List<Billing> selectfeyong(int id) {
        return myusermapper.selectfeyong(id);
    }
}
