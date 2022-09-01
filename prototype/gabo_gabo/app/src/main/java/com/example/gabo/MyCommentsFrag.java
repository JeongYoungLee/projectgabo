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

/*----------------------------------마이페이지 > 게시물 모아보기 리스트 프래그먼트---------------------------------------------*/
public class MyCommentsFrag extends BottomSheetDialogFragment {

    BottomSheetBehavior behavior;

    private ListView mycomments_list;
    private myCommentAdapter myCommentAdapter= new myCommentAdapter();

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
        View view = View.inflate(getContext(),R.layout.mycomments, null);
        dialog.setContentView(view);
        behavior = BottomSheetBehavior.from((View)view.getParent() );

        /*-------내 게시물 리스트 뷰------*/
        mycomments_list = view.findViewById(R.id.mycomments_list);
        myCommentAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e4),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "myname","#정류장","생필품","핑크색","09/01/22 09:00AM에 숨김","너무 재밌었어요! 또하고 싶음","200"
        );
        myCommentAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e4),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "myname","#정류장","생필품","핑크색","09/01/22 09:00AM에 숨김","너무 재밌었어요! 또하고 싶음","200"
        );
        myCommentAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e4),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "myname","#정류장","생필품","핑크색","09/01/22 09:00AM에 숨김","너무 재밌었어요! 또하고 싶음","200"
        );
        myCommentAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e4),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "myname","#정류장","생필품","핑크색","09/01/22 09:00AM에 숨김","너무 재밌었어요! 또하고 싶음","200"
        );
        myCommentAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e4),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "myname","#정류장","생필품","핑크색","09/01/22 09:00AM에 숨김","너무 재밌었어요! 또하고 싶음","200"
        );
        mycomments_list.setAdapter(myCommentAdapter);
        ListView mycomments_list = getActivity().findViewById(R.id.mycomments_list);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
