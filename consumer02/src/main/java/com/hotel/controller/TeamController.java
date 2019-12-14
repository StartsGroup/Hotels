package com.hotel.controller;

import com.hotel.pojo.Team;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Resource
    private RestTemplate template;
    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/all")
    public List<Team> getAllTeam(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/team/all",List.class);
    }
    @PostMapping("/login")
    public Team login(@RequestBody Team t){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/team/login",t,Team.class);
    }
    @PostMapping("/save")
    public boolean saveTeam(@RequestBody Team t){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/team/ve",t,boolean.class);
    }
    @GetMapping("/all/{tid}")
    public Team getTeamByTid(@PathVariable int tid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/team/all/"+tid,Team.class);
    }
    @GetMapping("/delete/{tid}")
    public String deleteTeamByTid(@PathVariable int tid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/team/delete/"+tid,String.class);
    }
}
