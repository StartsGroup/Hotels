package com.hotel.pojo;

import lombok.Data;

@Data
public class Register {
    private int rgid;
    private int uid;
    private int rid;
    private String rgtimes;
    private String status;
    private  Users users;
    private  Room room;
}
