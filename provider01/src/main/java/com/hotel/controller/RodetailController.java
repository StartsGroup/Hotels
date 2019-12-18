package com.hotel.controller;

import com.hotel.pojo.Rodetail;
import com.hotel.service.IRodetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RodetailController {

    @Autowired
    private IRodetailService rodetailService;


    @GetMapping("/allDetail")
    public List<Rodetail> getAllRodetail(){

        return rodetailService.getAllDetails();
    }

    @GetMapping("/getDetail/{rtid}")
    public Rodetail getById(@PathVariable int rtid){

        return rodetailService.getByRtids(rtid);
    }

    @GetMapping("/deleteDetail/{rtid}")
    public String deleteById(@PathVariable int  rtid){
        boolean flag= rodetailService.deleteRodetails(rtid);
        String result=flag ==true ? "success":"fail";
        return  result;
    }


    @PostMapping("/saveDetail")
    public String saveRoundType(@RequestBody Rodetail rodetail){
        boolean flag=rodetailService.saveRodetail(rodetail);
        String result=flag ==true ? "success":"fail";
        return  result;
    }


    @PostMapping("/updateDetail")
    public String updateRoundType(@RequestBody Rodetail rodetail){
        boolean flag= rodetailService.updateRodetail(rodetail);
        String result=flag ==true ? "success":"fail";
        return  result;
    }
}
