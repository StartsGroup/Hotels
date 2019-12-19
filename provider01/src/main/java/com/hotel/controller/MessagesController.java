package com.hotel.controller;

import com.hotel.pojo.Messages;
import com.hotel.service.IMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import javax.xml.transform.Result;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private IMessagesService messagesService;

    //留言
    @PostMapping("/add")
    public boolean addMessages(@RequestBody Messages messages){
        System.out.println(messages);
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String mtimes = format.format(date);
        messages.setMtimes(mtimes);
        boolean flag = messagesService.addMessages(messages);

        return flag;
    }
    //查看留言
    @GetMapping("/getMessage/{rtid}")
    public List<Messages> getMessage(@PathVariable int rtid){
        return messagesService.getMessages(rtid);
    }

}
