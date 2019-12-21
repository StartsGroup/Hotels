package com.hotel.service.impl;

import com.hotel.dao.IRoundsDao;
import com.hotel.pojo.Rounds;
import com.hotel.service.IRoundsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public  class IRoundsServiceImpl  implements IRoundsService {

    @Resource
    private IRoundsDao roundsDao;

    @Override
    public List<Rounds> getAllRounds() {

        return roundsDao.getAllRound();
    }

    @Override
    public Rounds getByIds(int roid) {
        return roundsDao.getById(roid);
    }

    @Override
    public boolean saveRounds(Rounds rounds) {
        return roundsDao.saveRounds(rounds)>0;
    }

    @Override
    public boolean updateRounds(Rounds rounds) {
        return roundsDao.updateRounds(rounds)>0;
    }

    @Override
    public boolean deleteRounds(int roid) {
        return roundsDao.deleteRounds(roid)>0;
    }

    @Override
    public List<Rounds> getRoundsByRotid(int rotid) {
        return roundsDao.getRoundsByRotid(rotid);
    }
}
