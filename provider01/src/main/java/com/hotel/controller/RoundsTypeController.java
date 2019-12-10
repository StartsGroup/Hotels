package com.hotel.controller;

import com.hotel.pojo.RoundType;
import com.hotel.service.IRoundTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoundsTypeController {

    @Autowired
    private IRoundTypeService roundTypeService;

    @GetMapping("/allType")
    public List<RoundType> getAllType(){
        return roundTypeService.getAllRoundTypes();
    }

    @GetMapping("/getType/{rotid}")
    public RoundType getById(@PathVariable int  rotid){
        return roundTypeService.getRoundType(rotid);
    }
}
