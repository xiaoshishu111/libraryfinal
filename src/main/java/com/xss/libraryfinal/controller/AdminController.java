package com.xss.libraryfinal.controller;

import com.xss.libraryfinal.domain.Admin;
import com.xss.libraryfinal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> findAll(){
        return adminService.findAll();
    }

/*验证账户是否存在*/
    @PostMapping(value = "/adminAccount/{adminAccount}")
    public Admin findByAccount(@PathVariable String adminAccount) {
        Admin admin=new Admin();
        admin.setAdminaccount(adminAccount);
        admin=adminService.findByAdmin(admin);
        return admin;
    }
/*验证该账户的密码是否输入正确*/
    @PostMapping(value = "/adminAccount/password")
    public Admin findPasswordByAccount(Admin admin, HttpServletResponse response) {
//        response.setContentType("application/json");
        admin=adminService.findByAdmin(admin);
        return admin;
    }


}
