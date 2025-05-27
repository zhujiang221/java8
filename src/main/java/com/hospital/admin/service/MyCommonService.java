package com.hospital.admin.service;

import com.hospital.admin.beans.MyCommon;
import com.hospital.admin.beans.MyNewResult;
import com.hospital.admin.beans.MyPageResult;
import com.hospital.admin.beans.MyResult;

import java.util.List;

public interface MyCommonService {

    int deleteByPrimaryKey(MyResult myResult);

    int insertSelective(MyNewResult record);

    MyCommon selectByPrimaryKey(MyResult myResult);

    List<MyCommon> selectAll(String table_name);

    int updateByPrimaryKeySelective(MyNewResult record);

    //调用后台医院工作人员和患者的信息
    MyCommon selectpatients(int id);

    MyCommon selectstaff(int id);

    MyCommon select_person(int id);

    //查询医嘱
    List<MyCommon> selectyizhuduanqi(int id);

    List<MyCommon> selectyizhuchangqi(int id);

    List<MyCommon>  selectyizhu(int id);

    List<MyCommon> selecthuanzhebydid(int id);

    List<MyCommon> selectyizhubyname(String name);

    MyPageResult selectAllByPage(int page, String class_name);

}