package com.hotel.controller;

import com.hotel.pojo.Consume;
import com.hotel.pojo.Finance;
import com.hotel.pojo.Register;
import com.hotel.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/fianace")
public class FinanceCotroller {
    @Resource
    private IFinaneService iFinaneService;
    @Resource
    private IRegisterService iRegisterService;
    @Resource
    private IRoomService roomService;
    @Resource
    private ConsumeService consumeService;
    @Resource
    private IRoomTypeService iRoomTypeService;
    @PostMapping("/save")
    public boolean saveFinance(@RequestBody Finance finance){
        System.out.println(finance);
        Register register=new Register();
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String td=format.format(date);
        int year2= dealyear(td);
        int  month2= dealMonth(td);
        int day2=dealDay(td);
        System.out.println("****************"+year2);
        //房间的入住日期
       register.setRid(finance.getRid());
       register.setUid(finance.getUid());
        String date1 = iRegisterService.getDate(register);
        System.out.println(date1);
        int day1 = dealDay(date1);
        int month1=dealMonth(date1);
        int year1 = dealyear(date1);
        double price =roomService.getRoomPrice(finance.getRid());
        System.out.println("得到日\t"+day1+"得到月\t"+month1);
        //获取消费总价
        double customPrice = getCustomPrice(finance.getRid());
        System.out.println("消费 "+customPrice);
        //获取押金
        double deposit = getDeposit(finance.getRid());
        System.out.println("押金"+deposit);
        double price1 = getPrice(year1,month1,day1,year2,month2,day2,price)+customPrice-deposit;
        System.out.println("总价格"+price1);
        finance.setFtimes(td);
        finance.setFprice(price1);
        System.out.println("********************"+finance);
        return  iFinaneService.saveFinance(finance);
    }
    //对日的处理
    public int dealDay(String date){
        List<Integer> list=new ArrayList<>();
        StringTokenizer st = new StringTokenizer(date,"-");
        while(st.hasMoreTokens() ){
            int num=Integer.parseInt(st.nextToken());
           list.add(num);
        }
        return list.get(2);
    }
    //对月的处理
    public int dealMonth(String date){
        List<Integer> list=new ArrayList<>();
        StringTokenizer st = new StringTokenizer(date,"-");
        while(st.hasMoreTokens() ){
            int num=Integer.parseInt(st.nextToken());
            list.add(num);
        }
        return list.get(1);
    }
    //对年的处理
    public int dealyear(String date){
        List<Integer> list=new ArrayList<>();
        StringTokenizer st = new StringTokenizer(date,"-");
        while(st.hasMoreTokens() ){
            int num=Integer.parseInt(st.nextToken());
            list.add(num);
        }
        return list.get(0);
    }
    //计算价格
    /****
     * byear 入住年
     * bmonth 入住月
     * ayear 退房年
     * amonth 退房月
     * price房子的价格
     * *****/
    public double getPrice(int byear,int bmonth,int bday,int ayear,int amonth,int aday,double price){
    /*    System.out.println("byear "+byear+"bmonth "+bmonth+"bday "+bday);
        System.out.println("ayear "+ayear+"aday "+aday+"amonth "+amonth);*/
        if(byear!=ayear){
            System.out.println("年不相等");
           return  (amonth * 30 + aday + 360 - 30 * bmonth  - bday)*price;
        }else if(bmonth!=amonth){
            System.out.println("月不相等");
           return  (31-bday+(amonth-bmonth-1)*30+aday)*price;
        }else {
            System.out.println("年月都不相等");
            return (aday-bday+1)*price;
        }
    }
    //获取消费金额
    public double getCustomPrice(int rid){
        List<Consume> consume = consumeService.getAllConsumeByRid(rid);
        double consumePrice=0;
        for (Consume c: consume){
            consumePrice+=c.getAdds();
        }
        return consumePrice;
    }
    //获取押金
    public double getDeposit(int rid){
        return iRoomTypeService.getFpr(rid);
    }
    @GetMapping("/delete/{fid}")
    public boolean deleteFinance(@PathVariable int fid){
        return iFinaneService.deleteFinance(fid);
    }
}
