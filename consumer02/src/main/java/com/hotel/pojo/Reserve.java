package com.hotel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserve {
    private int reid;
    private int rid;
    private int uid;
    private String rtimes;
    private String status;
}
