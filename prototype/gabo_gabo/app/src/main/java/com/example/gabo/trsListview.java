package com.example.gabo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class trsListview extends Fragment {

        private ListView tl_list;
        private TextView tl_T_num;
        private trsListviewAdapter adapter = new trsListviewAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.trs_listview,container,false);

        tl_list = view.findViewById(R.id.tl_list);

        adapter.listaddItems(ContextCompat.getDrawable(getActivity(), R.drawable.e1),ContextCompat.getDrawable(getActivity(),R.drawable.like_full),"parky","1km","#나무아래","#작은소품","#파란색","1분전에 숨김","123");
        adapter.listaddItems(ContextCompat.getDrawable(getActivity(), R.drawable.e2),ContextCompat.getDrawable(getActivity(),R.drawable.like_full),"PTSD","2km","#전봇대","#조명","#골드","08/11/22 06:10 PM에 찾음","23");
        adapter.listaddItems(ContextCompat.getDrawable(getActivity(), R.drawable.e3),ContextCompat.getDrawable(getActivity(),R.drawable.like_full),"Bugs","6km","#상자속","#텀블러","#노란색","지금 숨김","13");
        adapter.listaddItems(ContextCompat.getDrawable(getActivity(), R.drawable.e4),ContextCompat.getDrawable(getActivity(),R.drawable.like_full),"Undaed","7km","hint1","hint2","hin3","지금 숨김","12");
        adapter.listaddItems(ContextCompat.getDrawable(getActivity(), R.drawable.e1),ContextCompat.getDrawable(getActivity(),R.drawable.like_full),"Coliny","10km","한글자ㅇ","두글자ㅇ","세글자","지금 숨김","1323");
        adapter.listaddItems(ContextCompat.getDrawable(getActivity(), R.drawable.e3),ContextCompat.getDrawable(getActivity(),R.drawable.like_full),"Bugs","6km","hint1","hint2","hin3","지금 숨김","13");
        adapter.listaddItems(ContextCompat.getDrawable(getActivity(), R.drawable.e4),ContextCompat.getDrawable(getActivity(),R.drawable.like_full),"Undaed","7km","hint1","hint2","hin3","지금 숨김","12");
        adapter.listaddItems(ContextCompat.getDrawable(getActivity(), R.drawable.e1),ContextCompat.getDrawable(getActivity(),R.drawable.like_full),"Coliny","10km","한글자ㅇ","두글자ㅇ","세글자","지금 숨김","1323");
        tl_list.setAdapter(adapter);

        return view;


    }
}
