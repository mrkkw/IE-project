package com.example.newgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.newgame.AdapterCollection.game_machine_listAdapter;
import com.example.newgame.AdapterCollection.game_sunshine_listAdapter;
import com.example.newgame.customViewCollection.custom_toast;

import java.util.ArrayList;
import java.util.List;

public class quiz_4 extends AppCompatActivity {
    int step = 0;
    private RecyclerView recyclerView;
    private List<String> mDatas;
    private game_sunshine_listAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_4);

        showDialog();

        setRecyclerView();

        backBtn();

        stepBtn();
    }

    private void setRecyclerView(){

        recyclerView = (RecyclerView)findViewById(R.id.game_sunshine_quiz_list);

        initData();

        recycleAdapter= new game_sunshine_listAdapter(quiz_4.this, mDatas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recyclerView.setAdapter(recycleAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for ( int i=1; i < 16; i++) {
            mDatas.add( "Quiz "+i);
        }
    }

    private void backBtn(){
        Button btn = (Button)findViewById(R.id.back_button_quiz4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quiz_4.this,gamepage.class);
                startActivity(intent);
            }
        });
    }


    private void stepBtn(){
        Button btn = (Button)findViewById(R.id.step_button_quiz4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(step == 0){
                    MoveToPosition(recyclerView,1);
                    step++;
                }else if(step>=1&&step<14){
                    MoveToPosition(recyclerView,++step);
                }else if(step == 14){
                    btn.setText("Finish");
                }

                if(btn.getText().toString().equals("Finish")){
                    reportdialog();
                }
            }
        });
    }

    public static void MoveToPosition(RecyclerView mRecyclerView, int n) {
        mRecyclerView.scrollToPosition(n);
    }

    public void showDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Welcome! New eagle!");
        builder1.setCancelable(true);

        builder1.setTitle("Quiz guideline!");
        builder1.setIcon(R.drawable.alert_icon);

        //set the view for the dialog
        View v = LayoutInflater.from(this).inflate(R.layout.activity_custome_dialog, null);

        //insert the quiz page into dialog
        builder1.setView(v);

        //building complete
        AlertDialog alert11 = builder1.create();

        //initialise the start button
        Button btn_cancel = (Button) v.findViewById(R.id.cancel_button);

        btn_cancel.setText("Go!");
        //quit the dialog
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert11.dismiss();
            }
        });

        //initialise the text view
        TextView textView = (TextView) v.findViewById(R.id.welcome_text);
        textView.setText("The first 10 questions are general quizes and the last five questions are situational quizes\nThe order of answering question is 1-15 but if you want to answer the last firstly just scroll the quiz screen");
        //show the dialog
        alert11.show();
    }

    public void reportdialog(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Good job! New eagle!");
        builder1.setCancelable(true);

        builder1.setTitle("Quiz report!");
        builder1.setIcon(R.drawable.alert_icon);

        //set the view for the dialog
        View v = LayoutInflater.from(this).inflate(R.layout.activity_custome_dialog,null);

        //insert the quiz page into dialog
        builder1.setView(v);

        //building complete
        AlertDialog alert11 = builder1.create();

        //initialise the start button
        Button btn_cancel = (Button) v.findViewById(R.id.cancel_button);

        btn_cancel.setText("Finish!");
        //quit the dialog
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert11.dismiss();
                Intent intent  = new Intent(quiz_4.this,gamepage.class);
                startActivity(intent);
            }
        });

        //initialise the text view
        TextView textView = (TextView) v.findViewById(R.id.welcome_text);
        textView.setText("Congratulation! You have finished all questions!");
        //show the dialog
        alert11.show();
    }
}
