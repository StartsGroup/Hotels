package com.hotel.controller;

import com.hotel.pojo.Users;
import com.hotel.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/login")
    public Users login(@RequestBody Users u){
        return userService.login(u);
    }
    @PostMapping("ve")
    public boolean saveUsers(@RequestBody Users u){
        return userService.saveUsers(u);
    }
    @PostMapping("/delete/{uid}")
    public String deleteUsersByUid(@PathVariable int uid){
        boolean flag=userService.deleteUserByUid(uid);
        String result=(flag ? "success":"fail");
        return result;
    }
    @GetMapping("/all/{uid}")
    public Users getUsersByUid(@PathVariable int uid){
        return userService.getUsersByUid(uid);
    }
    @PostMapping("/update")
    public String updateUsersByUid(@RequestBody Users u){
        boolean flag=userService.updateUsersByUid(u);
        String result=(flag ? "success":"fail");
        return result;
    }
    @GetMapping("/get/{uname}")
    public Users getUsersByUname(@PathVariable String uname){
        return userService.getUsersByUname(uname);
    }

    //根据id修改用户信息
    @PostMapping("/updateuserpass")
    public String updateAdminPassByAid(@RequestBody Users u){
        boolean flag=userService.updateUserPass(u);
        String result=(flag ? "success":"fail");
        return result;
    }
}
