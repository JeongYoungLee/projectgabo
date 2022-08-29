package com.example.gabo.VO;

import android.graphics.drawable.Drawable;


/*----------------------------유저댓글 VO--------------------------------------*/
public class trsCommentVO {
    private Drawable tc_img_profile;
    private Drawable tc_img_like;
    private String tc_tv_userid;
    private String tc_tv_tag1;
    private String tc_tv_tag2;
    private String tc_tv_tag3;
    private String tc_tv_when;
    private String tc_tv_like;
    private String tc_tv_comment;



    public trsCommentVO(Drawable tc_img_profile, Drawable tc_img_like, String tc_tv_userid, String tc_tv_tag1, String tc_tv_tag2, String tc_tv_tag3, String tc_tv_when, String tc_tv_like, String tc_tv_comment) {
        this.tc_img_profile = tc_img_profile;
        this.tc_img_like = tc_img_like;
        this.tc_tv_userid = tc_tv_userid;
        this.tc_tv_tag1 = tc_tv_tag1;
        this.tc_tv_tag2 = tc_tv_tag2;
        this.tc_tv_tag3 = tc_tv_tag3;
        this.tc_tv_when = tc_tv_when;
        this.tc_tv_like = tc_tv_like;
        this.tc_tv_comment = tc_tv_comment;
    }

    public Drawable getTc_img_profile() { return tc_img_profile;}
    public void setTc_img_profile(Drawable tc_img_profile) {this.tc_img_profile = tc_img_profile;}

    public Drawable getTc_img_like() { return tc_img_like; }
    public void setTc_img_like(Drawable tc_img_like) { this.tc_img_like = tc_img_like; }

    public String getTc_tv_userid() {return tc_tv_userid;}

    public void setTc_tv_userid(String tc_tv_userid) {this.tc_tv_userid = tc_tv_userid; }

    public String getTc_tv_tag1() { return tc_tv_tag1; }
    public void setTc_tv_tag1(String tc_tv_tag1) { this.tc_tv_tag1 = tc_tv_tag1;}

    public String getTc_tv_tag2() { return tc_tv_tag2; }
    public void setTc_tv_tag2(String tc_tv_tag2) { this.tc_tv_tag2 = tc_tv_tag2;  }

    public String getTc_tv_tag3() { return tc_tv_tag3; }
    public void setTc_tv_tag3(String tc_tv_tag3) { this.tc_tv_tag3 = tc_tv_tag3;  }

    public String getTc_tv_when() { return tc_tv_when; }
    public void setTc_tv_when(String tc_tv_when) { this.tc_tv_when = tc_tv_when;  }

    public String getTc_tv_like() { return tc_tv_like; }
    public void setTc_tv_like(String tc_tv_like) {this.tc_tv_like = tc_tv_like; }

    public String getTc_tv_comment() { return tc_tv_comment; }
    public void setTc_tv_comment(String tc_tv_comment) {this.tc_tv_comment = tc_tv_comment;  }

}

