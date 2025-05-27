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
public class DischargeApplication {

    @MyAnnotation("编号")
    private Integer id;

    @MyAnnotation("患者ID")
    private Integer patient_id;

    @MyAnnotation("住院记录ID")
    private Integer admission_id;

    @MyAnnotation("申请时间")
    private Date apply_time;

    @MyAnnotation("申请原因")
    private String apply_reason;

    @MyAnnotation("审批医生ID")
    private Integer approve_doctor_id;

    @MyAnnotation("审批状态")
    private Integer approve_status;

    @MyAnnotation("审批意见")
    private String approve_comment;

    @MyAnnotation("审批时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date approve_time;
}