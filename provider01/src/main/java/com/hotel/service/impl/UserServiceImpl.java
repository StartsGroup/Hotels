package com.hotel.service.impl;

import com.hotel.dao.UserDao;
import com.hotel.pojo.Users;
import com.hotel.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }


    public Users login(Users u) {
        return userDao.login(u);
    }


    public boolean saveUsers(Users u) {
        return userDao.saveUsers(u)>0;
    }


    public boolean deleteUserByUid(int uid) {
        return userDao.deleteUserByUid(uid)>0;
    }

    public Users getUsersByUid(int uid) {
        return userDao.getUsersByUid(uid);
    }


    public boolean updateUsersByUid(Users u) {
        return userDao.updateUsersByUid(u)>0;
    }

    @Override
    public Users getUsersByUname(String uname) {
        return userDao.getUsersByUname(uname);
    }
}
