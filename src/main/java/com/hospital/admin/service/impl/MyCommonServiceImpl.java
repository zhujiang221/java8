package com.hospital.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hospital.admin.beans.MyCommon;
import com.hospital.admin.beans.MyNewResult;
import com.hospital.admin.beans.MyPageResult;
import com.hospital.admin.beans.MyResult;
import com.hospital.admin.mapper.MyCommonMapper;
import com.hospital.admin.service.MyCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class MyCommonServiceImpl implements MyCommonService {
    //
    @Autowired
    private MyCommonMapper mycommon;

    @Override
    public int deleteByPrimaryKey(MyResult myResult) {
        return mycommon.deleteByPrimaryKey(myResult);
    }

    @Override
    public int insertSelective(MyNewResult record) {
        return mycommon.insertSelective(record);
    }

    @Override
    public MyCommon selectByPrimaryKey(MyResult myResult) {
        return mycommon.selectByPrimaryKey(myResult);
    }

    @Override
    public List<MyCommon> selectAll(String table_name) {
        return mycommon.selectAll(table_name);
    }

    @Override
    public int updateByPrimaryKeySelective(MyNewResult record) {
        return mycommon.updateByPrimaryKeySelective(record);
    }

    //调用后台医院工作人员和患者的信息
    @Override
    public MyCommon selectpatients(int id) {
        return mycommon.selectpatients(id);
    }
    @Override
    public MyCommon selectstaff(int id) {
        return mycommon.selectstaff(id);
    }

    @Override
    public MyCommon select_person(int id) {
        return mycommon.select_person(id);
    }

    @Override
    public List<MyCommon> selectyizhuduanqi(int id) {
        return mycommon.selectyizhuduanqi(id);
    }

    @Override
    public List<MyCommon> selectyizhuchangqi(int id) {
        return mycommon.selectyizhuduanqi(id);
    }

    @Override
    public List<MyCommon> selectyizhu(int id) {
        return mycommon.selectyizhu(id);
}

    @Override
    public List<MyCommon> selecthuanzhebydid(int id) {
        return mycommon.selecthuanzhebydid(id);
    }

    @Override
    public List<MyCommon> selectyizhubyname(String name) {
        return mycommon.selectyizhubyname(name);
    }
    @Override
    public MyPageResult selectAllByPage(int page, String class_name) {

        Page mypage= PageHelper.startPage(page,8);
        System.out.println("-------121212--------");
        System.out.println(mypage);
        System.out.println("---------------");
        // 根据类名查询所有数据

        List<MyCommon> myCommons = mycommon.selectAll(class_name);
        // 返回分页后的结果
        System.out.println("------131313---------");
        System.out.println(mypage);
        System.out.println("---------------");
        MyPageResult myPageResult=new MyPageResult();
        myPageResult.setMycommons(myCommons);
        myPageResult.setPageNum(mypage.getPageNum());
        myPageResult.setPages(mypage.getPages());
        myPageResult.setTotal(mypage.getTotal());
        return myPageResult;
    }
}
