package com.hotel.service.impl;

import com.hotel.dao.IRoomDao;
import com.hotel.pojo.Room;
import com.hotel.pojo.RoomType;
import com.hotel.pojo.dto.Details;
import com.hotel.service.IRoomService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class IRoomServiceImpl implements IRoomService {

    @Resource
    private IRoomDao roomDao;

    @Override
    public List<Room> getAllRooms() {
        return roomDao.getAllRoom();
    }

    @Override
    public Details getRoomByIds(int rid) {
        return roomDao.getRoomById(rid);
    }

    @Override
    public boolean saveRoom(Room room) {
        return roomDao.saveRoom(room)>0;
    }

    @Override
    public boolean deleteRoom(int rid) {
        return roomDao.deleteRoom(rid)>0;
    }

    @Override
    public boolean updateRoomStatus(Room room) {
        return roomDao.updateRoomStatus(room)>0;
    }

    @Override
    public double getRoomPrice(int rid) {
        return roomDao.getRoomPrice(rid);
    }

    @Override
    public boolean updateStatus(int rid) {
        return roomDao.updateStatus(rid)>0;
    }

    @Override
    public Room getRid(int rid) {
        return roomDao.getRid(rid);
    }
}
