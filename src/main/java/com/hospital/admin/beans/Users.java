package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("用户名")
    private String username;

    @MyAnnotation("密码")
    private String password;

    @MyAnnotation("角色")
    private int role;

}