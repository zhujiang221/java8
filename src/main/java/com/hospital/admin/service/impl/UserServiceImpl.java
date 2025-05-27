package com.hospital.admin.service.impl;

import com.hospital.admin.beans.Users;
import com.hospital.admin.mapper.MyUserMapper;
import com.hospital.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//保证Contorller找到这个Service，这里加上注释@Service，不然Contorller找不到这个类
@Service
public class UserServiceImpl implements UserService {
    //这里需要实例化，mapper只有接口，接口不能实例化
    //这里实例化面向接口，用到spring的技术IOC或者DI，IOC是控制反转，这里把控制权交给spring的容器 DI是依赖注入
    //这里使用@Autowired注解不可以实现，@Autowired就代表可以把接口实例化
    @Autowired
    private MyUserMapper myusermapper;
    @Override
    public List<Users> findall(){
        //调用工具，这里需要调用mapper，这个mapper需要new实例化
        return myusermapper.findall();
    }

    @Override
    public Users findUserByUsername(Users myuser) {
        return myusermapper.findUserByUsername(myuser);
    }

    @Override
    public void addUser(Users myuser) {
        //这里没有返回，没有return，直接调用mapper中的addUser
        myusermapper.addUser(myuser);
    }

    @Override
    public void deleteUser(int id) {
        myusermapper.deleteUser(id);
    }

    @Override
    public Users findUserById(int id) {
        return myusermapper.findUserById(id);
    }

    @Override
    public void updateUser(Users myuser) {
        myusermapper.updateUser(myuser);
    }



}
