package com.hotel.dao;

import com.hotel.pojo.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface UserDao {
    //查询所有
    @Select("select * from users ")
    List<Users> getAllUsers();
    //登录
    @Select("select * from users where uname=#{uname} and upassword=#{upassword}")
    Users login(Users u);
    //散客注册
    @Insert("insert into users(uid,uname,upassword,userid,tel,uprice) values(null,#{uname},#{upassword},#{userid},#{tel},#{uprice})")
    int saveUsers(Users u);
    //删除
    @Delete("delete from users where uid=#{uid}")
    int deleteUserByUid(int uid);
    //按ID查询
    @Select("select * from users where uid=#{uid}")
    Users getUsersByUid(int uid);
    //修改信息
    @Update("update users set uname=#{uname},upassword=#{upassword},userid=#{userid},tel=#{tel},uprice=#{uprice} where uid=#{uid}")
    int updateUsersByUid(Users u);
    //按姓名查
    @Select("select * from users where uname=#{uname}")
    Users getUsersByUname(String uname);

    //修改密码，通过uid
    @Update("update users set upassword=#{upassword} where uid=#{uid}")
    int updateUserPass(Users u);

}
