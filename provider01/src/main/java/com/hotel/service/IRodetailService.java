package com.hotel.service;

import com.hotel.pojo.Rodetail;

import java.util.List;

public interface IRodetailService {
    List<Rodetail> getAllDetails();

    Rodetail getByRtids(int rtid);
}
