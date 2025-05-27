package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admission {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("患者ID")
    private int patient_id;

    @MyAnnotation("病房ID")
    private int ward_id;

    @MyAnnotation("主治医生ID")
    private int doctor_id;

    @MyAnnotation("入院时间")
    private Date admission_time;

    @MyAnnotation("出院时间")
    private Date discharge_time;

    @MyAnnotation("诊断结果")
    private String diagnosis;

    @MyAnnotation("状态")
    private int status;

}