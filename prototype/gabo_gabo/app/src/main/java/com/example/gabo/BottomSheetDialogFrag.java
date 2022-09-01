package com.example.gabo;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


/*-------------------핀 선택시 뜨는 유저 댓글 바텀시트 프래그먼트 --------------------------*/

public class BottomSheetDialogFrag extends BottomSheetDialogFragment {

    BottomSheetBehavior bBehavior;
    
    private ListView tc_list;
    private trsCommentAdapter tcAdapter = new trsCommentAdapter();

    //위치안내버튼
    private TextView btn_howtogo;
    //찾았다버튼
    private TextView btn_find;
    private Dialog win_dialog; //정답축하합니다 다이얼로그
    private Dialog findquizDailog;

    // 숨긴사람 이름
    private TextView ti_tv_comment;

    // 숨긴 보물의 해쉬태그
    private TextView ti_tv_tag1, ti_tv_tag2, ti_tv_tag3;

    // 메인엑티비티에서 번들로 가져온값을 저장하려고 만듬
    private String cate,key1,key2,key3,hideuser,hidedate,like;

    //trs_comment_bottom_sheet_lyt 레이아웃에서 변경한 값을 넣어줄 아이디를 넣어줄 변수
    private TextView ti_tv_when,ti_tv_like;




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

        // 메인액티비티에서 서버 리스폰 받아서 가져옴
        cate = getArguments().getString("cate");
        key1 =getArguments().getString("key1","0");
        key2 = getArguments().getString("key2","0");
        key3 = getArguments().getString("key3","0");
        hideuser = getArguments().getString("hideuser","0");
        hidedate = getArguments().getString("hidedate","0");
        like = getArguments().getString("like","0");

        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(),R.layout.trs_comment_bottom_sheet_lyt,null);

        dialog.setContentView(view);
        bBehavior = BottomSheetBehavior.from((View)view.getParent());

        View view2 = View.inflate(getContext(),R.layout.treasure_info_lyt,null);

        ti_tv_comment = view.findViewById(R.id.ti_tv_comment);
        ti_tv_tag1 = view.findViewById(R.id.ti_tv_tag1);
        ti_tv_tag2 = view.findViewById(R.id.ti_tv_tag2);
        ti_tv_tag3 = view.findViewById(R.id.ti_tv_tag3);
        ti_tv_when = view.findViewById(R.id.ti_tv_when);
        ti_tv_like = view.findViewById(R.id.ti_tv_like);

        ti_tv_comment.setText(hideuser);
        ti_tv_tag1.setText("#"+key1);
        ti_tv_tag2.setText("#"+key2);
        ti_tv_tag3.setText("#"+key3);
        ti_tv_when.setText(hidedate+"에 숨김");
        ti_tv_like.setText(like);

        System.out.println("숨긴날"+hidedate);






        /*---------------------찾았다 버튼--------------------- */
        btn_find = view.findViewById(R.id.btn_find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext().getApplicationContext(),"찾았다!",Toast.LENGTH_SHORT).show();
//                openWinDialog();
                openquizDialog();
            }
        });

        /*---------------------위치안내 버튼--------------------- */
        btn_howtogo = view.findViewById(R.id.btn_howtogo);
        btn_howtogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext().getApplicationContext(),"위치안내",Toast.LENGTH_SHORT).show();
            }
        });
        

        /*유저 댓글 리스트뷰*/
        tc_list = view.findViewById(R.id.user_comment_listview);
        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e1),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "gil-dong","#나무아래","#작은소품","#파란색","1분전에 숨김","38","친구들이랑 밥먹으러 가다 찾았어요!"

        );

        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e2),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "gil-dong","#전봇대","#조명","#골드","08/11/22 06:10 PM에 찾음","5","강아지랑 산책하다 찾았어요!꿀잼.."
        );

        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e3),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "JellyBean","#상자속","#텀블러","#노란색","08/06/22 09:00 PM에 찾음","25","텀블러 겟함! 감사감사"
        );

        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e4),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "mmthcoffee","#카페앞","#문구류","#핑크","07/25/22 10:00 PM에 찾음","40","예쁜 핑크색펜이었어요"
        );
        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e5),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "bean","#커피창고","#음료","#커피색","07/20/11 12:45 PM에 찾음","10","커피쿠폰이었음 굿"
        );
        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e6),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "heets","#의자옆","#문구류","#보라색","07/11/10 10:00 PM에 찾음","55","득템 ㄳ"
        );

        tc_list.setAdapter(tcAdapter);
        ListView user_comment_listview = getActivity().findViewById(R.id.user_comment_listview);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
    }



    /*---------------------------------------보물찾기 퀴즈 다이얼로그 실행---------------------------------------*/
    private void openquizDialog(){
        findquizDailog = new Dialog(getContext());
        findquizDailog.setContentView(R.layout.dialog_findquiz);
        findquizDailog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imageViewClose=findquizDailog.findViewById(R.id.imageViewClose);
        TextView tv_findquiz1 = findquizDailog.findViewById(R.id.tv_findquiz1);
        TextView tv_findquiz2 = findquizDailog.findViewById(R.id.tv_findquiz2);
        TextView tv_findquiz3 = findquizDailog.findViewById(R.id.tv_findquiz3);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findquizDailog.dismiss();
                Toast.makeText(getContext(), "Dialog Close", Toast.LENGTH_SHORT).show();
            }
        });
        tv_findquiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWinDialog();
                findquizDailog.dismiss();
            }
        });
        tv_findquiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWinDialog();
                findquizDailog.dismiss();
            }
        });
        tv_findquiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWinDialog();
                findquizDailog.dismiss();
            }
        });
        findquizDailog.show();

    }


    /*-----------------------------------보물찾기 정답 축하합니다 다이얼로그 실행-------------------------------------*/

    private void openWinDialog() {
        win_dialog = new Dialog(getContext());
        win_dialog.setContentView(R.layout.win_layout_dialog);
        win_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imageViewClose=win_dialog.findViewById(R.id.imageViewClose);
        TextView tvOk=win_dialog.findViewById(R.id.tvOk);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                win_dialog.dismiss();
                Toast.makeText(getContext(), "Dialog Close", Toast.LENGTH_SHORT).show();
            }
        });
        /*보물찾기 완료 버튼을 누르게 되면
        * 찾았다 버튼이 코멘트 남기기로 바뀐다*/
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                win_dialog.dismiss();
                btn_find.setText("코멘트 남기기");
                btn_find.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "코멘트남기기 화면으로 넘어가기", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        win_dialog.show();

    }
}
