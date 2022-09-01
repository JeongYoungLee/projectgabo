package com.example.gabo.VO;


import android.graphics.drawable.Drawable;

/*---------마이페이지 > 게시물 모아보기 VO---------*/
public class myCommentsVO {

    private Drawable mycomment_img_profile;
    private Drawable mycomment_img_like;
    private String mycomment_tv_userid;
    private String mycomment_tv_tag1;
    private String mycomment_tv_tag2;
    private String mycomment_tv_tag3;
    private String mycomment_tv_when;
    private String mycomment_tv_comment;
    private String mycomment_tv_like;

    public myCommentsVO(Drawable mycomment_img_profile, Drawable mycomment_img_like, String mycomment_tv_userid, String mycomment_tv_tag1, String mycomment_tv_tag2, String mycomment_tv_tag3, String mycomment_tv_when, String mycomment_tv_comment, String mycomment_tv_like) {
        this.mycomment_img_profile = mycomment_img_profile;
        this.mycomment_img_like = mycomment_img_like;
        this.mycomment_tv_userid = mycomment_tv_userid;
        this.mycomment_tv_tag1 = mycomment_tv_tag1;
        this.mycomment_tv_tag2 = mycomment_tv_tag2;
        this.mycomment_tv_tag3 = mycomment_tv_tag3;
        this.mycomment_tv_when = mycomment_tv_when;
        this.mycomment_tv_comment = mycomment_tv_comment;
        this.mycomment_tv_like = mycomment_tv_like;
    }


    public Drawable getMycomment_img_profile() {
        return mycomment_img_profile;
    }

    public void setMycomment_img_profile(Drawable mycomment_img_profile) {
        this.mycomment_img_profile = mycomment_img_profile;
    }

    public Drawable getMycomment_img_like() {
        return mycomment_img_like;
    }

    public void setMycomment_img_like(Drawable mycomment_img_like) {
        this.mycomment_img_like = mycomment_img_like;
    }

    public String getMycomment_tv_userid() {
        return mycomment_tv_userid;
    }

    public void setMycomment_tv_userid(String mycomment_tv_userid) {
        this.mycomment_tv_userid = mycomment_tv_userid;
    }

    public String getMycomment_tv_tag1() {
        return mycomment_tv_tag1;
    }

    public void setMycomment_tv_tag1(String mycomment_tv_tag1) {
        this.mycomment_tv_tag1 = mycomment_tv_tag1;
    }

    public String getMycomment_tv_tag2() {
        return mycomment_tv_tag2;
    }

    public void setMycomment_tv_tag2(String mycomment_tv_tag2) {
        this.mycomment_tv_tag2 = mycomment_tv_tag2;
    }

    public String getMycomment_tv_tag3() {
        return mycomment_tv_tag3;
    }

    public void setMycomment_tv_tag3(String mycomment_tv_tag3) {
        this.mycomment_tv_tag3 = mycomment_tv_tag3;
    }

    public String getMycomment_tv_when() {
        return mycomment_tv_when;
    }

    public void setMycomment_tv_when(String mycomment_tv_when) {
        this.mycomment_tv_when = mycomment_tv_when;
    }

    public String getMycomment_tv_comment() {
        return mycomment_tv_comment;
    }

    public void setMycomment_tv_comment(String mycomment_tv_comment) {
        this.mycomment_tv_comment = mycomment_tv_comment;
    }

    public String getMycomment_tv_like() {
        return mycomment_tv_like;
    }

    public void setMycomment_tv_like(String mycomment_tv_like) {
        this.mycomment_tv_like = mycomment_tv_like;
    }
}
