package com.hospital.admin.controller;

import com.hospital.admin.beans.*;
import com.hospital.admin.mapper.*;
import com.hospital.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Stack;

//该controller主要医生的
@Controller
@RequestMapping("/")
public class DoctorController {
    //这里还需要实例化，service，spring提供一个依赖注入DI，这里可以使用DI实例化serbice
    @Autowired
    private UserService myuserservice;

    @Autowired
    private MyCommonMapper mycommon;

    @Autowired
    private MyBillingMapper mybilling;

    @Autowired
    private MyStaffMapper mystaff;

    @Autowired
    private MyWardsMapper mywards;

    @Autowired
    private MyDischargeApplicationMapper dischargeApplication;

    @RequestMapping(value = "huanzheguanli",method={RequestMethod.GET,RequestMethod.POST})
    public String huanzheguanli(Integer id, Model model){

        Users myuser1=myuserservice.findUserById(id);
        model.addAttribute("user",myuser1);
        System.out.println(myuser1);
        MyCommon myallusers=mycommon.selectstaff(myuser1.getId());
        System.out.println(myallusers.getDoctor_id());
        List<MyCommon> myCommons=mycommon.selecthuanzhebydid(myallusers.getId());
        int totalCount = myCommons.size(); // 计算总条数
        List<Wards> wards = mywards.findall();
        model.addAttribute("patientCount", totalCount);
        System.out.println("---------------------");
        System.out.println(myCommons);
        System.out.println("---------------------");
        model.addAttribute("wards", wards);
        model.addAttribute("patients",myCommons);
        model.addAttribute("doc_information",myallusers);
        System.out.println(myallusers);
        return "doctor_page";

    }

    @RequestMapping(value = "zhuyuanguanli",method={RequestMethod.GET,RequestMethod.POST})
    public String zhuyuanguanli(Integer id, Model model){


        Users myuser1=myuserservice.findUserById(id);
        model.addAttribute("user",myuser1);
        System.out.println(myuser1);
        MyCommon myallusers=mycommon.selectstaff(myuser1.getId());
        model.addAttribute("doc_information",myallusers);
        System.out.println(myallusers);
        return "doctor_page1";

    }

    @RequestMapping(value = "xiangqing",method={RequestMethod.GET,RequestMethod.POST})
    public String xiangqing(Integer id,Integer user_id, Model model){
        System.out.println("idddd"+id);
        System.out.println("idddd"+user_id);
        //查询患者信息
        Users myuser1=myuserservice.findUserById(id);
        MyCommon myallusers=mycommon.selectstaff(user_id);
        List<MyCommon> myCommons=mycommon.selecthuanzhebydid(myallusers.getId());
        MyCommon myallusers1=mycommon.select_person(id);
        List<MyCommon> yizhuchangqi = mycommon.selectyizhu(myallusers1.getPatient_id());
        List<Staff> my=mystaff.findall();
        model.addAttribute("my",my);
        model.addAttribute("yizhu", yizhuchangqi);
        //用来页面切换和当前医生账号的信息
        Users myuser22=myuserservice.findUserById(user_id);
        model.addAttribute("user",myuser22);
        model.addAttribute("patients",myCommons);
        model.addAttribute("doc_information",myallusers);
        model.addAttribute("patient",myallusers1);
        System.out.println(myallusers1);
        DischargeApplication dis=dischargeApplication.selectByPrimaryKey(myallusers1.getPatient_id());
        System.out.println("admissionid"+myallusers1.getAdmission_id());
        System.out.println(myallusers1);
        // 获取当前时间

        if (dis!=null){
            System.out.println("---------------------11111-----------");
            model.addAttribute("dis",dis);
        }else{
            System.out.println("---------------------55555-----------");
            model.addAttribute("dis",null);
        }
        return "doctor_page2";

    }



}
