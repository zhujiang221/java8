package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("住院记录ID")
    private int admission_id;

    @MyAnnotation("费用类型")
    private int item_type;

    @MyAnnotation("项目名称")
    private String item_name;

    @MyAnnotation("数量")
    private int quantity;

    @MyAnnotation("单价")
    private BigDecimal unit_price;

    @MyAnnotation("总金额")
    private BigDecimal total_amount;

    @MyAnnotation("生成时间")
    private Date create_time;

    @MyAnnotation("支付状态")
    private String bill_status;

    @MyAnnotation("操作人ID")
    private Integer operator_id;



    private BigDecimal totalAmount; // 或通过@Column映射数据库字段

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    private BigDecimal totalAmount1; // 或通过@Column映射数据库字段

    public BigDecimal getTotalAmount1() {
        return totalAmount1;
    }


}