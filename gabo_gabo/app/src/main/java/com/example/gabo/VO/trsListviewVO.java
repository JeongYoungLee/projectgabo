package com.example.gabo.VO;

import android.graphics.drawable.Drawable;

public class trsListviewVO {
    private Drawable tl_img_profile;
    private Drawable tl_img_like;
    private String tl_tv_userid;
    private String tl_tv_km;
    private String tl_tv_tag1;
    private String tl_tv_tag2;
    private String tl_tv_tag3;
    private String tl_tv_when;
    private String tl_tv_like;

    public trsListviewVO(Drawable tl_img_profile, Drawable tl_img_like, String tl_tv_userid, String tl_tv_km, String tl_tv_tag1, String tl_tv_tag2, String tl_tv_tag3, String tl_tv_when, String tl_tv_like) {
        this.tl_img_profile = tl_img_profile;
        this.tl_img_like = tl_img_like;
        this.tl_tv_userid = tl_tv_userid;
        this.tl_tv_km = tl_tv_km;
        this.tl_tv_tag1 = tl_tv_tag1;
        this.tl_tv_tag2 = tl_tv_tag2;
        this.tl_tv_tag3 = tl_tv_tag3;
        this.tl_tv_when = tl_tv_when;
        this.tl_tv_like = tl_tv_like;
    }

    public Drawable getTl_img_profile() {
        return tl_img_profile;
    }

    public void setTl_img_profile(Drawable tl_img_profile) {
        this.tl_img_profile = tl_img_profile;
    }

    public Drawable getTl_img_like() {
        return tl_img_like;
    }

    public void setTl_img_like(Drawable tl_img_like) {
        this.tl_img_like = tl_img_like;
    }

    public String getTl_tv_userid() {
        return tl_tv_userid;
    }

    public void setTl_tv_userid(String tl_tv_userid) {
        this.tl_tv_userid = tl_tv_userid;
    }

    public String getTl_tv_km() {
        return tl_tv_km;
    }

    public void setTl_tv_km(String tl_tv_km) {
        this.tl_tv_km = tl_tv_km;
    }

    public String getTl_tv_tag1() {
        return tl_tv_tag1;
    }

    public void setTl_tv_tag1(String tl_tv_tag1) {
        this.tl_tv_tag1 = tl_tv_tag1;
    }

    public String getTl_tv_tag2() {
        return tl_tv_tag2;
    }

    public void setTl_tv_tag2(String tl_tv_tag2) {
        this.tl_tv_tag2 = tl_tv_tag2;
    }

    public String getTl_tv_tag3() {
        return tl_tv_tag3;
    }

    public void setTl_tv_tag3(String tl_tv_tag3) {
        this.tl_tv_tag3 = tl_tv_tag3;
    }

    public String getTl_tv_when() {
        return tl_tv_when;
    }

    public void setTl_tv_when(String tl_tv_when) {
        this.tl_tv_when = tl_tv_when;
    }

    public String getTl_tv_like() {
        return tl_tv_like;
    }

    public void setTl_tv_like(String tl_tv_like) {
        this.tl_tv_like = tl_tv_like;
    }
}

