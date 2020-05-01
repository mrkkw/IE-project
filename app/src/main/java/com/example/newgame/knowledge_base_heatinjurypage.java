package com.example.newgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.newgame.AdapterCollection.knowledge_base_fallpageAdapter;
import com.example.newgame.AdapterCollection.knowledge_base_heatinjurypageAdapter;

import java.util.ArrayList;
import java.util.List;

public class knowledge_base_heatinjurypage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private knowledge_base_heatinjurypageAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_base_heatinjurypage);

        setRecyclerView();

        backbuttion();
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        mDatas.add( "Topic: FALL");
        mDatas.add( "Topic: TRANSPORT");
        mDatas.add( "Topic: MACHINE");
        mDatas.add( "Topic: SUNSHINE");
    }

    private void setRecyclerView(){
        recyclerView = (RecyclerView)findViewById(R.id.knowledge_base_heatinjurypage_list);

        initData();

        recycleAdapter= new knowledge_base_heatinjurypageAdapter(knowledge_base_heatinjurypage.this, mDatas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(recycleAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void backbuttion(){
        Button button = (Button)findViewById(R.id.knowledge_base_heatinjurypage_list);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(knowledge_base_heatinjurypage.this, Navigation_page.class);
                startActivity(intent);
            }
        });
    }
}