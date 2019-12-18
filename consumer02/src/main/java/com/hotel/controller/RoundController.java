package com.hotel.controller;

import com.hotel.pojo.Rounds;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/round")
public class RoundController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/allRounds")
    public List<Rounds> getAllRound(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.getForObject(url+"/allRounds",List.class);
    }

    @GetMapping("/getRound/{roid}")
    public Rounds getById(@PathVariable int  roid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.getForObject(url+"/getRound/"+roid,Rounds.class);
    }

    @PostMapping("/save")
    public String saveRounds(@RequestBody Rounds rounds){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.postForObject(url+"/saveRounds",rounds,String.class);
    }


    @GetMapping("/delete/{roid}")
    public String deleteRounds(@PathVariable int roid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return  restTemplate.getForObject(url+"/deleteRounds/"+roid,String.class);
    }


    @PostMapping("/update")
    public String updateRound(@RequestBody Rounds rounds){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return restTemplate.postForObject(url+"/updateRounds",rounds,String.class);
    }

}
