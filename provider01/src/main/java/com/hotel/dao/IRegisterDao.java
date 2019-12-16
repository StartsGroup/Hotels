package com.hotel.dao;

import com.hotel.pojo.Register;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
    @Select("select * from register where uid=#{uid} ")
    Register getRegisterById(int uid);
}
