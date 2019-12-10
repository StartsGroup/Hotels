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
}
