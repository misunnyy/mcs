package com.manlesscafe.cafe2.Data;

import java.io.Serializable;

public class MyPageData implements Serializable {
    // 어떤 형태의 데이터
    MemberData member;
    String time;
    String seat_num;

    public MemberData getMember() {
        return member;
    }

    public void setMember(MemberData member) {
        this.member = member;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(String seat_num) {
        this.seat_num = seat_num;
    }
}
