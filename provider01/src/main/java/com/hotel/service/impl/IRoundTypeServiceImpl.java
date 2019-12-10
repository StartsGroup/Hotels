package com.hotel.service.impl;

import com.hotel.dao.IRoundTypeDao;
import com.hotel.pojo.RoundType;
import com.hotel.service.IRoundTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IRoundTypeServiceImpl implements IRoundTypeService {

    @Resource
    private IRoundTypeDao roundTypeDao;


    @Override
    public List<RoundType> getAllRoundTypes() {
        return roundTypeDao.getAllRoundType();
    }

    @Override
    public RoundType getRoundType(int rotid) {
        return roundTypeDao.getRoundType(rotid);
    }
}
