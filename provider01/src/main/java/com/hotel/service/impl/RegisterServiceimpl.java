package com.hotel.service.impl;

import com.hotel.dao.IRegisterDao;
import com.hotel.pojo.Register;
import com.hotel.service.IRegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceimpl implements IRegisterService {
    @Resource
    private IRegisterDao iRegisterDao;

    @Override
    public boolean saveRegister(Register register) {
        return iRegisterDao.saveRegister(register)>0;
    }

    @Override
    public List<Register> getAllRegister() {
        return iRegisterDao.getAllRegister();
    }

    @Override
    public boolean deleteRegister(int rgid) {
        return iRegisterDao.deleteRegister(rgid)>0;
    }

    @Override
    public boolean updateRegister(Register register) {
        return iRegisterDao.updateRegister(register)>0;
    }

    @Override
    public Register getRegisterById(int uid) {
        return iRegisterDao.getRegisterById(uid);
    }

    @Override
    public String getDate(Register register) {
        return iRegisterDao.getDate(register);
    }
}
