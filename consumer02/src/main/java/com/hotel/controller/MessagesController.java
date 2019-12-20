package com.hotel.controller;

import com.hotel.pojo.Messages;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private RestTemplate template;

    @Resource
    private EurekaClient eurekaClient;

    //留言
    @PostMapping("/add")
    public String addMessages(@RequestBody Messages messages){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url = info.getHomePageUrl();
        return template.postForObject(url+"/messages/add",messages,String.class);
    }
    @GetMapping("/getMessage/{rtid}")
    public List<Messages> getMessage(@PathVariable int rtid){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url = info.getHomePageUrl();
        return template.getForObject(url+"/messages/getMessage/"+rtid,List.class);
    }
}
