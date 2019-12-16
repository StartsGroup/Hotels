package com.hotel.dao;

import com.hotel.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRoomDao {
    @Select("select * from room")
    List<Room>  getAllRoom();
    @Select("select * from room where rid=#{rid}")
    Room getRoomById(int rid);
    //添加房间
    @Insert("insert into room values(null,#{rtid},#{status})")
    int saveRoom(Room room);
    //删除房间
    @Delete("delete from room where rid=#{rid}")
    int deleteRoom(int rid);
}
