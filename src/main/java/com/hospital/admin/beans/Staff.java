package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("用户ID")
    private int user_id;

    @MyAnnotation("姓名")
    private String real_name;

    @MyAnnotation("所属科室")
    private String department;

    @MyAnnotation("职称")
    private String title;

    @MyAnnotation("联系方式")
    private String contact;

}