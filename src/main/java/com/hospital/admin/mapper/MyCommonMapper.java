package com.hospital.admin.mapper;

import com.hospital.admin.beans.MyCommon;
import com.hospital.admin.beans.MyNewResult;
import com.hospital.admin.beans.MyResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MyCommonMapper {

    int deleteByPrimaryKey(MyResult myResult);

    int insertSelective(MyNewResult record);
    //按照id查用户
    MyCommon selectByPrimaryKey(MyResult  myResult);
    //这个方法添加一个表名的参数
    List<MyCommon> selectAll(String table_name);
    //按照id修改用户
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
}