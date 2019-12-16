package com.hotel.controller;

import com.hotel.pojo.Consume;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Priority;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consume")
public class ConsumeController {
    @Resource
    private RestTemplate template;
    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/all")
    public List<Consume> getAllConsume(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/consume/all",List.class);
    }
    @GetMapping("/all/{rid}")
    public List<Consume> getAllConsumeByRid(@PathVariable int rid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/consume/all/"+rid,List.class);
    }
    @PostMapping("/save")
    public String saveConsume(@RequestBody Consume c){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/consume/save",c,String.class);
    }
    @GetMapping("/all2")
    public List<Consume> getAll2Consume(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/consume/all2",List.class);
    }
    @GetMapping("/all2/{uid}")
    public List<Consume> getAllConsumeByUid(@PathVariable int uid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/consume/all2/"+uid,List.class);
    }

}
