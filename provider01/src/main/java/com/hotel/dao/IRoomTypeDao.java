package com.hotel.dao;

import com.hotel.pojo.Finance;
import com.hotel.pojo.Reserve;
import com.hotel.pojo.RoomType;
import com.hotel.pojo.Users;
import com.hotel.pojo.dto.TypeRoom;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import javax.annotation.Resource;
import java.rmi.server.UID;
import java.util.List;

@Mapper
public interface IRoomTypeDao {
    //查询所有房间类型
    @Select("select * from roomtype")
    List<RoomType> getAllRoomType();

    //通过id查询空闲房间
    @Select("select * from roomtype,room where status='空闲' and roomtype.rtid = #{rtid} and room.rtid=#{rtid}")
    List<RoomType> getAllRoomById(int rtid);

    //通过id查询要预定房间的详细信息
    @Select("select * from roomtype,room where roomtype.rtid=room.rtid and rid=#{rid}")
    List<RoomType> getRoomDeteils(int rid);

    //房间预定
    @Insert("insert into reserve values(null,#{rid},#{uid},#{rtimes},'已预订')")
    int reserveroom(Reserve R);

    //更新房间状态为已预订
    @Update("update room set status='已预订' where rid=#{rid}" )
    int updateRoomStates(int rid);

    //更改预定表中的房间状态
    @Update("update reserve set status='已退订' where rid=#{rid}")
    int optRoom(int rid);

    //更新房间状态为空闲
    @Update("update room set status='空闲' where rid=#{rid}" )
    int optRoomStates(int rid);

    //根据rid查询出uid
    @Select("select uid from reserve where rid=#{rid}")
    int getUserId(int rid);

    @Select("select deposit from roomtype,room where room.rtid=roomtype.rtid and rid=#{rid}")
    double getFpr(int rid);

    //财务表添加
    @Insert("insert into finance values(null,#{uid},#{rid},#{ftimes},#{fprice})")
    int setFinance(Finance finance);

    @Update("update users set uprice=#{uprice} where uid=#{uid}")
    int setUserPrice(Users users);
    // 房间类型的详细信息
    @Select("select * from roomtype where rtid=#{rtid}")
    @Results({
            @Result(id =true,property = "rtid",column = "rtid"),
            @Result(property = "roomList" ,column="rtid" ,many=@Many(select="com.hotel.dao.IRoomDao.getAllroom", fetchType = FetchType.LAZY))})
    TypeRoom getTypeRoom(int rtid);

    @Select("select * from users where uid=#{uid}")
    Users getTelByUid(int uid);
}
