package com.hotel.dao;

import com.hotel.pojo.Room;
import com.hotel.pojo.dto.Details;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRoomDao {
    @Select("select * from room,roomtype where room.rtid=roomtype.rtid")
    List<Room> getAllRoom();

    @Select("SELECT room.rid,u.uid,u.uname,t.rtid,t.rtname,r.rgtimes from room room,roomtype t,users u,register r WHERE room.rid=#{rid} and room.rtid=t.rtid and  room.rid=r.rid and r.uid=u.uid and r.status='已入住'")
    Details getRoomById(int rid);

    @Results({@Result(column = "rtid",property = "roomType",one =@One(select = "com.hotel.dao.IRoomTypeDao.getUserIdRe"))})
    @Select("select * from room where rid=#{rid}")
    Room getRoomByIdRegister(int rid);

    //添加房间
    @Insert("insert into room values(#{rid},#{rtid},'空闲')")
    int saveRoom(Room room);

    //删除房间
    @Delete("delete from room where rid=#{rid}")
    int deleteRoom(int rid);
    @Update("update room set status=#{status} where rid=#{rid}")
    int updateRoomStatus(Room room);
    //获取每种类型的价格
    @Select("select t.price from roomtype t,room r where t.rtid=r.rtid and r.rid=#{rid}")
    double getRoomPrice(int rid);
    //退房的实现
    @Update("update room set status='空闲' where rid=#{rid}")
    int updateStatus(int rid);
    //查询类型下的所有房间
    @Select("select * from room where rtid=#{rtid} and status='空闲'")
    List<Room> getAllroom(int rtid);
}
