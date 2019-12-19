package com.hotel.service;

import com.hotel.pojo.Finance;
import com.hotel.pojo.Reserve;
import com.hotel.pojo.RoomType;
import com.hotel.pojo.Users;
import com.hotel.pojo.dto.TypeRoom;

import java.util.List;

public interface IRoomTypeService {

    //房间的所有类别
    List<RoomType> getAllRoomType();

    //添加房间类型
    boolean saveRoomType(RoomType rt);

    //通过id查询空闲房间
    List<RoomType> getAllRoomById(int rtid);

    //通过id查询要预定房间的详细信息
    List<RoomType> getRoomDeteils(int rid);

    //预定房间
    boolean reserveroom(Reserve R);

    //更新房间状态
    boolean updateRoomStates(int rid);

    //更改预定表中的房间状态
    boolean optRoom(int rid);

    //更新房间状态为空闲
    boolean optRoomStates(int rid);

    //通过rid获取用于id
    int getUserId(int rid);

    //通过rid获取定金
    double getFpr(int rid);

    //添加财务表
    boolean setFinance(Finance finance);

    //添加用户消费
    boolean setUserPrice(Users users);

    TypeRoom getTypeRoom(int rtid);

    //通过uid查询tel
    Users getTelByUid(int uid);
}
