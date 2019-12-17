package com.hotel.service;

import com.hotel.pojo.Room;
import com.hotel.pojo.dto.Details;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRooms();

    Details getRoomByIds(int rid);
    boolean saveRoom(Room room);
    boolean deleteRoom(int rid);
    boolean updateRoomStatus(Room room);
    double getRoomPrice(int rid);
}
