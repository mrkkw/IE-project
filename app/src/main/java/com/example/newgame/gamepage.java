package com.example.newgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.newgame.AdapterCollection.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class gamepage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private MyRecyclerAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamepage);

        //back_button
        back();

        //initialise the recycler view
        setRecyclerView();

        //menu button
        menu();
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        mDatas.add( "Topic: FALL");
        mDatas.add( "Topic: TRANSPORT");
        mDatas.add( "Topic: MACHINE");
    }

    private void setRecyclerView(){
        recyclerView = (RecyclerView)findViewById(R.id.game_list);

        initData();

        recycleAdapter= new MyRecyclerAdapter(gamepage.this, mDatas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(recycleAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void back(){
        Button btn_back = (Button) findViewById(R.id.back_button);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(gamepage.this,Navigation_page.class);
                startActivity(intent1);
            }
        });
    }


    private void menu(){
        Button btn_back = (Button) findViewById(R.id.menu_button_gamepage);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(gamepage.this,Navigation_page.class);
                startActivity(intent1);
            }
        });
    }


}
