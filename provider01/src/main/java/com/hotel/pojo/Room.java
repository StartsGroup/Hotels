package com.hotel.pojo;

import lombok.Data;

@Data
public class Room {
    private int rid;

    private  String status;

    private  int rtid;

    private  Rodetail rodetail;
}
