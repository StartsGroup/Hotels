package com.hotel.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
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
    private RoomType roomType;

}
