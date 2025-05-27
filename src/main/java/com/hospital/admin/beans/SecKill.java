package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecKill {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("商品姓名")
    private String good_name;

    @MyAnnotation("商品价格")
    private double good_price;

    @MyAnnotation("商品数量")
    private int good_count;

    @MyAnnotation("秒杀开始时间")
    private Date good_start_time;

    @MyAnnotation("秒杀结束时间")
    private Date good_end_time;

}
