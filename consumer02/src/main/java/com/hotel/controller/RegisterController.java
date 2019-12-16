package com.hotel.controller;

import com.hotel.pojo.Register;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customerregister")
public class RegisterController {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private EurekaClient eurekaClient;
    //用户信息的登记
    @PostMapping("/save")
    boolean saveRegister(@RequestBody Register register){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.postForObject(url+"/register/save",register,boolean.class);
    }
    //用户登记信息的查看
    @GetMapping("/all")
    List<Register> getAllRegister(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
         return restTemplate.getForObject(url+"/register/all",List.class);
    }
    //用户登记信息的删除
    @GetMapping("/delete/{rgid}")
    boolean deleteRegister(@PathVariable int rgid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.getForObject(url+"/register/delete/"+rgid,boolean.class);
    }
    //根据用户名修改用户的状态（该用户预定的状态改为该用户已入住）
    @PostMapping("/update")
    boolean updateRegister(@RequestBody Register register){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.postForObject(url+"/register/update",register,boolean.class);
    }
    //查询某个人的入住信息
    @GetMapping("/ById/{uid}")
    Register getRegisterById(@PathVariable int uid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.getForObject(url+"/register/ById/"+uid,Register.class);
    }
}
