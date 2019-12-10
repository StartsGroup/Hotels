package com.hotel.service;

import com.hotel.pojo.RoundType;

import java.util.List;

public interface IRoundTypeService {
    List<RoundType> getAllRoundTypes();

    RoundType getRoundType(int rotid);
}
