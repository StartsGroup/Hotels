package com.hotel.dao;

import com.hotel.pojo.Messages;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IMessagesDao {
    @Insert("insert into messages values(null,#{uid},#{rtid},#{content},#{mtimes})")
    int addMessages(Messages messages);
    //查询留言
    @Select("select * from messages where rtid=#{rtid}")
    List<Messages> getMessages(int rtid);
}
