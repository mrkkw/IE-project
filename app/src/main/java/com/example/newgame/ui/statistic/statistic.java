package com.example.newgame.ui.statistic;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.newgame.AdapterCollection.statistic_RecyclerAdapter;
import com.example.newgame.R;
import com.example.newgame.quiz_1;

import java.util.ArrayList;
import java.util.List;

public class statistic extends Fragment {

    private StatisticViewModel mViewModel;

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private statistic_RecyclerAdapter recycleAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(StatisticViewModel.class);
        View root = inflater.inflate(R.layout.statistic_page_fragment, container, false);

        setRecyclerView(root);

        return root;
    }

    private void setRecyclerView(View view){

        recyclerView = view.findViewById(R.id.statistic_image);

        initData();

        recycleAdapter= new statistic_RecyclerAdapter(view.getContext(), mDatas,recyclerView);

        //set linear layout manager
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(view.getContext());

        recyclerView.setLayoutManager(mLinearLayoutManager);

        mLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        //set adapter
        recyclerView.setAdapter(recycleAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));

    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for ( int i=1; i < 9; i++) {
            mDatas.add( "Quiz "+i);
        }
    }
}
