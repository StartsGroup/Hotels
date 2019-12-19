package com.hotel.service.impl;

import com.hotel.dao.IRoomTypeDao;
import com.hotel.pojo.Finance;
import com.hotel.pojo.Reserve;
import com.hotel.pojo.RoomType;
import com.hotel.pojo.Users;
import com.hotel.service.IRoomTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements IRoomTypeService {

    @Resource
    private IRoomTypeDao roomTypeDao;

    //查询房间所有类别
    @Override
    public List<RoomType> getAllRoomType() {
        return roomTypeDao.getAllRoomType();
    }

    //添加房间类型
    @Override
    public boolean saveRoomType(RoomType rt) {
        return roomTypeDao.saveRoomType(rt)>0;
    }

    //通过id查询空闲房间
    @Override
    public List<RoomType> getAllRoomById(int rtid) {
        return roomTypeDao.getAllRoomById(rtid);
    }

    @Override
    public List<RoomType> getRoomDeteils(int rid) {
        return roomTypeDao.getRoomDeteils(rid);
    }

    @Override
    public boolean reserveroom(Reserve R) {
        return roomTypeDao.reserveroom(R)>0;
    }

    @Override
    public boolean updateRoomStates(int rid) {
        return roomTypeDao.updateRoomStates(rid)>0;
    }

    @Override
    public boolean optRoom(int rid) {
        return roomTypeDao.optRoomStates(rid)>0;
    }

    @Override
    public boolean optRoomStates(int rid) {
        return roomTypeDao.optRoom(rid)>0;
    }

    @Override
    public int getUserId(int rid) {
        return roomTypeDao.getUserId(rid);
    }

    @Override
    public double getFpr(int rid) {
        return roomTypeDao.getFpr(rid);
    }

    @Override
    public boolean setFinance(Finance finance) {
        return roomTypeDao.setFinance(finance)>0;
    }

    @Override
    public boolean setUserPrice(Users users) {
        return roomTypeDao.setUserPrice(users)>0;
    }

}
