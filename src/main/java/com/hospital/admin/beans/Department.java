package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("科室名")
    private String d_name;

    @MyAnnotation("科室描述")
    private String description;

    @MyAnnotation("科室位置")
    private String department;


}