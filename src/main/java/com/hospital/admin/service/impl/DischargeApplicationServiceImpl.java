package com.hospital.admin.service.impl;

import com.hospital.admin.beans.DischargeApplication;
import com.hospital.admin.beans.Users;
import com.hospital.admin.mapper.MyDischargeApplicationMapper;
import com.hospital.admin.mapper.MyUserMapper;
import com.hospital.admin.service.DischargeApplicationService;
import com.hospital.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//保证Contorller找到这个Service，这里加上注释@Service，不然Contorller找不到这个类
@Service
public class DischargeApplicationServiceImpl implements DischargeApplicationService {
    //这里需要实例化，mapper只有接口，接口不能实例化
    //这里实例化面向接口，用到spring的技术IOC或者DI，IOC是控制反转，这里把控制权交给spring的容器 DI是依赖注入
    //这里使用@Autowired注解不可以实现，@Autowired就代表可以把接口实例化
    @Autowired
    private MyDischargeApplicationMapper mymapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mymapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DischargeApplication record) {
        return mymapper.insert(record);
    }

    @Override
    public int insertSelective(DischargeApplication record) {
        return mymapper.insertSelective(record);
    }

    @Override
    public DischargeApplication selectByPrimaryKey(Integer id) {
        return mymapper.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(DischargeApplication record) {
        return mymapper.updateByPrimaryKey(record);
    }
}
