package com.example.newgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.newgame.customViewCollection.custom_text_view;
import com.example.newgame.customViewCollection.custom_toast;

public class Introduction_page extends AppCompatActivity {

    private custom_text_view custom_text;
    String custom_text_text = "Introduction of YEV application\n\nHi new eagle!\nWe are glad to see you here and when you finish reading this introduction then you can test your knowledge and enjoy a pleasant trip in our game.\n\n" +
            "For eagles at different age group, we will navigate you to the different section of game.\n\n However if you want to explore the topics firstly, click on the menu button and you will find the knowledge base there.\n\n" +
            "Then at that position you can add the topics which your are interested in into my favourite topics.\n\nWhen you want to start the game, click on the game menu button and your trip will start!";
    int threshold = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_page);

        introduction();
    }

    private void introduction(){

        TextView textView = (TextView)findViewById(R.id.Introduction_text);

        //click for speeding up
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(threshold < 100){
                    threshold = 100;
                    custom_text.setTime(threshold);
                }else{
                    custom_toast ct = new custom_toast();
                    ct.showToast(getApplicationContext(),"maximum");
                }

            }
        });

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                game_menu_btn(count);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        custom_text = new custom_text_view(textView, custom_text_text, 100);
    }


    private void game_menu_btn(int xx){
        Button button = (Button)findViewById(R.id.welcome_button);

        if(xx!=custom_text_text.length()){
            button.setVisibility(View.INVISIBLE);
        }else{
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog();
                }
            });
        }
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

        //initialise the menu button
        Button btn_menu = (Button)v.findViewById(R.id.menu_button);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert11.dismiss();
                Intent  intent = new Intent(Introduction_page.this,Navigation_page.class);
                startActivity(intent);
            }
        });

        //show the dialog
        alert11.show();
    }
}
