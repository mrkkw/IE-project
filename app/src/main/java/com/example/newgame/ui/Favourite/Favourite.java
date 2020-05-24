package com.example.newgame.ui.Favourite;

import androidx.lifecycle.ViewModelProviders;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newgame.AdapterCollection.Favourite_item_RecyclerAdapter;
import com.example.newgame.Database.DatabaseHelper;
import com.example.newgame.R;
import com.example.newgame.item_space_recyclerview;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Favourite extends Fragment {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private Favourite_item_RecyclerAdapter recycleAdapter;

    //item space
    int number = 0;

    private FavouriteViewModel favouriteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favouriteViewModel =
                ViewModelProviders.of(this).get(FavouriteViewModel.class);
        View root = inflater.inflate(R.layout.favourite_fragment, container, false);


        recyclerView = root.findViewById(R.id.favourite_item_list);

        initData(root);

        //initialise the recycler view
        recycleAdapter= new Favourite_item_RecyclerAdapter(getContext(), mDatas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(recycleAdapter);

        //set visibility of alert view
        setAlert(root,recyclerView);

        return root;
    }

    private void initData(View view) {
        mDatas = new ArrayList<String>();

        List<String> xx = new ArrayList<String>();

        for(int index = 0;index<queryAllTips(view).size();index++){
            if(!xx.contains(queryAllTips(view).get(index))){
                xx.add(queryAllTips(view).get(index));
            }
        }

        mDatas = xx;
    }

    private void setAlert(View view,RecyclerView recyclerView){
        TextView textView = view.findViewById(R.id.Empty_alert);
        int xx = recyclerView.getAdapter().getItemCount();

        if(xx == 0){
            textView.setVisibility(View.VISIBLE);
        }else{
            textView.setVisibility(View.INVISIBLE);
        }


    }

    public List<String> queryAllTips(View view){

        DatabaseHelper dbHelper = new DatabaseHelper(view.getContext(), "fav_db",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query("favourite",null,null,null,null,null,null,null);
        List<String> Tips = new ArrayList<>();
        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {

                String tips = cursor.getString(cursor.getColumnIndex("Tips"));

                Tips.add(tips);

                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return Tips;
    }

    public void deleteTips(View view,String tips){
        DatabaseHelper dbHelper = new DatabaseHelper(view.getContext(), "fav_db",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete("favourite","Tips=?",new String[]{ String.valueOf(tips)});
    }
}

