package com.hotel.service;

import com.hotel.pojo.Register;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface IRegisterService {
    //用户信息的登记
    boolean saveRegister(Register register);
    //用户登记信息的查看
    List<Register> getAllRegister();
    //用户登记信息的删除
    boolean deleteRegister(int rgid);
    //根据用户名修改用户的状态（该用户预定的状态改为该用户已入住）
    boolean updateRegister(Register register);
    //查询某个人的入住信息
    Register getRegisterById(int uid);
    //获取日期
    String getDate(Register register);
    boolean updateStatus(Register register);
}
