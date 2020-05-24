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
import com.example.newgame.AdapterCollection.knowledge_base_machinepageAdapter;

import java.util.ArrayList;
import java.util.List;

public class knowledge_base_machinepage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private knowledge_base_machinepageAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_base_machinepage);

        setRecyclerView();

        backbuttion();
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for ( int i=1; i < 17; i++) {
            mDatas.add( "Quiz "+i);
        }
    }

    private void setRecyclerView(){
        recyclerView = (RecyclerView)findViewById(R.id.knowledge_base_machinepage_list);

        initData();

        recycleAdapter= new knowledge_base_machinepageAdapter(knowledge_base_machinepage.this, mDatas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(recycleAdapter);

        //set cache size for recycler view
        recyclerView.setItemViewCacheSize(100);

    }

    private void backbuttion(){
        Button button = (Button)findViewById(R.id.knowledge_base_machinepage_back_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(knowledge_base_machinepage.this, Navigation_page.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });
    }
}
