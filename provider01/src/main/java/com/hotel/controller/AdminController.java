package com.hotel.controller;

import com.hotel.pojo.Admin;
import com.hotel.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }
    @GetMapping("/all/{aid}")
    public Admin getAdminByAid(@PathVariable int aid){
        return adminService.getAdminByAid(aid);
    }
    @PostMapping("/login")
    public Admin login(@RequestBody Admin a){
        return adminService.login(a);
    }
    @PostMapping("/save")
    public String saveAdmin(@RequestBody Admin a){
        boolean flag=adminService.saveAdmin(a);
        String result=(flag ? "success":"fail");
        return result;
    }
    @GetMapping("/delete/{aid}")
    public String deleteAdmin(@PathVariable int aid){
        boolean flag=adminService.deleteAdminByAid(aid);
        String result=(flag ? "success":"fail");
        return result;
    }
}
