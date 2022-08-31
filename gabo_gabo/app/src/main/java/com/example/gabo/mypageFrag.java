package com.example.gabo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class mypageFrag extends Fragment {

    LinearLayout test_findbb ;
    LinearLayout myfind_bignum;

    LinearLayout myhide_open;
    LinearLayout myhide_bignum;

    LinearLayout mycomment_open;


//    BottomSheetDialogFrag bottomDialog;
    MyFindTreasureFrag myFindTreasureFrag; //내가 찾은 보물 바텀시트 프래그먼트
    MyHideTreasureFrag myHideTreasureFrag; //내가 숨긴 보물 바텀시트 프래그먼트
    FragmentManager fmm ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mypage_lyt,container,false);

        fmm=getActivity().getSupportFragmentManager();
//        bottomDialog = new BottomSheetDialogFrag();


        /*---------내가찾은보물 열기-----------*/
        myFindTreasureFrag = new MyFindTreasureFrag();
        test_findbb = view.findViewById(R.id.test_findbb);
        test_findbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                bottomDialog.show(fmm,"test");
                myFindTreasureFrag.show(fmm,"showmyfind");
            }
        });
        myfind_bignum = view.findViewById(R.id.myfind_bignum);
        myfind_bignum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFindTreasureFrag.show(fmm,"showmyfind");
            }
        });

        /*---------내가 숨긴 보물 열기-----------*/
        myHideTreasureFrag = new MyHideTreasureFrag();
        myhide_open = view.findViewById(R.id.myhide_open);
        myhide_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myHideTreasureFrag.show(fmm,"showmyhide");
            }
        });
        myhide_bignum = view.findViewById(R.id.myhide_bignum);
        myhide_bignum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myHideTreasureFrag.show(fmm,"showmyhide");
            }
        });

        return view;


    }
}
