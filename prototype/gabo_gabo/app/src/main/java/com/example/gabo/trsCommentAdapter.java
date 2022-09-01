package com.example.gabo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabo.VO.trsCommentVO;

import java.util.ArrayList;

/*--------------유저 댓글 리스트 어댑터-----------------*/
public class trsCommentAdapter extends BaseAdapter {

    private ArrayList<trsCommentVO> items = new ArrayList<>();


    @Override
    public int getCount() { return items.size();}

    @Override
    public Object getItem(int i) {return items.get(i);}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.trs_comment_layout,viewGroup,false);
        }

        trsCommentVO vo = items.get(i);
        ImageView tc_img_profile = view.findViewById(R.id.tc_img_profile);
        ImageView tc_img_like = view.findViewById(R.id.tc_img_like);
        TextView tc_tv_userid = view.findViewById(R.id.tc_tv_userid);
        TextView tc_tv_tag1 = view.findViewById(R.id.tc_tv_tag1);
        TextView tc_tv_tag2 = view.findViewById(R.id.tc_tv_tag2);
        TextView tc_tv_tag3 = view.findViewById(R.id.tc_tv_tag3);
        TextView tc_tv_when = view.findViewById(R.id.tc_tv_when);
        TextView tc_tv_like = view.findViewById(R.id.tc_tv_like);
        TextView tc_tv_comment = view.findViewById(R.id.tc_tv_comment);

        tc_img_profile.setImageDrawable(vo.getTc_img_profile());
        tc_img_like.setImageDrawable(vo.getTc_img_like());
        tc_tv_userid.setText(vo.getTc_tv_userid());
        tc_tv_tag1.setText(vo.getTc_tv_tag1());
        tc_tv_tag2.setText(vo.getTc_tv_tag2());
        tc_tv_tag3.setText(vo.getTc_tv_tag3());
        tc_tv_when.setText(vo.getTc_tv_when());
        tc_tv_like.setText(vo.getTc_tv_like());
        tc_tv_comment.setText(vo.getTc_tv_comment());


        return view;
    }

    public void addItems(Drawable tc_img_profile, Drawable tc_img_like, String tc_tv_userid, String tc_tv_tag1, String tc_tv_tag2, String tc_tv_tag3, String tc_tv_when, String tc_tv_like, String tc_tv_comment){
        trsCommentVO vo = new trsCommentVO(tc_img_profile, tc_img_like, tc_tv_userid, tc_tv_tag1, tc_tv_tag2, tc_tv_tag3, tc_tv_when, tc_tv_like, tc_tv_comment);
        this.items.add(vo);
    }
}
