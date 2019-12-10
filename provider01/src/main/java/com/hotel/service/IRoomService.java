package com.hotel.service;

import com.hotel.pojo.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRooms();

    Room getRoomByIds(int rid);
}