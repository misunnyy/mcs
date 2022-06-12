package com.manlesscafe.cafe2.Data;

import java.io.Serializable;

public class MyPageData implements Serializable {
    // 어떤 형태의 데이터
    //id , time,
    String id;
    String seat;
    String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
