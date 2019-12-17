package com.hotel.controller;

import com.hotel.pojo.Register;
import com.hotel.pojo.Room;
import com.hotel.service.IRegisterService;
import com.hotel.service.IRoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private IRegisterService iRegisterService;
    @Resource
    private IRoomService roomService;
    //用户信息的登记
    @PostMapping("/save")
    boolean saveRegister(@RequestBody Register register){
        Room room=new Room();
        room.setRid(register.getRid());
        room.setStatus(register.getStatus());
        return iRegisterService.saveRegister(register)==roomService.updateRoomStatus(room);
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
    @GetMapping("/date")
    @ResponseBody
    public String getDate( Register register){
        return  iRegisterService.getDate(register);
    }
}
