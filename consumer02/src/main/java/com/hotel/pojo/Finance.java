package com.hotel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Finance {
    private int fid;
    private int uid;
    private int rid;
    private String ftimes;
    private double fprice;

}
