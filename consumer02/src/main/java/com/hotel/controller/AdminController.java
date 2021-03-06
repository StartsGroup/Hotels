package com.hotel.controller;

import com.hotel.pojo.Admin;
import com.hotel.pojo.Adtype;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private RestTemplate template;
    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/all")
    public List<Admin> getAllAdmin(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/admin/all",List.class);
    }
    @GetMapping("/all/{aid}")
    public Admin getAdminByAid(@PathVariable int aid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/admin/all/"+aid,Admin.class);
    }
    @PostMapping("/login")
    public Admin login(@RequestBody Admin a){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/admin/login",a,Admin.class);
    }
    @PostMapping("/save")
    public String saveAdmin(@RequestBody Admin a){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/admin/save",a,String.class);
    }
    @GetMapping("/delete")
    public String deleteAdminByAid(@PathVariable int aid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/admin/delete/"+aid,String.class);
    }

    //修改用户信息
    @PostMapping("/update")
    public String updateAdminByAid(@RequestBody Admin a){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/admin/update",a,String.class);
    }

    //根据id修改用户信息
    @PostMapping("/updatepass")
    public String updateAdminPassByAid(@RequestBody Admin a){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/admin/updatepass",a,String.class);
    }

    ////查询所有角色
    @GetMapping("/getalladtype")
    public List<Adtype> getAllAdtype(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/admin/getalladtype/",List.class);
    }
}
