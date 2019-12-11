package com.hotel.controller;

import com.hotel.pojo.RoundType;
import com.hotel.service.IRoundTypeService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/deleteType/{rotid}")
    public String deleteById(@PathVariable int  rotid){
        boolean flag= roundTypeService.deleteRoundType(rotid);
        String result=flag ==true ? "success":"fail";
        return  result;
    }

    @PostMapping("/saveType")
    public String saveRoundType(@RequestBody RoundType roundType){
       boolean flag= roundTypeService.saveRoundType(roundType);
        String result=flag ==true ? "success":"fail";
        return  result;
    }


    @PostMapping("/updateType")
    public String updateRoundType(@RequestBody RoundType roundType){
        boolean flag= roundTypeService.updateRoundType(roundType);
        String result=flag ==true ? "success":"fail";
        return  result;
    }

}
