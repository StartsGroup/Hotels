package com.hotel.controller;

import com.hotel.pojo.Finance;
import com.hotel.pojo.Reserve;
import com.hotel.pojo.RoomType;
import com.hotel.pojo.Users;
import com.hotel.service.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/roomtype")
public class ReserveController {

    @Resource
    private IRoomTypeService roomTypeService;

    //查询所有房间类别
    @GetMapping("/all")
    public List<RoomType> getAllRoomType(){
        return roomTypeService.getAllRoomType();
    }

    //添加房间类型
    @PostMapping("/save")
    public String saveRoomType(@RequestBody RoomType rt){
        boolean flag=roomTypeService.saveRoomType(rt);
        String result=(flag ? "success":"fail");
        return result;
    }

    //通过id查询空闲房间
    @GetMapping("/all/{rtid}")
    public List<RoomType> getAllRoomById(@PathVariable int rtid){
        return roomTypeService.getAllRoomById(rtid);
    }

    //通过id查询要预定房间的详细信息
    @GetMapping("/details/{rid}")
    public List<RoomType> getRoomDeteils(@PathVariable int rid){
        return roomTypeService.getRoomDeteils(rid);
    }

    //预定房间
    @PostMapping("/reserve")
    public String reserveRoom(@RequestBody Reserve reserve){
        int rid = reserve.getRid();
        //预定表中插入数据
        boolean flag=roomTypeService.reserveroom(reserve);
        //更新房间状态
        boolean flag2=roomTypeService.updateRoomStates(rid);
        String result1=(flag ? "success":"fail");
        String result2=(flag2 ? "success":"fail");
        String result = "success";
        if (result1 == result2  )
        return result;
        else
            return null;
    }

    //退预定房间
    @GetMapping("/opt/{rid}")
    public String optRoom(@PathVariable int rid){
        //预定表中修改房间状态
        boolean flag=roomTypeService.optRoomStates(rid);
        //更新房间状态为
        boolean flag2=roomTypeService.optRoom(rid);

        //根据房间号查押金
        double fprice = roomTypeService.getFpr(rid);

        //添加财务表信息
        int uid = roomTypeService.getUserId(rid);
        Finance finance = new Finance();
        Date date = new Date();
        SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        finance.setUid(uid);
        finance.setRid(rid);
        finance.setFtimes(df.format(date));
        finance.setFprice(fprice);
        boolean flag3 = roomTypeService.setFinance(finance);

        //用户表插入消费金额
        double uprice = fprice;
        Users users = new Users();
        users.setUid(uid);
        users.setUprice(uprice);
        boolean flag4 = roomTypeService.setUserPrice(users);

        String result1=(flag ? "success":"fail");
        String result2=(flag2 ? "success":"fail");
        String result3=(flag3 ? "success":"fail");
        String result4=(flag4 ? "success":"fail");
        String result = "success";
        if (result1 == result2 && result2 == result3 && result3 == result4)
            return result;
        else
            return null;
    }


}