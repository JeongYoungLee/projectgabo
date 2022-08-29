package com.example.gabo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabo.VO.trsListviewVO;

import java.util.ArrayList;

public class trsListviewAdapter extends BaseAdapter {

    private ArrayList<trsListviewVO> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.trs_listview_lyt, viewGroup, false);
        }

        trsListviewVO vo = items.get(i);
        ImageView tl_img_profile = view.findViewById(R.id.tl_img_profile);
        ImageView tl_img_like = view.findViewById(R.id.tl_img_like);
        TextView tl_tv_userid = view.findViewById(R.id.tl_tv_userid);
        TextView tl_tv_km = view.findViewById(R.id.tl_tv_km);
        TextView tl_tv_tag2 = view.findViewById(R.id.tl_tv_tag2);
        TextView tl_tv_tag3 = view.findViewById(R.id.tl_tv_tag3);
        TextView tl_tv_when = view.findViewById(R.id.tl_tv_when);
        TextView tl_tv_like = view.findViewById(R.id.tl_tv_like);
        TextView tl_tv_tag1 = view.findViewById(R.id.tl_tv_tag1);

        tl_img_profile.setImageDrawable(vo.getTl_img_profile());
        tl_img_like.setImageDrawable(vo.getTl_img_like());
        tl_tv_userid.setText(vo.getTl_tv_userid());
        tl_tv_km.setText(vo.getTl_tv_km());
        tl_tv_like.setText(vo.getTl_tv_like());
        tl_tv_tag1.setText(vo.getTl_tv_tag1());
        tl_tv_tag2.setText(vo.getTl_tv_tag2());
        tl_tv_tag3.setText(vo.getTl_tv_tag3());
        tl_tv_when.setText(vo.getTl_tv_when());

        return view;
    }

    public void listaddItems(Drawable tl_img_profile, Drawable tl_img_like, String tl_tv_userid, String tl_tv_km, String tl_tv_tag1, String tl_tv_tag2, String tl_tv_tag3, String tl_tv_when, String tl_tv_like) {
        trsListviewVO vo = new trsListviewVO(tl_img_profile,tl_img_like,tl_tv_userid,tl_tv_km,tl_tv_tag1,tl_tv_tag2,tl_tv_tag3,tl_tv_when,tl_tv_like);
        this.items.add(vo);
    }

}
