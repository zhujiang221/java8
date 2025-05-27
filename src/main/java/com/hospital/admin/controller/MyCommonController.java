package com.hospital.admin.controller;

import com.hospital.admin.beans.*;
import com.hospital.admin.myinterface.MyAnnotation;
import com.hospital.admin.service.MyCommonService;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Consumer;

//通用
@Controller
@RequestMapping("/")
public
class  MyCommonController {
    //这里先把service注入
    @Autowired
    private MyCommonService mycommon;

    @RequestMapping("/lists")
    public  String findalllist(String class_name,int page, Model model){
        //这里class_name为了变成方便，不再是一个类名，是包+类名，这里取表先去类
        String[] myclasses=class_name.split("\\.");
        //需要得到按，差分数组的最后一个元素
        int len=myclasses.length;
        String table_name=myclasses[len-1];
        //这里面的class_name就是一个类名，把类名小写就是表名
        String myclassname=table_name.toLowerCase();
        //有了表名，就可以直接调用serice的语句，这里的myclassname就是表名
        MyPageResult mycommons=mycommon.selectAllByPage(page,myclassname);
        System.out.println(mycommons);
        //传动前端进行展示
        //反射进入到对应类中找属性，反射方法先用class_forname后面跟的类名，这个类名必须包名+类名
        //先定义一个属性集合属性集合的作用是为了在前端显示对应的数据
        try {
            //反射到对应类
            Class myclass= Class.forName(class_name);
            //去类中所有的属性
            Field[] myfields=myclass.getDeclaredFields();
            //定义一个注解的list
            List<String> myannotations=new ArrayList<>();
            //列表中这能放一个类型，先构建一个反射后方法列表，方法列表中根据类型决定方法
            //这里把方法定义成string的key键，，get有返回类型，把返回类型定义一个值
            List<Map<String,String>> myarrs=new ArrayList<>();


            for(Field myfild:myfields){
                if(myfild.getAnnotation(MyAnnotation.class)!=null){
                    String  myname= myfild.getAnnotation(MyAnnotation.class).value();
                    myannotations.add(myname);
                    Map<String,String> myhash=new HashMap<>();
                    String fieldname=myfild.getName();
                    //这里为了方便执行get方法,把这个fieldname构建get方法
                    //第一个字母大写，其他小写
                    String fieldmethod="get"+
                            fieldname.substring(0,1).toUpperCase()+fieldname.substring(1);
                    String fieldtype=myfild.getType().toString();

                    myhash.put(fieldmethod,fieldtype);
                    myarrs.add(myhash);
                }

            }
            System.out.println(myarrs);
//            System.out.println(myannotations);
            List<List<String>> mydatas=new ArrayList<>();
            Class myclass1=Class.forName("com.hospital.admin.beans.MyCommon");
            //遍历所有的数据库数据进行值按顺序添加
            List<MyCommon> myothercommons=mycommons.getMycommons();
            for (MyCommon mycommon:myothercommons){
                //对每一个类实例调用get
                //在遍历所有get方法，遍历前先初始化里面的列表
                List<String> myneiarr=new ArrayList<>();
                //遍历每一个按顺序摆放的map数据
                for(Map<String,String> myarr:myarrs){
                    //获取每一个map的键名，遍历时只有一个键名,这里的entry是map中的每一项
                    Set<Map.Entry<String,String>> myentrys=myarr.entrySet();
                    for(Map.Entry<String,String> myentry:myentrys){
                        //这里使用反射方法，
                        Method mymethod=myclass1.getDeclaredMethod(myentry.getKey());
                        //这里吧mymothod做invoke代理,返回值只能返回一切杰对象
                        Object myobj=mymethod.invoke(mycommon);
                        //这里myobj转成字符串
//                        myneiarr.add(myobj.toString());
                        myneiarr.add(myobj != null ? myobj.toString() : "待更新");
                    }
                }
                mydatas.add(myneiarr);
            }
            System.out.println(mydatas);
            //这里需要实例化才可以获得属性，反射类一样可以实例化
            System.out.println("--------annotations--------");
            System.out.println(myannotations);
            model.addAttribute("annotations",myannotations);
            model.addAttribute("datas",mydatas);
            model.addAttribute("class_name",class_name);
            model.addAttribute("pages",mycommons.getPages());
            model.addAttribute("total",mycommons.getTotal());
            model.addAttribute("pagenum",mycommons.getPageNum());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "admin_main_page";
    }

        //删除,接受一个id，这个 id可以放在路径上
        //这里面deluser(id)，这里的id采用路径中传入一个id，因为是路径上的id，需要@pathvarible
        @RequestMapping("/delitem")
        public String del_User(String class_name, int id) {
            //这里把class_name做一下分割
            String[] arr = class_name.split("\\.");
            int len = arr.length;
            //实例化一个myresult，传入service中
            MyResult myResult = new MyResult();
            myResult.setId(id);
            myResult.setTable_name(arr[len - 1].toLowerCase());
            mycommon.deleteByPrimaryKey(myResult);
            //redirect重定向，发生在客户端
            //forward转发，发生在服务器端
            //这里使用redirect重定向，重定向是客户端的行为，
    //        return "redirect:/lists?class_name=" + class_name;
            return "forward:/lists";
            //如果是转发的话 return "forward:/lists"; 没有必要传参数了
        }
        @RequestMapping("/delitem1")
        public String delete_User1(String class_name,int id){
            String[] arr=class_name.split("\\.");
            int len= arr.length;
            MyResult myresult=new MyResult();
            myresult.setId(id);
            myresult.setTable_name(arr[len-1].toLowerCase());
            mycommon.deleteByPrimaryKey(myresult);
            return "redirect:/lists?class_name=com.older.user.beans.MyUser&page=1";
        }

        //这里，我们使用个地址来描述一下
        @RequestMapping("/address")
        public String getaddress() {
            return "forward:/lists?class_name=com.hospital.admin.beans.Users";
        }

        @RequestMapping("/addpage")
        public String addpage(String class_name,Model model){
            try {
                //反射到对应类
                Class myclass= Class.forName(class_name);
                //去类中所有的属性
                Field[] myfields=myclass.getDeclaredFields();
                //定义一个注解的list
                List<String> myannotations=new ArrayList<>();
                List<String> mynames=new ArrayList<>();
                for(Field myfield:myfields){
                    if(myfield.getAnnotation(MyAnnotation.class)!=null){
                        String  myname= myfield.getAnnotation(MyAnnotation.class).value();
                        myannotations.add(myname);
                        mynames.add(myfield.getName());
                    }

                }
                model.addAttribute("anotations",myannotations);
                model.addAttribute("names",mynames);
                model.addAttribute("class_name",class_name);
                System.out.println(myannotations);
                System.out.println(mynames);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            return "add";
        }


        @RequestMapping("addpage_handler")
        public String addpage_makehandler(MyCommon common,String class_name){
            //先把class_name转成表名
            String[] myclasses=class_name.split("\\.");
            //需要得到按，差分数组的最后一个元素
            int len=myclasses.length;
            String table_name=myclasses[len-1];
            //这里面的class_name就是一个类名，把类名小写就是表名
            String myclassname=table_name.toLowerCase();
            MyNewResult mynew=new MyNewResult();
            mynew.setMyCommon(common);
            mynew.setTable_name(myclassname);
            mycommon.insertSelective(mynew);
            return "redirect:/lists?class_name=" + class_name + "&page=1";
//            return "redirect:/lists?class_name=com.hospital.admin.beans.Users&page=1";
        }


        @RequestMapping("/updatepage")
        public String updatepage(String class_name,int id,Model model){
            String[] myclasses=class_name.split("\\.");
            //需要得到按，差分数组的最后一个元素
            int len=myclasses.length;
            String table_name=myclasses[len-1];
            //这里面的class_name就是一个类名，把类名小写就是表名
            String myclassname=table_name.toLowerCase();
            try {
                System.out.println(class_name);
                //反射到对应类
                Class myclass= Class.forName(class_name);
                //去类中所有的属性
                Field[] myfields=myclass.getDeclaredFields();
                //定义一个注解的list
                List<String> myannotations=new ArrayList<>();
                List<String> mynames=new ArrayList<>();
                MyResult myresult=new MyResult();
                myresult.setId(id);
                myresult.setTable_name(myclassname);
                MyCommon common= mycommon.selectByPrimaryKey(myresult);
                Class myclass1=Class.forName("com.hospital.admin.beans.MyCommon");
                List<String> myvalues=new ArrayList<>();
                for(Field myfield:myfields){
                    if(myfield.getAnnotation(MyAnnotation.class)!=null){
                        String  myname= myfield.getAnnotation(MyAnnotation.class).value();
                        myannotations.add(myname);
                        mynames.add(myfield.getName());
                        String fieldname=myfield.getName();
                        String myfieldname="get"+fieldname.substring(0,1).toUpperCase()+fieldname.substring(1);
                        Method mymethod=myclass1.getDeclaredMethod(myfieldname);
                        Object myobj=mymethod.invoke(common);
                        myvalues.add(myobj.toString());
                    }

                }
                model.addAttribute("anotations",myannotations);
                model.addAttribute("names",mynames);
                model.addAttribute("class_name",class_name);
                model.addAttribute("dbvalues",myvalues);
                System.out.println(myannotations);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            return "update";
        }
        @RequestMapping("updatepage_handler")
        public String updatepage_makehandler(MyCommon common,String class_name){
            //先把class_name转成表名
            String[] myclasses=class_name.split("\\.");
            //需要得到按，差分数组的最后一个元素
            int len=myclasses.length;
            String table_name=myclasses[len-1];
            //这里面的class_name就是一个类名，把类名小写就是表名
            String myclassname=table_name.toLowerCase();
            MyNewResult mynew=new MyNewResult();
            mynew.setMyCommon(common);
            mynew.setTable_name(myclassname);
            mycommon.updateByPrimaryKeySelective(mynew);
            return "redirect:/lists?class_name=" + class_name + "&page=1";
//            return "redirect:/lists?class_name=com.hospital.admin.beans.Users&page=1";
        }


    // Common_update方法,这个方法使用到localdate，可以处理年月日时间数据类型
    @RequestMapping(value = "Common_update", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String common_update_handler(
            @RequestParam("class_name") String className,
            @ModelAttribute MyCommon common,
            HttpServletRequest request) {
        String response = new String();
        try {
            // 创建线程安全的日期格式化工具
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ");
            // 处理所有日期字段转换
            Map<String, Consumer<LocalDate>> dateSetters = new HashMap<>();
            dateSetters.put("birthdate", common::setBirthdate);
//            dateSetters.put("create_time", common::setCreate_time);
            dateSetters.put("admission_time", common::setAdmission_time);
            dateSetters.put("discharge_time", common::setDischarge_time);
            dateSetters.put("schedule_date", common::setSchedule_date);
//            dateSetters.put("execute_time", common::setExecute_time);


            for (Map.Entry<String, Consumer<LocalDate>> entry : dateSetters.entrySet()) {
                String paramValue = request.getParameter(entry.getKey());
                if (paramValue != null && !paramValue.isEmpty()) {
                    try {
                        LocalDate date = LocalDate.parse(paramValue, formatter);
                        entry.getValue().accept(date);
                    } catch (DateTimeParseException e) {
                        System.err.println("日期格式错误: " + paramValue);
                        // 保留原始值或处理错误逻辑
                    }
                }
            }

            // 获取表名并执行更新
            String[] classParts = className.split("\\.");
            String tableName = classParts[classParts.length - 1].toLowerCase();

            MyNewResult updateParams = new MyNewResult();
            updateParams.setTable_name(tableName);
            updateParams.setMyCommon(common);
            mycommon.updateByPrimaryKeySelective(updateParams);
            return "success";
        } catch (Exception e) {
            return "修改失败: " + e.getMessage();

        }

    }

    // 修改后的Common_updatehh方法,这个方法使用到localdatetime，可以处理年月日时分秒的时间数据类型
    @RequestMapping(value = "Common_updatehh", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String common_update(
            @RequestParam("class_name") String className,
            @ModelAttribute MyCommon common,
            HttpServletRequest request) {
        String response = new String();
        try {

            // 创建线程安全的日期格式化工具
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // 处理所有日期字段转换
            Map<String, Consumer<LocalDateTime>> dateSetters = new HashMap<>();
            dateSetters.put("apply_time", common::setApply_time);
            dateSetters.put("approve_time", common::setApprove_time);
            dateSetters.put("execute_time", common::setExecute_time);

            for (Map.Entry<String, Consumer<LocalDateTime>> entry : dateSetters.entrySet()) {
                String paramValue = request.getParameter(entry.getKey());
                if (paramValue != null && !paramValue.isEmpty()) {
                    try {
                        LocalDateTime date = LocalDateTime.parse(paramValue, formatter);
                        entry.getValue().accept(date);
                    } catch (DateTimeParseException e) {
                        System.err.println("日期格式错误: " + paramValue);
                        // 保留原始值或处理错误逻辑
                    }
                }
            }
            LocalDateTime updateTime = LocalDateTime.now();
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = updateTime.format(outputFormatter);
            // 获取表名并执行更新
            String[] classParts = className.split("\\.");
            String tableName = classParts[classParts.length - 1].toLowerCase();

            MyNewResult updateParams = new MyNewResult();
            updateParams.setTable_name(tableName);
            updateParams.setMyCommon(common);
            mycommon.updateByPrimaryKeySelective(updateParams);
            return "success";
        } catch (Exception e) {
            return "修改失败: " + e.getMessage();

        }

    }

    @RequestMapping(value = "Common_insert", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String common_insert_handler(
            @RequestParam("class_name") String className,
            @ModelAttribute MyCommon common,
            HttpServletRequest request) {
        System.out.println("111111111111111111111111111111111");

        try {
            System.out.println("22222222222222222222222222222222");
            // 日期处理（与update保持一致的逻辑）
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Map<String, Consumer<LocalDate>> dateSetters = new HashMap<>();
            dateSetters.put("birthdate", common::setBirthdate);
//            dateSetters.put("create_time", common::setCreate_time);
            dateSetters.put("admission_time", common::setAdmission_time);
            dateSetters.put("discharge_time", common::setDischarge_time);
            dateSetters.put("schedule_date", common::setSchedule_date);
//            dateSetters.put("execute_time", common::setExecute_time);
//            dateSetters.put("apply_time", common::setApply_time);
//            dateSetters.put("approve_time", common::setApprove_time);


            for (Map.Entry<String, Consumer<LocalDate>> entry : dateSetters.entrySet()) {
                String paramValue = request.getParameter(entry.getKey());
                if (paramValue != null && !paramValue.isEmpty()) {
                    try {
                        LocalDate date = LocalDate.parse(paramValue, formatter);
                        entry.getValue().accept(date);
                    } catch (DateTimeParseException e) {
                        System.err.println("日期格式错误: " + paramValue);
                        // 保持原有默认值或记录错误
                    }
                }
            }


            // 表名解析逻辑（与update一致）
            String[] classParts = className.split("\\.");
            String tableName = classParts[classParts.length - 1].toLowerCase();
            System.out.println("444444444444444444444444444444444444444444");
            // 构建插入参数
            MyNewResult insertParams = new MyNewResult();
            insertParams.setTable_name(tableName);
            insertParams.setMyCommon(common);

            // 执行插入
            int result = mycommon.insertSelective(insertParams);

            return "success";
        } catch (Exception e) {
            return "插入失败: " + e.getMessage();
        }
    }


        @RequestMapping(value = "Common_del", method = {RequestMethod.GET, RequestMethod.POST})
        @ResponseBody
        public String common__del(
                @RequestParam("class_name") String className,
                int id,
                HttpServletRequest request) {

            try {
                // 表名解析逻辑（与update一致）
                String[] classParts = className.split("\\.");
                String tableName = classParts[classParts.length - 1].toLowerCase();
                // 构建插入参数
                MyResult insertParams = new MyResult();
                insertParams.setTable_name(tableName);
                insertParams.setId(id);

                // 执行插入
                int result = mycommon.deleteByPrimaryKey(insertParams);

                return "success";
            } catch (Exception e) {
                return "插入失败: " + e.getMessage();
            }
        }


}
