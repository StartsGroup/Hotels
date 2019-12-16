package com.hotel.dao;

import com.hotel.pojo.Room;
import com.hotel.pojo.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IRoomDao {

    List<Room>  getAllRoom();

    Room getRoomById(int rid);

}
