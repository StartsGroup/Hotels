package com.hotel.dao;

import com.hotel.pojo.Rodetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRodetailDao {
    @Results({@Result(column = "roid",property = "rounds",one =@One(select = "com.hotel.dao.IRoundsDao.getById"))})
    @Select("select * from rodetail")
    List<Rodetail> getAllDetail();

    @Results({@Result(column = "roid",property = "rounds",one =@One(select = "com.hotel.dao.IRoundsDao.getById"))})
    @Select("select * from rodetail  where  rtid=#{rtid}")
    Rodetail getByRtid(int rtid);
}
