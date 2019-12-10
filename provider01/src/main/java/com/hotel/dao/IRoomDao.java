package com.hotel.dao;

import com.hotel.pojo.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRoomDao {

    List<Room>  getAllRoom();

    Room getRoomById(int rid);

}
