package com.hotel.controller;

import com.hotel.pojo.Consume;
import com.hotel.pojo.Finance;
import com.hotel.pojo.Register;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@RestController
@RequestMapping("/customerfianace")
public class FinanceCotroller {
    @Resource
    private RestTemplate template;
    @Resource
    private EurekaClient eurekaClient;

    @PostMapping("/save")
    public boolean saveFinance(@RequestBody Finance finance){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/fianace/save",finance,boolean.class);
    }
    @GetMapping("/delete/{fid}")
    public boolean deleteFinance(@PathVariable int fid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/fianace/delete"+fid,boolean.class);
    }
}
