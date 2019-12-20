package com.hotel.dao;

import com.hotel.pojo.Rodetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRodetailDao {
    @Results({@Result(column = "roid",property = "rounds",one =@One(select = "com.hotel.dao.IRoundsDao.getById"))})
    @Select("select * from rodetail")
    List<Rodetail> getAllDetail();

    @Results({@Result(column = "roid",property = "rounds",one =@One(select = "com.hotel.dao.IRoundsDao.getById"))})
    @Select("select * from rodetail  where  rtid=#{rtid}")
    Rodetail getByRtid(int rtid);


    @Insert("insert into rodetail (rtid,roid,addr,remark,retime,rprice) values(null,#{roid},#{addr},#{remark},#{retime},#{rprice})")
    int saveRodetail(Rodetail rodetail);

    @Delete("delete from rodetail  where rtid=#{rtid}")
    int deleteRodetail(int rtid);


    @Update("update rodetail  set roid=#{roid},addr=#{addr},remark=#{remark},retime=#{retime},rprice=#{rprice} where rtid=#{rtid}")
    int updateRodetail(Rodetail rodetail);
}
