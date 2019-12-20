package com.hotel.quartz;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.hotel.pojo.Finance;
import com.hotel.pojo.Users;
import com.hotel.service.IRoomTypeService;
import com.hotel.util.phoneUtil;
import com.hotel.util.phoneUtil1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Configuration
@RestController
public class Countdown {

    @Autowired
    private IRoomTypeService roomTypeService;

    /**
     * 倒计时
     *
     * @param min 倒计时间（分钟）
     */
    public void Test1(int min,int rid,String tel) {

        //开始时间
        long start = System.currentTimeMillis();
        //结束时间
        final long end = start + min * 60 * 1000;

        final Timer timer = new Timer();
        //延迟0毫秒（即立即执行）开始，每隔1000毫秒执行一次
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("提醒客户预定房间到期=============="+rid+"==========="+tel);
                Remind(rid,tel);
            }
        }, 172800000);
        //计时结束时候，停止全部timer计时计划任务
        timer.schedule(new TimerTask() {
            public void run() {
                timer.cancel();
            }

        }, new Date(end));

    }

    public void Test2(int min,int rid,String tel) {

        //开始时间
        long start = System.currentTimeMillis();
        //结束时间
        final long end = start + min * 60 * 1000;

        final Timer timer = new Timer();
        //延迟0毫秒（即立即执行）开始，每隔1000毫秒执行一次
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("自动退房提醒==============="+rid+"============="+tel);
                optRoom(rid);
                Remind1(rid,tel);
            }
        }, 259200000);
        //计时结束时候，停止全部timer计时计划任务
        timer.schedule(new TimerTask() {
            public void run() {
                timer.cancel();
            }

        }, new Date(end));
    }

    //预定房间入住短信提醒
    public String Remind(int rid, String tel){

        phoneUtil.setNewcode(rid);

        String code= String.valueOf(phoneUtil.getNewcode());

        try {
            SendSmsResponse response=phoneUtil.sendSms(tel,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }

    //预定房间自动退订短信提醒
    public String Remind1(int rid, String tel){

        phoneUtil1.setNewcode(rid);

        String code= String.valueOf(phoneUtil1.getNewcode());

        try {
            SendSmsResponse response=phoneUtil1.sendSms(tel,code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }


    public String optRoom(int rid) {
        //预定表中修改房间状态
        boolean flag = roomTypeService.optRoomStates(rid);
        //更新房间状态为
        boolean flag2 = roomTypeService.optRoom(rid);
        System.out.println();

        //根据房间号查押金
        double fprice = roomTypeService.getFpr(rid);

        //添加财务表信息
        int uid = roomTypeService.getUserId(rid);
        Finance finance = new Finance();
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        finance.setUid(uid);
        finance.setRid(rid);
        finance.setFtimes(df.format(date));
        finance.setFprice(fprice);
        boolean flag3 = roomTypeService.setFinance(finance);

        System.out.println();

        //用户表插入消费金额
        double uprice = fprice;
        Users users = new Users();
        users.setUid(uid);
        users.setUprice(uprice);
        boolean flag4 = roomTypeService.setUserPrice(users);

        String result1 = (flag ? "success" : "fail");
        String result2 = (flag2 ? "success" : "fail");
        String result3 = (flag3 ? "success" : "fail");
        String result4 = (flag4 ? "success" : "fail");
        String result = "success";
        if (result1 == result2 && result2 == result3 && result3 == result4)
            return result;
        else
            return null;
    }

}