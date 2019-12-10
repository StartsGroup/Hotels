package com.hotel.controller;

import com.hotel.pojo.Rounds;
import com.hotel.service.IRoundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RoundController {

    @Autowired
    private IRoundsService roundsService;

    @GetMapping("/allRounds")
    public List<Rounds> getAllRounds(){
        return roundsService.getAllRounds();
    }

    @GetMapping("/getRound/{roid}")
    public Rounds getById(@PathVariable int  roid){
        return roundsService.getByIds(roid);
    }
}
