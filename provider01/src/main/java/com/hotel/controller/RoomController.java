package com.hotel.controller;

import com.hotel.pojo.Room;
import com.hotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @GetMapping("/allRoom")
    public List<Room> getAllRoom(){

        return  roomService.getAllRooms();
    }

    @GetMapping("/getRoom/{rid}")
    public Room getById(@PathVariable int  rid){

        return roomService.getRoomByIds(rid);
    }
}
