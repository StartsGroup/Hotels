package com.hotel.service;

import com.hotel.pojo.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmin();

    Admin getAdminByAid(int aid);

    Admin login(Admin a);

    boolean saveAdmin(Admin a);

    boolean deleteAdminByAid(int aid);

    //根据id修改用户信息
    boolean updateAdmin(Admin a);

    //根据id修改admin的密码
    boolean updateAdminPassByAid(Admin a);
}
