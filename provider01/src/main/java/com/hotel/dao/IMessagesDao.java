package com.hotel.dao;

import com.hotel.pojo.Messages;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMessagesDao {
    @Insert("insert into messages values(null,#{uid},#{rtid},#{content},#{mtimes})")
    int addMessages(Messages messages);
}
