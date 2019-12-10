package com.hotel.dao;

import com.hotel.pojo.Rodetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRodetailDao {

    List<Rodetail> getAllDetail();

    Rodetail getByRtid(int rtid);
}
