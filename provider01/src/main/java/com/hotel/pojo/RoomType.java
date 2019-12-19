package com.hotel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomType {
    private int rtid;
    private int rid;
    private String rtname;
    private double price;
    private double cash;
    private int longs;
    private int firsttime;
    private double firstprice;
    private String remark;
    private double deposit;
    private String status;
    private int reid;
    private int uid;
    private String rtimes;
    private String atatus;

}
