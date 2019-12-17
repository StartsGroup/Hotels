package com.hotel.service;

import com.hotel.pojo.Finance;
import org.apache.ibatis.annotations.Delete;

public interface IFinaneService {
    boolean saveFinance(Finance finance);
    boolean deleteFinance(int fid);
}
