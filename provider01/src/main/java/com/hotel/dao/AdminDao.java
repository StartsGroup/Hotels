package com.hotel.dao;

import com.hotel.pojo.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminDao {
    //查询所有员工
    @Select("select * from admin,adtype where admin.atid=adtype.atid and aid > 1")
    List<Admin> getAllAdmin();
    //按ID查询
    @Select("select * from admin,adtype where admin.atid=adtype.atid and aid=#{aid}")
    Admin getAdminByAid(int aid);
    //登录
    @Select("select * from admin where aname=#{aname} and apass=#{apass}")
    Admin login(Admin a);
    //添加
    @Insert("insert into admin values(null,#{atid},#{aname},#{apass},#{addr},#{atel},#{asex})")
    int saveAdmin(Admin a);
    //删除
    @Delete("delete from admin where aid=#{aid}")
    int deleteAdminByAid(int aid);
}
