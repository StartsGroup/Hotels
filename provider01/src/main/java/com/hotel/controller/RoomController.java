package com.hotel.controller;

import com.hotel.pojo.Room;
import com.hotel.pojo.dto.Details;
import com.hotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provideroom")
public class RoomController {

    @Resource
    private IRoomService roomService;

    @GetMapping("/allRoom")
    public List<Room> getAllRoom(){

        return  roomService.getAllRooms();
    }

    @GetMapping("/getRoom/{rid}")
    public Details getById(@PathVariable int  rid){

        return roomService.getRoomByIds(rid);
    }
    //添加房间
    @PostMapping("/save")
    public boolean saveRoom(@RequestBody Room room){
        return roomService.saveRoom(room);
    }
    @GetMapping("/delete/{rid}")
    public boolean deleteRoom(@PathVariable int rid){
        return  roomService.deleteRoom(rid);
    }
    @PostMapping("/update")
    public boolean updateRooomStatus(@RequestBody Room room){
        return roomService.updateRoomStatus(room);
    }
    @GetMapping("/price/{rid}")
    @ResponseBody
    public double getRoomprice(@PathVariable int rid){
        return roomService.getRoomPrice(rid);
    }
}
