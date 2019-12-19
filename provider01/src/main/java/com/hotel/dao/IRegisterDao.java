package com.hotel.dao;

import com.hotel.pojo.Register;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface IRegisterDao {
    //用户信息的登记
    @Insert("insert into register values(null,#{uid},#{rid},#{rgtimes},#{status})")
    int saveRegister(Register register);
    //用户登记信息的查看
    @Select("select * from register")
    List<Register> getAllRegister();
    //用户登记信息的删除
    @Delete("delete from register where rgid=#{rgid}")
    int deleteRegister(int rgid);
    //根据用户名修改用户的状态（该用户预定的状态改为该用户已入住）
    @Update("update register set status=#{status} where uid=#{uid}")
    int updateRegister(Register register);
    //查询某个人的入住信息
    @Select("select * from register where uid=#{uid}and status='已入住' ")
    Register getRegisterById(int uid);
    //根据uid及rid和入住状态获取入住时间
    @Select("select rgtimes from register where uid=#{uid} and rid=#{rid} and status='已入住'")
    String getDate(Register registers);
    //退房功能的实现
    @Update("update register set status='已退房' where uid=#{uid} and rid=#{rid}")
    int updateStatus(Register register);
}
