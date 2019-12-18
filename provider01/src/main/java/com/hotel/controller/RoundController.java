package com.hotel.controller;


import com.hotel.pojo.Rounds;
import com.hotel.service.IRoundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/deleteRounds/{roid}")
    public String deleteById(@PathVariable int  roid){
        boolean flag= roundsService.deleteRounds(roid);
        String result=flag ==true ? "success":"fail";
        return  result;
    }


    @PostMapping("/saveRounds")
    public String saveRoundType(@RequestBody Rounds rounds){
        boolean flag= roundsService.saveRounds(rounds);
        String result=flag ==true ? "success":"fail";
        return  result;
    }



    @PostMapping("/updateRounds")
    public String updateRoundType(@RequestBody Rounds rounds){
        boolean flag= roundsService.updateRounds(rounds);
        String result=flag ==true ? "success":"fail";
        return  result;
    }
}
