package com.hotel.dao;

import com.hotel.pojo.Reserve;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface IReserveDao {

    @Results({@Result(column = "uid",property = "users",one =@One(select = "com.hotel.dao.UserDao.getUsersByUid")), @Result(column = "rid",property = "room",one =@One(select = "com.hotel.dao.IRoomDao.getRoomByIdRegister"))})
    @Select("select * from reserve where status='已预订'")
    List<Reserve> getAllReserve();

    @Delete("delete  from  reserve  where  reid=#{reid}")
    int deleteReserve(int reid);

    @Update("update reserve  set status='已入住'  where rid=#{rid}")
    int updateServer(int rid);



}
