package com.example.gabo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabo.VO.myCommentsVO;

import java.util.ArrayList;

public class myCommentAdapter extends BaseAdapter {

    private ArrayList<myCommentsVO> items = new ArrayList<>();

    @Override
    public int getCount() { return items.size();}

    @Override
    public Object getItem(int i) {  return items.get(i);}

    @Override
    public long getItemId(int i) {  return i; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Context context = viewGroup.getContext();
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.mycomments_listview_lyt,viewGroup,false);
        }

        myCommentsVO vo = items.get(i);
        ImageView mycomment_img_profile = view.findViewById(R.id.mycomment_img_profile);
        ImageView mycomment_img_like = view.findViewById(R.id.mycomment_img_like);
        TextView mycomment_tv_userid = view.findViewById(R.id.mycomment_tv_userid);
        TextView mycomment_tv_tag1 = view.findViewById(R.id.mycomment_tv_tag1);
        TextView mycomment_tv_tag2 = view.findViewById(R.id.mycomment_tv_tag2);
        TextView mycomment_tv_tag3 = view.findViewById(R.id.mycomment_tv_tag3);
        TextView mycomment_tv_when = view.findViewById(R.id.mycomment_tv_when);
        TextView mycomment_tv_comment = view.findViewById(R.id.mycomment_tv_comment);
        TextView mycomment_tv_like = view.findViewById(R.id.mycomment_tv_like);


        mycomment_img_profile.setImageDrawable(vo.getMycomment_img_profile());
        mycomment_img_like.setImageDrawable(vo.getMycomment_img_like());
        mycomment_tv_userid.setText(vo.getMycomment_tv_userid());
        mycomment_tv_tag1.setText(vo.getMycomment_tv_tag1());
        mycomment_tv_tag2.setText(vo.getMycomment_tv_tag2());
        mycomment_tv_tag3.setText(vo.getMycomment_tv_tag3());
        mycomment_tv_when.setText(vo.getMycomment_tv_when());
        mycomment_tv_comment.setText(vo.getMycomment_tv_comment());
        mycomment_tv_like.setText(vo.getMycomment_tv_like());

        return view;
    }


    public void addItems(Drawable mycomment_img_profile, Drawable mycomment_img_like, String mycomment_tv_userid, String mycomment_tv_tag1, String mycomment_tv_tag2, String mycomment_tv_tag3, String mycomment_tv_when, String mycomment_tv_comment, String mycomment_tv_like ){
        myCommentsVO vo = new myCommentsVO(mycomment_img_profile, mycomment_img_like, mycomment_tv_userid, mycomment_tv_tag1, mycomment_tv_tag2, mycomment_tv_tag3, mycomment_tv_when, mycomment_tv_comment, mycomment_tv_like);
        this.items.add(vo);
    }
}
