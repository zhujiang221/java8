package com.hospital.admin.service;

import com.hospital.admin.beans.Users;

import java.util.List;

public interface UserService {
    //查询所有接口
    public List<Users> findall();
    //写一个查询用户是否存在的severvice
    public Users findUserByUsername(Users myuser);
    //添加一个用户的service，一般情况下mapper有什么接口，service就具备什么接口
    public void addUser(Users myuser);
    //增加一个删除方法，不出意外的和mapper一致
    public void deleteUser(int id);
    //根据id查找用户
    public Users findUserById(int id);
    //再去修改用户，由于xml中update更新标签中没有result返回，这里返回还是void
    public void updateUser(Users myuser);

}
