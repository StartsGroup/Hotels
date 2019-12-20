package com.hotel.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.hotel.pojo.Users;
import com.hotel.util.phoneUtil;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
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
    public boolean saveUsers(@RequestBody Users u){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/users/ve",u,boolean.class);
    }
    @GetMapping("/get/{uname}")
    public Users getUsersByUname(@PathVariable String uname){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/users/get/"+uname,Users.class);
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
    @PostMapping("/update")
    public String updateUsersByUid(@RequestBody Users u){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/users/update",u,String.class);
    }

    //根据id修改用户信息
    @PostMapping("/updateuserpass")
    public String updateAdminPassByAid(@RequestBody Users u){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/users/updateuserpass",u,String.class);
    }

    @GetMapping("/yanZ/{tel}")
    @ResponseBody
    public String yanZheng(@PathVariable String tel){

        phoneUtil.setNewcode();

        String code=Integer.toString(phoneUtil.getNewcode());

        try {
            SendSmsResponse response=phoneUtil.sendSms(tel,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }

}
