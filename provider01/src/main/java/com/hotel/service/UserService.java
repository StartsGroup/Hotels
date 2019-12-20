package com.hotel.service;

import com.hotel.pojo.Users;

import java.util.List;

public interface UserService {

    List<Users> getAllUsers();

    Users login(Users u);

    boolean saveUsers(Users u);

    boolean deleteUserByUid(int uid);

    Users getUsersByUid(int uid);

    boolean updateUsersByUid(Users u);

    Users getUsersByUname(String uname);

    //修改密码，通过uid
    boolean updateUserPass(Users u);
}
