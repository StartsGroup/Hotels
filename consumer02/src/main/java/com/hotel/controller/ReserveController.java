package com.hotel.controller;

import com.hotel.pojo.Reserve;
import com.hotel.pojo.RoomType;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/roomtype")
public class ReserveController {

    @Resource
    private RestTemplate template;
    @Resource
    private EurekaClient eurekaClient;

    //查询所有房间类别
    @GetMapping("/all")
    public List<RoomType> getAllRoomType(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/roomtype/all",List.class);
    }

    //通过id查询空闲房间
    @GetMapping("/all/{rtid}")
    public List<RoomType> getAllRoomById(@PathVariable int rtid){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url = info.getHomePageUrl();
        return template.getForObject(url+"/roomtype/all/"+rtid,List.class);
    }

    //通过id查询要预定房间的详细信息
    @GetMapping("/details/{rid}")
    public List<RoomType> getRoomDeteils(@PathVariable int rid){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("EUREKA-SERVER01", false);
        String url = info.getHomePageUrl();
        return template.getForObject(url+"/roomtype/details/"+rid,List.class);
    }

    //预定房间
    @PostMapping("/reserve")
    public String reserveRoom(@RequestBody Reserve reserve){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("EUREKA-SERVER01", false);
        String url = info.getHomePageUrl();
        return template.postForObject(url+"/roomtype/reserve",reserve,String.class);
    }

    //退预定房间
    @GetMapping("/opt/{rid}")
    public String optRoom(@PathVariable int rid){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url = info.getHomePageUrl();
        return template.getForObject(url+"/roomtype/opt/"+rid,String.class);

    }
    //查询用户预订信息
    @GetMapping("/get/{uid}")
    public Reserve selectresByUid(@PathVariable int uid){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url = info.getHomePageUrl();
        return template.getForObject(url+"/roomtype/get/"+uid,Reserve.class);
    }


}