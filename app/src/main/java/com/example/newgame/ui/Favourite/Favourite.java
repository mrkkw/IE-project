package com.example.newgame.ui.Favourite;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newgame.Favourite_item_RecyclerAdapter;
import com.example.newgame.MyRecyclerAdapter;
import com.example.newgame.R;
import com.example.newgame.callingAWSWS;
import com.example.newgame.gamepage;
import com.example.newgame.item_space_recyclerview;

import java.util.ArrayList;
import java.util.List;

public class Favourite extends Fragment {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private Favourite_item_RecyclerAdapter recycleAdapter;

    //item space
    int space = 8;

    private FavouriteViewModel favouriteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favouriteViewModel =
                ViewModelProviders.of(this).get(FavouriteViewModel.class);
        View root = inflater.inflate(R.layout.favourite_fragment, container, false);


        recyclerView = root.findViewById(R.id.favourite_item_list);

        initData(5);

        recycleAdapter= new Favourite_item_RecyclerAdapter(getContext(), mDatas);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(recycleAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        recyclerView.addItemDecoration(new item_space_recyclerview(space));

        return root;
    }

    private void initData(int index) {
        mDatas = new ArrayList<String>();
        if (index > 0) {
            for ( int i=0; i < index; i++) {
                mDatas.add( "Favourite item "+i);
            }
        }else{
            mDatas.add( "Favourite item "+1);
        }

    }

}

