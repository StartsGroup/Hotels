package com.hotel.controller;


import com.hotel.pojo.Rodetail;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rodetail")
public class RodetailController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/allRodetails")
    public List<Rodetail> getAllRodetail(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.getForObject(url+"/allDetail",List.class);
    }

    @GetMapping("/getRodetail/{rtid}")
    public Rodetail getByRoid(@PathVariable int  rtid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.getForObject(url+"/getDetail/"+rtid,Rodetail.class);
    }

    @PostMapping("/save")
    public boolean saveRodetails(@RequestBody Rodetail rounds){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.postForObject(url+"/saveDetail",rounds,boolean.class);
    }
    @GetMapping("/delete/{rtid}")
    public boolean deleteRodetails(@PathVariable int rtid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return  restTemplate.getForObject(url+"/deleteDetail/"+rtid,boolean.class);
    }

    @PostMapping("/update")
    public boolean updateRodetail(@RequestBody Rodetail rounds){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.postForObject(url+"/updateDetail",rounds,boolean.class);
    }
}
