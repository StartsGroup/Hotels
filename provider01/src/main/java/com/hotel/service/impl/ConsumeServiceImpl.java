package com.hotel.service.impl;

import com.hotel.dao.ConsumeDao;
import com.hotel.pojo.Consume;
import com.hotel.service.ConsumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ConsumeServiceImpl implements ConsumeService {
    @Resource
    private ConsumeDao consumeDao;

    @Override
    public List<Consume> getAllConsume() {
        return consumeDao.getAllConsume();
    }

    @Override
    public List<Consume> getAllConsumeByRid(int rid) {
        return consumeDao.getAllConsumeByRid(rid);
    }

    @Override
    public boolean saveConsume(Consume c) {
        return consumeDao.saveConsume(c)>0;
    }

    @Override
    public List<Consume> getAllConsumeByUid(int uid) {
        return consumeDao.getAllConsumeByUid(uid);
    }

    @Override
    public List<Consume> getAll2Consume() {
        return consumeDao.getAll2Consume();
    }

    @Override
    public boolean updateStatus(Consume consume) {
        return consumeDao.updateStatus(consume)>0;
    }

    @Override
    public List<Consume> getComsume(Consume consume) {
        return consumeDao.getComsume(consume);
    }
}
