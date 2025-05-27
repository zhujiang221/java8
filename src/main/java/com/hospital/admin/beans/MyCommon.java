package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyCommon {

    //Admission
    private Integer id;
    private Integer patient_id=-1;
    private int ward_id=-1;
    private int doctor_id=-1;
//    private Date admission_time;
//    private Date discharge_time;
    private String diagnosis;
    private int status=-1;
    private int a_id;

    //Billing
    private int item_type=-1;
    private String item_name;
    private int quantity=-1;
    private BigDecimal unit_price;
    private BigDecimal total_amount;
//    private Date create_time;
    private String bill_status;
    private Integer operator_id=-1;

    //Department
    private String d_name;

    //Patient
    private String name;
    private String patient_name;
    private int sex=-1;
//    private Date birthdate;
    private String contact;
    private String patient_contact;
    private String patient_description;
    private int p_id=-1;
    private int patient_user_id=-1;

    //Schedules
//    private int nurse_id=-1;
//    private int shift_id=-1;
//    private Date schedule_date;

    //Shifts
//    private String shift_name;
//    private Time start_time;
//    private Time end_time;
    private String description;

    //Staff
    private int user_id=-1;
    private String real_name;
    private String department;
    private String title;
    private String e_title;
    private String staff_department;
    private String contact_d;
    private String doctor_name;
    private int s_id=-1;
    //Users
    private String username;
    private String password;
    private int role=-1;

    //Wards
    private String ward_number;
    private int ward_type=-1;
    private int bed_capacity=-1;
    private int current_status=-1;
    private String w_description;
    private String w_department;



    //MedicalOrders
    private Integer admission_id=-1;
    private Integer order_type=-1;
    private String order_content;
    private Integer order_status=-1;


    // MyCommon.java日期字段修改
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate admission_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate discharge_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate schedule_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime execute_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime apply_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime approve_time;

    //DischargeApplication
    private String apply_reason;
    private Integer approve_doctor_id=-1;
    private Integer approve_status=-1;
    private String approve_comment;

    //seckill

    private String good_name;
    private double good_price=-1.0;
    private int good_count=-1;
    private Date good_start_time;
    private Date good_end_time;

    //Order
    private int good_id=-1;
    private int mycount=-1;
    private int mysum=-1;
    private String address;
    private String tel;




}
