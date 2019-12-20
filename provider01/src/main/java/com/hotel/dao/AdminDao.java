package com.hotel.dao;

import com.hotel.pojo.Admin;
import com.hotel.pojo.Adtype;
import org.apache.ibatis.annotations.*;

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

    //根据id修改用户信息
    @Update("update admin set atid=#{atid},aname=#{aname},apass=#{apass},addr=#{addr},atel=#{atel},asex=#{asex} where aid = #{aid}")
    int updateAdmin(Admin a);

    //根据id修改admin的密码
    @Update("update admin set apass=#{apass} where aid=#{aid}")
    int updateAdminPassByAid(Admin a);

    //查询所有角色
    @Select("select * from adtype where atid>1")
    List<Adtype> getAllAdtype();
}
