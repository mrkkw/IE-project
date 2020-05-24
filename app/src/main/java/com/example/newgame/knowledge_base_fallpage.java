package com.example.newgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.newgame.AdapterCollection.MyRecyclerAdapter;
import com.example.newgame.AdapterCollection.knowledge_base_fallpageAdapter;
import com.example.newgame.Database.DatabaseHelper;
import com.example.newgame.R;
import com.example.newgame.ui.Favourite.Favourite;

import java.util.ArrayList;
import java.util.List;

public class knowledge_base_fallpage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private knowledge_base_fallpageAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_base_fallpage);

        setRecyclerView();

        backbuttion();
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for ( int i=1; i < 15; i++) {
            mDatas.add( "Quiz "+i);
        }
    }

    private void setRecyclerView(){
        recyclerView = (RecyclerView)findViewById(R.id.knowledge_base_fallpage_list);

        initData();

        recycleAdapter= new knowledge_base_fallpageAdapter(knowledge_base_fallpage.this, mDatas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(recycleAdapter);

        //set cache size for recycler view
        recyclerView.setItemViewCacheSize(100);

    }

    private void backbuttion(){
        Button button = (Button)findViewById(R.id.knowledge_base_fallpage_back_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(knowledge_base_fallpage.this,Navigation_page.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });
    }
}
