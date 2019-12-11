package com.hotel.service;

import com.hotel.pojo.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmin();

    Admin getAdminByAid(int aid);

    Admin login(Admin a);

    boolean saveAdmin(Admin a);

    boolean deleteAdminByAid(int aid);
}
