package com.hotel.controller;

import com.hotel.pojo.Register;
import com.hotel.service.IRegisterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private IRegisterService iRegisterService;
    //用户信息的登记
    @PostMapping("/save")
    boolean saveRegister(@RequestBody Register register){
        return iRegisterService.saveRegister(register);
    }
    //用户登记信息的查看
    @GetMapping("/all")
    List<Register> getAllRegister(){
        return iRegisterService.getAllRegister();
    }
    //用户登记信息的删除
    @GetMapping("/delete/{rgid}")
    boolean deleteRegister(int rgid){
        return iRegisterService.deleteRegister(rgid);
    }
    //根据用户名修改用户的状态（该用户预定的状态改为该用户已入住）
    @PostMapping("/update")
    boolean updateRegister(@RequestBody Register register){
        return iRegisterService.updateRegister(register);
    }
    //查询某个人的入住信息
    @GetMapping("/ById/{uid}")
    Register getRegisterById(@PathVariable int uid){
        return iRegisterService.getRegisterById(uid);
    }
}
