package com.manlesscafe.cafe2.Data;

import java.io.Serializable;

public class SeatData implements Serializable {
    String id;
    String seat_num;
    String member;
    String present_use;
    String check_in;
    String check_out;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(String seat_num) {
        this.seat_num = seat_num;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getPresent_use() {
        return present_use;
    }

    public void setPresent_use(String present_use) {
        this.present_use = present_use;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

}
