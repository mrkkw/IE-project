package com.example.newgame.customViewCollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.newgame.AdapterCollection.emergency_adapter;
import com.example.newgame.Navigation_page;
import com.example.newgame.R;

import java.util.ArrayList;
import java.util.List;

public class emergency_information extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private emergency_adapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_information);

        //back
        back();

        //init
        initData();
        recyclerView = (RecyclerView)findViewById(R.id.emergency_infor_list);

        recycleAdapter= new emergency_adapter(emergency_information.this,mDatas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setAdapter(recycleAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            mDatas.add("information " + i);
        }
    }

    private void back(){
        Button btn_back = (Button) findViewById(R.id. back_button_emergency_information);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(emergency_information.this, Navigation_page.class);
                startActivity(intent1);
            }
        });
    }

}
