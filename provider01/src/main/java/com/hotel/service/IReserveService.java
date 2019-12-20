package com.hotel.service;


import com.hotel.pojo.Reserve;
import com.hotel.pojo.Room;

import java.util.List;

public interface IReserveService {

    List<Reserve>  getAllReserve();

    boolean deleteReserve(int reid);

    boolean updateServers(int rid);
}
