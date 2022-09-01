package com.example.gabo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


/*---------------------------마이페이지 > 내가 숨긴 보물 리스트 프래그먼트-------------------------------------*/
public class MyHideTreasureFrag extends BottomSheetDialogFragment {

    BottomSheetBehavior behavior;
    private myHideAdapter myHideAdapter = new myHideAdapter();
    private ListView myhide_list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*바텀시트 라운드 투명배경을 위한 스타일 설정*/
        setStyle(
                STYLE_NORMAL,R.style.TransparentBottomSheetDialogFragment
        );
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(),R.layout.myhidetreasure,null);

        dialog.setContentView(view);
        behavior = BottomSheetBehavior.from((View) view.getParent());

        /*----내가 숨긴 보물 리스트 뷰---*/
        myhide_list = view.findViewById(R.id.myhide_list);
        myHideAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e3),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_blank),
                "2km","#전봇대","#물병","하얀색","08/11/22 10:00AM에 숨김","12"
        );
        myHideAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e3),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_blank),
                "2km","#전봇대","#물병","하얀색","08/11/22 10:00AM에 숨김","12"
        );
        myHideAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e3),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_blank),
                "2km","#전봇대","#물병","하얀색","08/11/22 10:00AM에 숨김","12"
        );
        myHideAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e3),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_blank),
                "2km","#전봇대","#물병","하얀색","08/11/22 10:00AM에 숨김","12"
        );
        myHideAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e3),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_blank),
                "2km","#전봇대","#물병","하얀색","08/11/22 10:00AM에 숨김","12"
        );
        myhide_list.setAdapter(myHideAdapter);
        ListView myhide_list = getActivity().findViewById(R.id.myhide_list);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
