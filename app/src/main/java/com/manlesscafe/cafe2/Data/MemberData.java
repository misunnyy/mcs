package com.manlesscafe.cafe2.Data;

import java.io.Serializable;

public class MemberData implements Serializable {

    String id;
    String name;
    String username;
    String password;
    String email;
    String gender;
    String age;
    SeatData seat;
    String qr;
    String time;
    String check_in;

    // PM
    // 1. 서버 -> 어디로 호출 / 무슨 결과를 주는지
    // 2. 포스트맨 확인
    // 3. 확인 결과로 Data 클래스 생성
    // 4. 로그인 / 마이데이터



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public SeatData getSeat() {
        return seat;
    }

    public void setSeat(SeatData seat) {
        this.seat = seat;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }
}
