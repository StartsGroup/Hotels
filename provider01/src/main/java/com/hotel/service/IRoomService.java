package com.hotel.service;

import com.hotel.pojo.Room;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRooms();

    Room getRoomByIds(int rid);
    boolean saveRoom(Room room);
    boolean deleteRoom(int rid);
    boolean updateRoomStatus(Room room);
}
