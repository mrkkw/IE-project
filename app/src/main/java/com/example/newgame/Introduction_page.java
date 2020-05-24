package com.example.newgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newgame.customViewCollection.BubbleView;
import com.example.newgame.customViewCollection.custom_text_view;
import com.example.newgame.customViewCollection.custom_toast;

public class Introduction_page extends AppCompatActivity {

    private custom_text_view custom_text;
    private custom_text_view custom_text1;
    private custom_text_view custom_text2;
    private custom_text_view custom_text3;

    String intro_text1 = "Hi new eagle! This is the first time you sign in, let us introduce this quiz game for you!\nClick....";
    String intro_text2 = "After this page, you will be navigated to the customisation page where you can create a character for yourself!\nClick....";
    String intro_text3 = "After you have created a character, you will be navigated to the menu page where you can check the topics and enter the game!\nClick....";
    String intro_text4 = "Your game trip is based on the quiz format so you can earn knowledge during the game, click start and enjoy your trip!\nClick....";

    int threshold = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_page);

        introduction();

        game_menu_btn();
    }

    private void introduction(){
        TextView textView = (TextView)findViewById(R.id.BBBtextView1);

        TextView textView1 = (TextView)findViewById(R.id.BBBtextView2);
        textView1.setVisibility(View.INVISIBLE);

        TextView textView2 = (TextView)findViewById(R.id.BBBtextView3);
        textView2.setVisibility(View.INVISIBLE);

        TextView textView3 = (TextView)findViewById(R.id.BBBtextView4);
        textView3.setVisibility(View.INVISIBLE);

        custom_text = new custom_text_view(textView,intro_text1,25);

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()<intro_text1.length()){
                    textView.setClickable(false);
                }else{
                    textView.setClickable(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setClickable(false);
                textView1.setVisibility(View.VISIBLE);
                custom_text1 = new custom_text_view(textView1,intro_text2,25);
            }
        });

        textView1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()<intro_text1.length()){
                    textView1.setClickable(false);
                }else{
                    textView1.setClickable(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setClickable(false);
                textView2.setVisibility(View.VISIBLE);
                custom_text2 = new custom_text_view(textView2,intro_text3,25);
            }
        });

        textView2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()<intro_text1.length()){
                    textView2.setClickable(false);
                }else{
                    textView2.setClickable(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setClickable(false);
                textView3.setVisibility(View.VISIBLE);
                custom_text3 = new custom_text_view(textView3,intro_text4,25);
                threshold = 1;
            }
        });
    }

    private void game_menu_btn(){
        Button button = (Button)findViewById(R.id.welcome_button);
        button.setVisibility(View.INVISIBLE);
        button.setClickable(false);

        TextView textView3 = (TextView)findViewById(R.id.BBBtextView4);

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button.setVisibility(View.VISIBLE);
                button.setClickable(true);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Introduction_page.this,quizpage.class);
                        startActivity(intent);
                    }
                });
                textView3.setClickable(false);
            }
        });
    }

    //dialog
    public void showDialog(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Welcome! New eagle!");
        builder1.setCancelable(true);

        builder1.setTitle("Navigation Guideline!");
        builder1.setIcon(R.drawable.alert_icon);

        //set the view for the dialog
        View v = LayoutInflater.from(this).inflate(R.layout.activity_game_menu_dialog,null);

        //insert the quiz page into dialog
        builder1.setView(v);

        //building complete
        AlertDialog alert11 = builder1.create();

        //initialise the game button
        Button btn_game = (Button) v.findViewById(R.id.game_button);

        //to game page
        btn_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert11.dismiss();
                Intent  intent = new Intent(Introduction_page.this,quizpage.class);
                startActivity(intent);
            }
        });

        //show the dialog
        alert11.show();
    }
}
