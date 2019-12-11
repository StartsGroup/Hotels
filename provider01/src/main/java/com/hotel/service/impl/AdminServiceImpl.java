package com.hotel.service.impl;

import com.hotel.dao.AdminDao;
import com.hotel.pojo.Admin;
import com.hotel.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.getAllAdmin();
    }

    @Override
    public Admin getAdminByAid(int aid) {
        return adminDao.getAdminByAid(aid);
    }

    @Override
    public Admin login(Admin a) {
        return adminDao.login(a);
    }

    @Override
    public boolean saveAdmin(Admin a) {
        return adminDao.saveAdmin(a)>0;
    }

    @Override
    public boolean deleteAdminByAid(int aid) {
        return adminDao.deleteAdminByAid(aid)>0;
    }
}
