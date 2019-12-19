package com.hotel.service;

import com.hotel.pojo.Consume;

import java.util.List;

public interface ConsumeService {
    List<Consume> getAllConsume();

    List<Consume> getAllConsumeByRid(int rid);

    boolean saveConsume(Consume c);

    List<Consume> getAllConsumeByUid(int uid);

    List<Consume> getAll2Consume();
    //退房功能的实现
    boolean  updateStatus(Consume consume);

    List<Consume> getComsume(Consume consume);
}
