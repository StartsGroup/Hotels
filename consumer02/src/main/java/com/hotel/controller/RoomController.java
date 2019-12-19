package com.hotel.controller;

import com.hotel.pojo.Finance;
import com.hotel.pojo.Room;
import com.hotel.pojo.dto.Details;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/customeroom")
public class RoomController {

    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private EurekaClient eurekaClient;
    @GetMapping("/allRoom")
    public List<Room> getAllRoom(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        System.out.println(url+"provideroom/allroom");
        return restTemplate.getForObject(url+"provideroom/allRoom",List.class) ;
    }

    @GetMapping("/getRoom/{rid}")
    public Details getById(@PathVariable int  rid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.getForObject(url+"/provideroom/getRoom/"+rid,Details.class);
    }
    //添加房间
    @PostMapping("/save")
    public boolean saveRoom(@RequestBody Room room){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.postForObject(url+"/provideroom/save",room,boolean.class);
    }
    @GetMapping("/delete/{rid}")
    public boolean deleteRoom(@PathVariable int rid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return  restTemplate.getForObject(url+"/provideroom/delete/"+rid,boolean.class);
    }
    @PostMapping("/updateStatus")
    @ResponseBody
    public boolean updateStatus(@RequestBody Finance finance){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return  restTemplate.postForObject(url+"/provideroom/updateStatus",finance,boolean.class);
    }
}
