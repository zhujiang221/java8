package com.hospital.admin.service.impl;

import com.hospital.admin.beans.Staff;
import com.hospital.admin.beans.Wards;
import com.hospital.admin.mapper.MyStaffMapper;
import com.hospital.admin.mapper.MyWardsMapper;
import com.hospital.admin.service.StaffService;
import com.hospital.admin.service.WardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

//保证Contorller找到这个Service，这里加上注释@Service，不然Contorller找不到这个类
@Service
public class WardsServiceImpl implements WardsService {
    //这里需要实例化，mapper只有接口，接口不能实例化
    //这里实例化面向接口，用到spring的技术IOC或者DI，IOC是控制反转，这里把控制权交给spring的容器 DI是依赖注入
    //这里使用@Autowired注解不可以实现，@Autowired就代表可以把接口实例化
    @Autowired
    private MyWardsMapper mymapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Wards record) {
        return 0;
    }

    @Override
    public int insertSelective(Wards record) {
        return 0;
    }

    @Override
    public Wards selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Wards record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Wards record) {
        return 0;
    }

    @Override
    public List<Wards> findall() {
        return mymapper.findall();
    }
}
