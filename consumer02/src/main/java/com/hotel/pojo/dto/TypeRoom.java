package com.hotel.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hotel.pojo.Room;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class TypeRoom {
    private int rtid;
    private int rid;
    private String rtname;
    private double price;
    private double cash;
    private int longs;
    private int firsttime;
    private double firstprice;
    private String remark;
    private String status;
    private int reid;
    private int uid;
    private String rtimes;
    private String atatus;
    private double deposit;
    private List<Room> roomList;
}
