package com.hotel.dao;

import com.hotel.pojo.RoundType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRoundTypeDao {
    List<RoundType> getAllRoundType();

    RoundType getRoundType(int rotid);
}
