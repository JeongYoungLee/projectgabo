package com.example.gabo.VO;

import java.io.Serializable;
import java.util.Date;

public class UsersVO implements Serializable {
    private String users_id;
    private String users_pw;
    private String users_name;
    private String users_phone;
    private String users_birth;
    private String users_email;
    private String users_nick;
    private String users_gender;
    //private int users_level;
    //private Date users_startdate;
    //private Date users_enddate;
    //private Date users_offdate;

    public UsersVO(String users_id, String users_pw, String users_name, String users_phone, String users_birth, String users_email, String users_nick, String users_gender) {
        this.users_id = users_id;
        this.users_pw = users_pw;
        this.users_name = users_name;
        this.users_phone = users_phone;
        this.users_birth = users_birth;
        this.users_email = users_email;
        this.users_nick = users_nick;
        this.users_gender = users_gender;
    }

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public String getUsers_pw() {
        return users_pw;
    }

    public void setUsers_pw(String users_pw) {
        this.users_pw = users_pw;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getUsers_phone() {
        return users_phone;
    }

    public void setUsers_phone(String users_phone) {
        this.users_phone = users_phone;
    }

    public String getUsers_birth() {
        return users_birth;
    }

    public void setUsers_birth(String users_birth) {
        this.users_birth = users_birth;
    }

    public String getUsers_email() {
        return users_email;
    }

    public void setUsers_email(String users_email) {
        this.users_email = users_email;
    }

    public String getUsers_nick() {
        return users_nick;
    }

    public void setUsers_nick(String users_nick) {
        this.users_nick = users_nick;
    }

    public String getUsers_gender() {
        return users_gender;
    }

    public void setUsers_gender(String users_gender) {
        this.users_gender = users_gender;
    }

    @Override
    public String toString() {
        return "UsersVO{" +
                "users_id='" + users_id + '\'' +
                ", users_pw='" + users_pw + '\'' +
                ", users_name='" + users_name + '\'' +
                ", users_birth=" + users_birth +
                ", users_phone='" + users_phone + '\'' +
                ", users_email='" + users_email + '\'' +
                ", users_gender='" + users_gender + '\'' +
                ", users_nick='" + users_nick + '\'' +
                '}';
    }
}
