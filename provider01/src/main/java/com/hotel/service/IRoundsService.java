package com.hotel.service;

import com.hotel.pojo.Rounds;

import java.util.List;

public interface IRoundsService {
    List<Rounds> getAllRounds();

    Rounds getByIds( int roid);
}
