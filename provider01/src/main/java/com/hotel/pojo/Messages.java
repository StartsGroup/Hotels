package com.hotel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messages {
    private int mid;
    private int uid;
    private int rtid;
    private String content;
    private String mtimes;

    @Override
    public String toString() {
        return "Messages{" +
                "mid=" + mid +
                ", uid=" + uid +
                ", rtid=" + rtid +
                ", content='" + content + '\'' +
                ", mtimes='" + mtimes + '\'' +
                '}';
    }
}
