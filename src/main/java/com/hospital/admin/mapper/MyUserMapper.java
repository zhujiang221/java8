package com.hospital.admin.mapper;

import com.hospital.admin.beans.Users;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface MyUserMapper {
    //查询所有接口名称
    public List<Users> findall();
    //添加一个登录接口
    public Users findUserByUsername(Users myuser);
    //添加一个用户,这里返回值为void，没有返回值，因为mybatis的xml中没有提供result
    public void addUser(Users myuser);
    //增加一个删除的方法
    public void deleteUser(int id);
    //根据id查找用户
    public Users findUserById(int id);
    //再去修改用户，由于xml中update更新标签中没有result返回，这里返回还是void
    public void updateUser(Users myuser);


}
