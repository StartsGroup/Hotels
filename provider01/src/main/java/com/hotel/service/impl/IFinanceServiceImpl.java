package com.hotel.service.impl;

import com.hotel.dao.IFinanceDao;
import com.hotel.pojo.Finance;
import com.hotel.service.IFinaneService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class IFinanceServiceImpl implements IFinaneService {
    @Resource
    private IFinanceDao iFinanceDao;
    @Override
    public boolean saveFinance(Finance finance) {
        return iFinanceDao.saveFinance(finance)>0;
    }

    @Override
    public boolean deleteFinance(int fid) {
        return iFinanceDao.deleteFinance(fid)>0;
    }
}
