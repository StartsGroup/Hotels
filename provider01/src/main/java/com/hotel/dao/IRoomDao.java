package com.hotel.dao;

import com.hotel.pojo.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRoomDao {
    @Results({@Result(column = "rtid",property = "rodetail",one =@One(select = "com.hotel.dao.IRodetailDao.getByRtid"))})
    @Select("select * from room")
    List<Room>  getAllRoom();

    @Results({@Result(column = "rtid",property = "rodetail",one =@One(select = "com.hotel.dao.IRodetailDao.getByRtid"))})
    @Select("select * from room where rid=#{rid}")
    Room getRoomById(int rid);

}
