package com.xss.libraryfinal.service.impl;

import com.xss.libraryfinal.domain.Admin;
import com.xss.libraryfinal.mapper.AdminMapper;
import com.xss.libraryfinal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void insert(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    @Override
    public Admin findByAccount(String adminAccount) {
        return adminMapper.findByAccount(adminAccount);
    }

    @Override
    public Admin findByAdmin(Admin admin) {
        return adminMapper.findByAdmin(admin);
    }
}
