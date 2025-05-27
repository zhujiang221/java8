package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wards {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("病房编号")
    private String ward_number;

    @MyAnnotation("病房类型")
    private int ward_type;

    @MyAnnotation("床位数量")
    private int bed_capacity;

    @MyAnnotation("当前状态")
    private int current_status;

    @MyAnnotation("所属科室")
    private String department;

    @MyAnnotation("病房位置")
    private String description;

}