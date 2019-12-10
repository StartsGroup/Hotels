package com.hotel.dao;

import com.hotel.pojo.Team;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeamDao {
    //查询所有
    @Select("select * from team")
    List<Team> getAllTeam();
    //团队登录
    @Select("select * from team where tname=#{tname} and tpass=#{tpass}")
    Team login(Team t);
    //团队注册
    @Insert("insert into team values(null,#{tname},#{tpass},#{tpeople},#{tel},#{times})")
    int saveTeam(Team t);
    //按ID查询
    @Select("select * from team where tid=#{tid}")
    Team getTeamByTid(int tid);
    //删除
    @Delete("delete from team where tid=#{tid}")
    int deleteTeamByTid(int tid);
    //修改信息
    @Update("update team set tname=#{tname},tpass=#{tpass},tpeople=#{tpeople},tel=#{tel} where tid=#{tid}")
    int updateTeamByTid(Team t);
}
