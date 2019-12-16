package com.hotel.dao;

import com.hotel.pojo.RoundType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRoundTypeDao {

    @Select("select * from roundtype")
    List<RoundType> getAllRoundType();

    @Select("select * from roundtype where rotid=#{rotid}")
    RoundType getRoundType(int rotid);

    @Insert("insert into roundtype (rotid,roname)  values(#{rotid},#{roname})")
    int saveRoundType(RoundType roundType);

    @Delete("delete from roundtype  where rotid=#{rotid}")
    int  deleteRoundType(int rotid);

    @Update("update roundtype set  roname=#{roname} where rotid=#{rotid}")
    int  updateRoundType(RoundType roundType);
}
