package com.hotel.controller;

import com.hotel.pojo.Users;
import com.hotel.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private IUserService  userService;

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/login")
    public Users login(@RequestBody Users u){
        return userService.login(u);
    }
    @PostMapping("/save")
    public String saveUsers(@RequestBody Users u){
        boolean flag=userService.saveUsers(u);
        String result=(flag ? "success":"fail");
        return result;
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
    public String updateUsersByUid(Users u){
        boolean flag=userService.updateUsersByUid(u);
        String result=(flag ? "success":"fail");
        return result;
    }
}
