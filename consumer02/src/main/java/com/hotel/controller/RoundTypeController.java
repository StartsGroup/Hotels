package com.hotel.controller;


import com.hotel.pojo.RoundType;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/roundType")
public class RoundTypeController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/allType")
    public List<RoundType> getAllRodetail(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.getForObject(url+"/allType",List.class);
    }

    @GetMapping("/getType/{rotid}")
    public RoundType getByRotid(@PathVariable int  rotid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.getForObject(url+"/getType/"+rotid,RoundType.class);
    }

    @PostMapping("/save")
    public String saveRodetails(@RequestBody RoundType rounds){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.postForObject(url+"/saveType",rounds,String.class);
    }
    @GetMapping("/deleteType/{rotid}")
    public String deleteRodetails(@PathVariable int rotid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return  restTemplate.getForObject(url+"/deleteType/"+rotid,String.class);
    }

    @PostMapping("/update")
    public String updateRodetail(@RequestBody RoundType rounds){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.postForObject(url+"/updateType",rounds,String.class);
    }
}
