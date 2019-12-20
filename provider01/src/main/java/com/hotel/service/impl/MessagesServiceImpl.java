package com.hotel.service.impl;

import com.hotel.dao.IMessagesDao;
import com.hotel.pojo.Messages;
import com.hotel.service.IMessagesService;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessagesServiceImpl implements IMessagesService {

    @Autowired
    private IMessagesDao messagesDao;

    @Override
    public boolean addMessages(Messages messages) {
        System.out.println(messages+"0000000000000000000");
        return messagesDao.addMessages(messages)>0;
    }

    @Override
    public List<Messages> getMessages(int rtid) {
        return messagesDao.getMessages(rtid);
    }
}
