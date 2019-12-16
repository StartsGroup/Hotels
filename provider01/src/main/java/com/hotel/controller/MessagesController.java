package com.hotel.controller;

import com.hotel.pojo.Messages;
import com.hotel.service.IMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private IMessagesService messagesService;

    //留言
    @PostMapping("/add")
    public String addMessages(@RequestBody Messages messages){
        System.out.println(messages);
        boolean flag = messagesService.addMessages(messages);
        String result = (flag ? "success" : "fail");
        return result;
    }
}
