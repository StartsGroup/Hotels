package com.hotel.service.serviceImpl;

import com.hotel.dao.UserDao;
import com.hotel.pojo.Users;
import com.hotel.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Users login(Users u) {
        return userDao.login(u);
    }

    @Override
    public boolean saveUsers(Users u) {
        return userDao.saveUsers(u)>0;
    }

    @Override
    public boolean deleteUserByUid(int uid) {
        return userDao.deleteUserByUid(uid)>0;
    }

    @Override
    public Users getUsersByUid(int uid) {
        return userDao.getUsersByUid(uid);
    }

    @Override
    public boolean updateUsersByUid(Users u) {
        return userDao.updateUsersByUid(u)>0;
    }
}
