package com.hotel.service.impl;

import com.hotel.dao.IRoomDao;
import com.hotel.pojo.Room;
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
    public Room getRoomByIds(int rid) {
        return roomDao.getRoomById(rid);
    }
}
