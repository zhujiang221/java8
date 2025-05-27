package com.hospital.admin.controller;

import com.hospital.admin.mapper.MyBillingMapper;
import com.hospital.admin.mapper.MyCommonMapper;
import com.hospital.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//该controller主要管理员的
@Controller
@RequestMapping("/")
public class AdminController {
    //这里还需要实例化，service，spring提供一个依赖注入DI，这里可以使用DI实例化serbice
    @Autowired
    private UserService myuserservice;

    @Autowired
    private MyCommonMapper mycommon;

    @Autowired
    private MyBillingMapper mybilling;




}
