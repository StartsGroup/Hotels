package com.hotel.controller;

import com.hotel.pojo.Products;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pro")
public class ProductsController {
    @Resource
    private RestTemplate template;
    @Resource
    private EurekaClient eurekaClient;

    @GetMapping("/all")
    public List<Products> getAllProducts(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/pro/all",List.class);
    }
    @GetMapping("/all2")
    public List<Products> getAll2Products(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/pro/all2",List.class);
    }
    @GetMapping("/all/{ptid}")
    public List<Products> getProductsByPtid(@PathVariable int ptid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/pro/all/"+ptid,List.class);
    }
    @GetMapping("/all2/{pid}")
    public Products getProductsByPid(@PathVariable int pid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/pro/all2/"+pid,Products.class);
    }
    @PostMapping("/save")
    public String saveProducts(@RequestBody Products pro){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/pro/save",pro,String.class);
    }
    @PostMapping("/update")
    public String updateProducts(@RequestBody Products pro){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/pro/update",pro,String.class);
    }
    @GetMapping("/delete/{pid}")
    public String deleteProductsByPid(@PathVariable int pid){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/pro/delete/"+pid,String.class);
    }
    @GetMapping("/alltypes")
    public List<Products> getAllTypes(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/pro/alltypes",List.class);
    }
    @GetMapping("/all3")
    public List<Products> getAll3Products(){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.getForObject(url+"/pro/all3",List.class);
    }
    @PostMapping("/updatenum")
    public String updateNum(@RequestBody Products pro){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/pro/updatenum",pro,String.class);
    }
    @PostMapping("/savetype")
    public String saveProductsType(@RequestBody Products pro){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/pro/savetype",pro,String.class);
    }

    @PostMapping("/updateProType")
    public boolean updateProType(@RequestBody Products pro){
        InstanceInfo info=eurekaClient.getNextServerFromEureka("EUREKA-SERVER01",false);
        String url=info.getHomePageUrl();
        return template.postForObject(url+"/pro/updateProType",pro,boolean.class);
    }
}
