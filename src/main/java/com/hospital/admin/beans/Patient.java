package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("用户ID")
    private int user_id;

    @MyAnnotation("姓名")
    private String name;

    @MyAnnotation("性别")
    private int sex;

    @MyAnnotation("出生日期")
    private Date birthdate;

    @MyAnnotation("联系方式")
    private String contact;

    @MyAnnotation("创建时间")
    private Date create_time;

    @MyAnnotation("患者描述")
    private String description;



}