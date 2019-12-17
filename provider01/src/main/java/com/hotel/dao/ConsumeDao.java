package com.hotel.dao;

import com.hotel.pojo.Consume;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConsumeDao {
    //查询所有
    @Select("select cid,consume.uid,consume.rid,uname,consume.pid,pname,price,count,adds,ctime,consume.status from consume,users,products where consume.uid=users.uid and consume.pid=products.pid and consume.status='未结算'")
    List<Consume> getAllConsume();
    //查询所有
    @Select("select cid,consume.uid,consume.rid,uname,consume.pid,pname,price,count,adds,ctime,consume.status from consume,users,products where consume.uid=users.uid and consume.pid=products.pid and consume.status='未结算'")
    List<Consume> getAll2Consume();
    //按房间查询
    @Select("select cid,consume.uid,consume.rid,uname,consume.pid,pname,price,count,adds,ctime,consume.status from consume,users,products where consume.uid=users.uid and consume.pid=products.pid and rid=#{rid} and consume.status='未结算'")
    List<Consume> getAllConsumeByRid(int rid);
    //添加消费
    @Insert("insert into consume values(null,#{rid},#{uid},#{pid},#{count},#{adds},#{ctime},'未结算')")
    int saveConsume(Consume c);
    //按用户查询
    @Select("select cid,consume.uid,consume.rid,uname,consume.pid,pname,price,count,adds,ctime,consume.status from consume,users,products where consume.uid=users.uid and consume.pid=products.pid")
    List<Consume> getAllConsumeByUid(int uid);

}
