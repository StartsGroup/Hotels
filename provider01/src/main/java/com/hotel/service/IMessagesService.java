package com.hotel.service;


import com.hotel.pojo.Messages;

import java.util.List;

public interface IMessagesService {
    boolean addMessages(Messages messages);
    List<Messages> getMessages(int rtid);
}
