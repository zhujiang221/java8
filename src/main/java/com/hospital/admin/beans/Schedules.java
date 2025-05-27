package com.hospital.admin.beans;

import com.hospital.admin.myinterface.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedules {

    @MyAnnotation("编号")
    private int id;

    @MyAnnotation("护士ID")
    private int nurse_id;

    @MyAnnotation("班次ID")
    private int shift_id;

    @MyAnnotation("排班日期")
    private Date schedule_date;

}