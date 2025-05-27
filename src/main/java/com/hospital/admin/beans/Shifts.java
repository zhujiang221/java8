package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shifts {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("班次名称")
    private String shift_name;

    @MyAnnotation("开始时间")
    private Time start_time;

    @MyAnnotation("结束时间")
    private Time end_time;

    @MyAnnotation("班次说明")
    private String description;

}
