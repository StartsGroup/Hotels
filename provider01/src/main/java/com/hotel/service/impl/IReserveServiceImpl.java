package com.hotel.service.impl;

import com.hotel.dao.IReserveDao;
import com.hotel.pojo.Reserve;
import com.hotel.service.IReserveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IReserveServiceImpl implements IReserveService {

    @Resource
    private IReserveDao reserveDao;

    @Override
    public List<Reserve> getAllReserve() {

        return reserveDao.getAllReserve();
    }

    @Override
    public boolean deleteReserve(int reid) {
        return reserveDao.deleteReserve(reid)>0;
    }

    @Override
    public boolean updateServers(int rid) {
        return reserveDao.updateServer(rid)>0;
    }
}
