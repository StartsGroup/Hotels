package com.hotel.dao;

import com.hotel.pojo.Rounds;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRoundsDao {

    List<Rounds>  getAllRound();

    Rounds getById( int roid);
}
