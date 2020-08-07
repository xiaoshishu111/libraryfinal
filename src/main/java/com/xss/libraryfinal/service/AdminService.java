package com.xss.libraryfinal.service;

import com.xss.libraryfinal.domain.Admin;

import java.util.List;

public interface AdminService {
    //    插入一条数据
    void insert(Admin admin);

    //    查找出所有数据
    List<Admin> findAll();

    //通过账号查找数据
    Admin findByAccount(String adminaccount);

    //查看该账户的密码输否输入正确
    Admin findByAdmin(Admin admin);

}
