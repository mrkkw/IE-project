package com.example.newgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.newgame.AdapterCollection.MyRecyclerAdapter;
import com.example.newgame.AdapterCollection.game_fall_listAdapter;
import com.example.newgame.customViewCollection.custom_toast;

import java.util.ArrayList;
import java.util.List;

public class quiz_1 extends AppCompatActivity {

    int step = 0;

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private game_fall_listAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_1);

        showDialog();

        setRecyclerView();

        backBtn();
    }

    private void setRecyclerView(){

        recyclerView = (RecyclerView)findViewById(R.id.game_fall_quiz_list);

        initData();

        recycleAdapter= new game_fall_listAdapter(quiz_1.this, mDatas,recyclerView);

        //set linear layout manager
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLinearLayoutManager);

        mLinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        //set touch scroll false
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        //set cache size for recycler view
        recyclerView.setItemViewCacheSize(100);

        //set adapter
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
        Button btn = (Button)findViewById(R.id.back_button_quiz1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog();
            }
        });
    }

    public void showDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Welcome! New eagle!");
        builder1.setCancelable(true);

        builder1.setTitle("Everyday tips!");
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
        textView.setText("Do not touch the ground or push off with your hands on the see-saw!");

        Drawable drawable = v.getResources().getDrawable(R.drawable.tips_item_pic);
        ImageView imageView = (ImageView) v.findViewById(R.id.dialog_image);
        imageView.setImageDrawable(drawable);

        //show the dialog
        alert11.show();
    }

    public void alertDialog() {
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

        btn_cancel.setText("Confirm!");
        //quit the dialog
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert11.dismiss();
                Intent intent = new Intent(quiz_1.this,gamepage.class);
                startActivity(intent);
            }
        });

        //initialise the text view
        Drawable drawable = v.getResources().getDrawable(R.drawable.goodbye_pic);
        ImageView imageView = (ImageView) v.findViewById(R.id.dialog_image);
        imageView.setImageDrawable(drawable);

        //initialise the text view
        TextView textView = (TextView) v.findViewById(R.id.welcome_text);
        textView.setText("Your progress maybe lost before finish all the quizes\n\nDo you still want to quit?");
        //show the dialog
        alert11.show();
    }
}
