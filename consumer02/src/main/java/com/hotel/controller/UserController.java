package com.hotel.controller;

import com.hotel.pojo.Users;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private RestTemplate template;
    @Resource
    private EurekaClient eurekaClient;
    @PostMapping("/login")
    public Users login(@RequestBody Users u){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/users/login",u,Users.class);
    }
    @GetMapping("/all")
    public List<Users> getAllUsers(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/users/all",List.class);
    }
    @PostMapping("/save")
    public String saveUsers(@RequestBody Users u){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/users/save",u,String.class);
    }
    @GetMapping("/all/{uid}")
    public Users getUsersByUid(@PathVariable int uid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/users/all/"+uid,Users.class);
    }
    @GetMapping("/delete/{uid}")
    public String deleteUsersByUid(@PathVariable int uid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/users/delete/"+uid,String.class);
    }
}