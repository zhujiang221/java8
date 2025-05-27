package com.hospital.admin.controller;

import com.hospital.admin.beans.Billing;
import com.hospital.admin.beans.DischargeApplication;
import com.hospital.admin.beans.MyCommon;
import com.hospital.admin.beans.Users;
import com.hospital.admin.mapper.MyBillingMapper;
import com.hospital.admin.mapper.MyCommonMapper;
import com.hospital.admin.mapper.MyDischargeApplicationMapper;
import com.hospital.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//改controller主要用于五中用户的登录，以及用户的注册用户相关页面的增删改查，等功能
@Controller
@RequestMapping("/")
public class UserController {
    //这里还需要实例化，service，spring提供一个依赖注入DI，这里可以使用DI实例化serbice
        @Autowired
        private UserService myuserservice;

        @Autowired
        private MyCommonMapper mycommon;

        @Autowired
        private MyBillingMapper mybilling;

        @Autowired
        private MyDischargeApplicationMapper dischargeApplication;
        //获取所有的用户
        @RequestMapping("/alluser")
        public String findalluser(Model model){
            //先把后台所有用户查出
            List<Users>myallusers=myuserservice.findall();
            //里面加载，返回页面的同时加载数据，往前端加载数据，需要传入参数
            model.addAttribute("users",myallusers);
            //返回页面
            return "index";
        }
        //登录逻辑
        @RequestMapping("/login/admin")
        public String admin_login(){
            //返回login页面
            return "adminlogin";
        }
        @RequestMapping("/login/patient")
        public String patient_login(){
            //返回login页面
            return "/patientlogin";
        }
        @RequestMapping("/login/doctor")
        public String doctor_login(){
            //返回login页面
            return "doctorlogin";
        }
        @RequestMapping("/login/head-nurse")
        public String head_nurse_login(){
            //返回login页面
            return "matronlogin";
        }
        @RequestMapping("/login/nurse")
        public String nurse_login(){
            //返回login页面
            return "nurselogin";
        }

        @RequestMapping("/newlogin")
        public String newlogin(){
            //返回login页面
            return "newlogin";
        }

        @RequestMapping(value = "ziliaochakan",method={RequestMethod.GET,RequestMethod.POST})
        public String ziliaochakan(Integer id, Model model){
            System.out.println("-------------");
            System.out.println(id);
            MyCommon myallusers=mycommon.selectpatients(id);
            MyCommon myallusers1=mycommon.select_person(id);
            System.out.println("-------------");
            System.out.println(myallusers1);
            System.out.println("-------------");
            model.addAttribute("pat_information",myallusers1);
            Users myuser1=myuserservice.findUserById(id);
            model.addAttribute("user",myuser1);
            System.out.println("222222222222222222222222222");
            if (myallusers1!=null){
                List<Billing> billing = mybilling.selectfeyong(myallusers1.getA_id());
                BigDecimal totalAmount = BigDecimal.ZERO;
                if (billing != null) {
                    for (Billing bill : billing) {
                        if (bill != null && bill.getTotal_amount() != null) {
                            totalAmount = totalAmount.add(bill.getTotal_amount());
                        }
                    }
                    model.addAttribute("totalAmount", totalAmount);
                }else {
                    model.addAttribute("totalAmount", BigDecimal.ZERO);
                }
            }

            if (myallusers1!=null){
                return "patient_page";
            }else {
                return "not_admitted";
            }
        }
        @RequestMapping(value = "zhuyuanxinxi",method={RequestMethod.GET,RequestMethod.POST})
        public String zhuyuanxinxi(Integer id, Model model){

            System.out.println("-------------");
            System.out.println(id);
            MyCommon myallusers=mycommon.selectpatients(id);
            MyCommon myallusers1=mycommon.select_person(id);
            System.out.println("-------------");
            System.out.println(myallusers1);
            System.out.println("-------------");
            model.addAttribute("pat_information",myallusers1);
            Users myuser1=myuserservice.findUserById(id);
            model.addAttribute("user",myuser1);
            System.out.println("222222222222222222222222222");
            System.out.println(myuser1);
            String myclassname = "department";
            List<MyCommon> mycommons = mycommon.selectAll(myclassname);
            model.addAttribute("departments",mycommons);
            //返回login页面
            if (myallusers1!=null){
                return "patient_page1";
            }else {
                return "not_admitted";
            }

        }

        @RequestMapping(value = "feiyongyizhu",method={RequestMethod.GET,RequestMethod.POST})
        public String feiyongyizhu(Integer id, Model model) {
            System.out.println("-------------");
            System.out.println(id);
            MyCommon myallusers = mycommon.selectpatients(id);
            MyCommon myallusers1 = mycommon.select_person(id);
            System.out.println("-------------");
            System.out.println(myallusers1);
            System.out.println("-------------");
            model.addAttribute("pat_information", myallusers1);
            Users myuser1 = myuserservice.findUserById(id);
            model.addAttribute("user", myuser1);
            System.out.println("222222222222222222222222222");
            System.out.println(myuser1);

            if (myallusers1 != null) {
                List<MyCommon> yizhuduanqi = mycommon.selectyizhuduanqi(myallusers1.getPatient_id());
                List<MyCommon> yizhuchangqi = mycommon.selectyizhuchangqi(myallusers1.getPatient_id());
                System.out.println(yizhuchangqi);
                System.out.println(yizhuduanqi);
                model.addAttribute("yizhuduanqi", yizhuduanqi);
                model.addAttribute("yizhuchangqi", yizhuchangqi);
                List<Billing> billing = mybilling.selectfeyong(myallusers1.getA_id());
                // 修改后的关键代码段
                List<Billing> billingList = mybilling.selectfeyongw(myallusers1.getA_id());
                BigDecimal totalAmount = BigDecimal.ZERO;
                BigDecimal totalAmount1 = BigDecimal.ZERO;
                if (billingList != null) {
                    for (Billing bill : billingList) {
                        if (bill != null && bill.getTotal_amount() != null) {
                            totalAmount = totalAmount.add(bill.getTotal_amount());
                        }
                    }
                }

                List<Billing> billingList1 = mybilling.selectfeyongy(myallusers1.getA_id());
                if (billingList1 != null) {
                    for (Billing bill :billingList1) {
                        if (bill != null && bill.getTotal_amount() != null) {
                            totalAmount1= totalAmount1.add(bill.getTotal_amount());
                        }
                    }
                }
                model.addAttribute("feiyong", billing);

                System.out.println(" 12312312312312312"+billing);
                model.addAttribute("feiyongy", billingList);
                model.addAttribute("feiyongw", billingList1);
                model.addAttribute("totalAmount", totalAmount);
                model.addAttribute("totalAmount1", totalAmount1);
                System.out.println("总金额: " + totalAmount1);
                System.out.println("总金额: " + totalAmount);

                System.out.println(billingList);

            }


            if (myallusers1!=null){
                return "patient_page2";
            }else {
                return "not_admitted";
            }
        }
        @RequestMapping(value = "chuyuanguanli",method={RequestMethod.GET,RequestMethod.POST})
        public String chuyuanguanli(Integer id, Model model){
            MyCommon myallusers=mycommon.selectpatients(id);
            MyCommon myallusers1=mycommon.select_person(id);
            model.addAttribute("pat_information",myallusers1);
            Users myuser1=myuserservice.findUserById(id);
            model.addAttribute("user",myuser1);
                if ( myallusers1!=null){
                    DischargeApplication dis=dischargeApplication.selectByPrimaryKey(myallusers1.getPatient_id());
                    System.out.println("admissionid"+myallusers1.getAdmission_id());
                    System.out.println(myallusers1);
                    // 获取当前时间
                //        LocalDateTime updateTime = LocalDateTime.now();
                //        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                //        String formattedTime = updateTime.format(outputFormatter);
                    // 将更新时间添加到Model
                //        model.addAttribute("updateTime", formattedTime);
                    if (dis!=null){
                        System.out.println("---------------------11111-----------");
                        model.addAttribute("dis",dis);
                    }else{
                        System.out.println("---------------------55555-----------");
                        model.addAttribute("dis",null);
                    }
                }


            //返回login页面
            if (myallusers1!=null){
                return "patient_page3";
            }else {
                return "not_admitted";
            }
        }


        @RequestMapping(value = "home",method={RequestMethod.GET,RequestMethod.POST})
        public String login(Model model,int id){
            Users myuser1=myuserservice.findUserById(id);
            model.addAttribute("user",myuser1);
            System.out.println("222222222222222222222222222");
            System.out.println(myuser1);
            //返回login页面
            if (myuser1!=null&&myuser1.getRole()==0){
                MyCommon myallusers=mycommon.selectpatients(myuser1.getId());
                MyCommon myallusers1=mycommon.select_person(myallusers.getUser_id());
                if (myallusers1 == null) {
                    myallusers1 = new MyCommon();
                    myallusers1.setWard_number("暂未住院");
                }
                model.addAttribute("fj",myallusers1);
                model.addAttribute("pat_information",myallusers);
                String myclassname = "department";
                List<MyCommon> mycommons = mycommon.selectAll(myclassname);
                model.addAttribute("departments",mycommons);
                //这里index也需要加载数据库的数据，这里把index改成转发或者重定向
                return "patient_main_page";
            }else if (myuser1!=null&&myuser1.getRole()==1){
                MyCommon myallusers=mycommon.selectstaff(myuser1.getId());
                List<MyCommon> myCommons=mycommon.selecthuanzhebydid(myallusers.getId());
                int totalCount = myCommons.size(); // 计算总条数
                model.addAttribute("patientCount", totalCount);
                model.addAttribute("doc_information",myallusers);
                model.addAttribute("user",myuser1);
                return "doctor_main_page";
            }else if (myuser1!=null&&myuser1.getRole()==2){
                MyCommon myallusers=mycommon.selectstaff(myuser1.getId());
                model.addAttribute("doc_information",myallusers);
                return "matron_main_page";
            }else if (myuser1!=null&&myuser1.getRole()==3){
                MyCommon myallusers=mycommon.selectstaff(myuser1.getId());
                model.addAttribute("doc_information",myallusers);
                return "nurse_main_page";
            }else if (myuser1!=null&&myuser1.getRole()==4){
                return "admin_main_page";
            }else {
                return "forward:/newlogin";
            }
        }
        //还需要接收前端传过来的用户名，到数据中查询，新地址是login_hander，指的是login登录处理
        @RequestMapping(value = "login_handler",method={RequestMethod.GET,RequestMethod.POST})
        //这里只给一个MyUser没有写usn pswd，前端传 usn pswd，自动有一个打包功能
        public String login_handler(Users myuser,Model model, HttpServletRequest request){

            //生成一个localDate类型的变量
            LocalDate null1=LocalDate.of(1,1,1);
            //调用service去使用sql语句查询用户
            Users myuser1=myuserservice.findUserByUsername(myuser);
            // 登录失败处理
            if (myuser1 == null || !myuser1.getPassword().equals(myuser.getPassword())) {
                String roleParam = request.getParameter("role");
                Map<String, String> roleRedirects = new HashMap<String, String>() {{
                    put("0", "redirect:/login/patient?error");
                    put("1", "redirect:/login/doctor?error");
                    put("2", "redirect:/login/head-nurse?error");
                    put("3", "redirect:/login/nurse?error");
                    put("4", "redirect:/login/admin?error");
                }};
                return roleRedirects.getOrDefault(roleParam, "redirect:/newlogin?error");
            }
            System.out.println(myuser1.getUsername());
            System.out.println("-------------");
            System.out.println(myuser1);
            System.out.println("-------------");
            System.out.println(myuser1.getRole());
            if (myuser1!=null&&myuser1.getRole() == 0){
                String myclassname = "department";
                List<MyCommon> mycommons = mycommon.selectAll(myclassname);
                MyCommon myallusers=mycommon.selectpatients(myuser1.getId());

                MyCommon myallusers1=mycommon.select_person(myallusers.getUser_id());
                if (myallusers1 == null) {
                    myallusers1 = new MyCommon();
                    myallusers1.setWard_number("暂未住院");
                }
                model.addAttribute("fj",myallusers1);
                System.out.println(myallusers1);
                model.addAttribute("departments",mycommons);
                model.addAttribute("pat_information",myallusers);
                model.addAttribute("user",myuser1);
                //这里index也需要加载数据库的数据，这里把index改成转发或者重定向
                return "patient_main_page";
            }else if (myuser1!=null&&myuser1.getRole()==1){
                MyCommon myallusers=mycommon.selectstaff(myuser1.getId());
                List<MyCommon> myCommons=mycommon.selecthuanzhebydid(myallusers.getId());
                int totalCount = myCommons.size(); // 计算总条数
                model.addAttribute("patientCount", totalCount);
                model.addAttribute("doc_information",myallusers);
                model.addAttribute("user",myuser1);
                return "doctor_main_page";
            }else if (myuser1!=null&&myuser1.getRole()==2){
                MyCommon myallusers=mycommon.selectstaff(myuser1.getId());
                model.addAttribute("doc_information",myallusers);
                model.addAttribute("user",myuser1);
                return "matron_main_page";
            }else if (myuser1!=null&&myuser1.getRole()==3){
                MyCommon myallusers=mycommon.selectstaff(myuser1.getId());
                List<MyCommon> myCommons=mycommon.selectyizhubyname(myallusers.getReal_name());
                System.out.println(myCommons);
                int totalCount = myCommons.size(); // 计算总条数
                model.addAttribute("patientCount", totalCount);
                model.addAttribute("orders",myCommons);
                model.addAttribute("doc_information",myallusers);
                model.addAttribute("user",myuser1);
                return "nurse_main_page";
            }else if (myuser1!=null&&myuser1.getRole()==4){
                model.addAttribute("user",myuser1);
                return "redirect:/lists?class_name=com.hospital.admin.beans.Admission&page=1";
            }else {
                return "newlogin";
            }


        }

        //显示一个增加用户界面
        @RequestMapping("/register")
        public String register(){
            return "register";
        }


        //增加处理增加用户的逻辑，在逻辑中接收前端发送过来的数据，使用参数
        @RequestMapping(value = "register_handler",method={RequestMethod.GET,RequestMethod.POST})
        public String register_handler(Users myuser){
            //调用service去使用sql语句查询用户
            System.out.println("-------------");
            System.out.println(myuser);
            System.out.println("-------------");
            myuserservice.addUser(myuser);
            System.out.println("-------------");
            System.out.println(myuserservice);
            System.out.println("-------------");
            //如果页面之前完成过，这里使用之前的地址，但是需要一个转发或重定向技术
            //转发是请求一个地址，服务器转向另一个地址forward
            //重新定向是前端把请求地址发出后，之后又重新发送一个地址redir

            return "/patientlogin";
        }
        //增加一个删除的Controller动作,接收一个id，可以放在路径上
        //这里面/deluser/{id}，这里的id采用路径中传入的一个id，因为是路径是的id，这里需要@PathVariable
        @RequestMapping("/deluser/{id}")
        public String delete_User(@PathVariable("id")int id){
            myuserservice.deleteUser(id);
            return "forward:/alluser";
        }
        //产生一个用户更新数据的界面
        @RequestMapping("/updatepage/{id}")
        public String updatepage(@PathVariable("id")int id,Model model){
            Users myuser=myuserservice.findUserById(id);
            model.addAttribute("oneuser",myuser);
            return "modiuser";
        }

        @RequestMapping("/update")
        public String updateuser(Users myuser){
            myuserservice.updateUser(myuser);
            return "forward:/alluser";
        }


}
