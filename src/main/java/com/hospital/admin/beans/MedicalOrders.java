package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalOrders {

    @MyAnnotation("编号")
    private Integer id;

    @MyAnnotation("患者ID")
    private Integer patient_id;

    @MyAnnotation("住院记录ID")
    private Integer admission_id;

    @MyAnnotation("开嘱医生ID")
    private Integer doctor_id;

    @MyAnnotation("类型(0:长期医嘱 1:临时医嘱)")
    private Integer order_type;

    @MyAnnotation("医嘱内容")
    private String order_content;

    @MyAnnotation("状态(0:待执行 1:执行中 2:已完成)")
    private Integer order_status;

    @MyAnnotation("创建时间")
    private Date create_time;

    @MyAnnotation("执行时间")
    private Date execute_time;

    @MyAnnotation("执行人")
    private String real_name;

}
