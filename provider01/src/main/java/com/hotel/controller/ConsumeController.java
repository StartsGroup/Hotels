package com.hotel.controller;

import com.hotel.pojo.Consume;
import com.hotel.service.ConsumeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/consume")
@RestController
public class ConsumeController {
    @Resource
    private ConsumeService consumeService;

    @GetMapping("/all")
    public List<Consume> getAllConsume(){
        return consumeService.getAllConsume();
    }
    @GetMapping("/all/{rid}")
    public List<Consume> getAllConsumeByRid(@PathVariable int rid){
        return consumeService.getAllConsumeByRid(rid);
    }
    @PostMapping("/save")
    public String saveConsume(@RequestBody Consume c){
        boolean flag=consumeService.saveConsume(c);
        String result=(flag ? "success":"fail");
        return result;
    }
    @GetMapping("/all2/{uid}")
    public List<Consume> getAllConsumeByUid(@PathVariable int uid){
        return consumeService.getAllConsumeByUid(uid);
    }
    @GetMapping("/all2")
    public List<Consume> getAll2Consume(){
        return consumeService.getAll2Consume();
    }
    //退房功能的实现
    @GetMapping("/updateStatus")
    public boolean updateConsumerStatus(Consume consume){
        return consumeService.updateStatus(consume);

    }
}
