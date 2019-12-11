package com.hotel.service.impl;

import com.hotel.dao.IRodetailDao;
import com.hotel.pojo.Rodetail;
import com.hotel.service.IRodetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IRodetailServiceImpl implements IRodetailService {

    @Resource
    private IRodetailDao rodetailDao;

    @Override
    public List<Rodetail> getAllDetails() {
        return rodetailDao.getAllDetail();
    }

    @Override
    public Rodetail getByRtids(int rtid) {
        return rodetailDao.getByRtid(rtid);
    }

    @Override
    public boolean deleteRodetails(int rtid) {
        return rodetailDao.deleteRodetail(rtid)>0;
    }

    @Override
    public boolean saveRodetail(Rodetail rodetail) {
        return rodetailDao.saveRodetail(rodetail)>0;
    }

    @Override
    public boolean updateRodetail(Rodetail redetail) {
        return rodetailDao.updateRodetail(redetail)>0;
    }
}
