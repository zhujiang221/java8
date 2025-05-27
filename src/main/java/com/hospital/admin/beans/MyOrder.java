package com.hospital.admin.beans;


import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrder implements Serializable {

    @MyAnnotation("编号")
    private int id;
    @MyAnnotation("商品ID")
    private int good_id;
    @MyAnnotation("用户ID")
    private int user_id;
    @MyAnnotation("数量")
    private int mycount;
    @MyAnnotation("价格")
    private int mysum;
    @MyAnnotation("地址")
    private String address;
    @MyAnnotation("电话号")
    private String tel;

}
