package com.hotel.dao;

import com.hotel.pojo.Rounds;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRoundsDao {

    @Results({@Result(column = "rotid",property = "roundtype",one =@One(select = "com.hotel.dao.IRoundTypeDao.getRoundType"))})
    @Select("select  * from rounds   ")
    List<Rounds>  getAllRound();

    @Results({@Result(column = "rotid",property = "roundtype",one =@One(select = "com.hotel.dao.IRoundTypeDao.getRoundType"))})
    @Select("select * from rounds where roid=#{roid}")
    Rounds getById( int roid);
}
