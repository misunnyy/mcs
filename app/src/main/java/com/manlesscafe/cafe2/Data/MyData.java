package com.manlesscafe.cafe2.Data;

import java.io.Serializable;

public class MyData implements Serializable {

    MemberData member;
    String time;


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


}
