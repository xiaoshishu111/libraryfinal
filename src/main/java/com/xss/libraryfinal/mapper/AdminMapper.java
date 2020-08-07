package com.xss.libraryfinal.mapper;

import com.xss.libraryfinal.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(String adminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> findAll();

    Admin findByAccount(String adminaccount);

    Admin findByAdmin(Admin admin);
}