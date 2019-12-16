package com.hotel.pojo;

import lombok.Data;

@Data
public class Room {
    private int rid;
    private int rtid;
    private String rtname;
    private double price;
    private double cash;
    private int longs;
    private int firsttime;
    private double firstprice;
    private String remark;
    private double deposit;
    private String status;

}
