package com.hotel.dao;

import com.hotel.pojo.Finance;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IFinanceDao {
    @Insert("insert into finance values(null,#{uid},#{rid},#{ftimes},#{fprice})")
    int saveFinance(Finance finance);
    @Delete("delete finance from finance where fid=#{fid}")
    int deleteFinance(int fid);
}
