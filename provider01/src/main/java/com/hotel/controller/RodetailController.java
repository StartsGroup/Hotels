package com.hotel.controller;

import com.hotel.pojo.Rodetail;
import com.hotel.service.IRodetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
