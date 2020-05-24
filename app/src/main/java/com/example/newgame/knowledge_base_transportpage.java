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
import com.example.newgame.AdapterCollection.knowledge_base_transportpageAdapter;

import java.util.ArrayList;
import java.util.List;

public class knowledge_base_transportpage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private knowledge_base_transportpageAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_base_transportpage);

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
        recyclerView = (RecyclerView)findViewById(R.id.knowledge_base_transportpage_list);

        initData();

        recycleAdapter= new knowledge_base_transportpageAdapter(knowledge_base_transportpage.this, mDatas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(recycleAdapter);

        //set cache size for recycler view
        recyclerView.setItemViewCacheSize(100);

    }

    private void backbuttion(){
        Button button = (Button)findViewById(R.id.knowledge_base_transportpage_back_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(knowledge_base_transportpage.this, Navigation_page.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });
    }
}
