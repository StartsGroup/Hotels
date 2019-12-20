package com.hotel.dao;

import com.hotel.pojo.Rounds;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRoundsDao {

    @Results({@Result(column = "rotid",property = "roundtype",one =@One(select = "com.hotel.dao.IRoundTypeDao.getRoundType"))})
    @Select("select  * from rounds   ")
    List<Rounds>  getAllRound();

    @Results({@Result(column = "rotid",property = "roundtype",one =@One(select = "com.hotel.dao.IRoundTypeDao.getRoundType"))})
    @Select("select * from rounds where roid=#{roid}")
    Rounds getById( int roid);


    @Insert("insert into rounds (roid,rotid,title,img) values(#{roid},#{rotid},#{title},#{img})")
    int saveRounds(Rounds rounds);


    @Update("update rounds set rotid=#{rotid},title=#{title},img=#{img} where roid=#{roid} ")
    int updateRounds(Rounds rounds);

    @Delete("delete from  rounds  where roid=#{roid}")
    int deleteRounds(int roid);

    @Select("select * from rounds where rotid = #{rotid}")
    List<Rounds> getRoundsByRotid(int rotid);

}
