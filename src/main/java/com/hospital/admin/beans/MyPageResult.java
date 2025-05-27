package com.hospital.admin.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPageResult {
    private int pageNum;
    private long total;
    private int pages;
    private List<MyCommon> mycommons;
}
