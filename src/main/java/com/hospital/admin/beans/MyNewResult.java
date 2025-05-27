package com.hospital.admin.beans;


import com.hospital.admin.beans.MyCommon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyNewResult {

    private MyCommon myCommon;

    public String table_name;

}
