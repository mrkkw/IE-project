package com.example.newgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class modepage extends AppCompatActivity {

    int signal;
    final String default_name="mrkkw";
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modepage);

        //remind dialog
        showDialog();

        //back button function
        Menubtn();

        //children button function
        child();

        //adult button function
        adult();

        //customise button
        customiseBTN();
    }

    private void Menubtn(){
        Button btn_menu = (Button) findViewById(R.id.back_button);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(modepage.this,Navigation_page.class);
                startActivity(intent1);
            }
        });
    }


    private void child(){
        Button btn_child = (Button)findViewById(R.id.children_mode_button);

        btn_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(modepage.this,gamepage.class);
                startActivityForResult(intent2,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode == RESULT_OK){
                signal = 1;
            }
        }
    }

    private void adult(){
        Button btn_adult = (Button)findViewById(R.id.adult_mode_button);

        btn_adult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(modepage.this,gamepage.class);
                startActivityForResult(intent3,1);
            }
        });
    }

    private void customiseBTN(){
        Button btn = (Button)findViewById(R.id.customise_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    public void showDialog(){

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Welocme! New eagle!");
        builder1.setCancelable(true);

        builder1.setTitle("Navigation Guideline!");
        builder1.setIcon(R.drawable.alert_icon);

        //set the view for the dialog
        View v = LayoutInflater.from(this).inflate(R.layout.activity_custome_dialog,null);

        //initialise the three buttons
        Button btn_customise = (Button) v.findViewById(R.id.customise_quiz_button);
        Button btn_menu = (Button) v.findViewById(R.id.menu_button);
        Button btn_cancel = (Button) v.findViewById(R.id.cancel_button);

        //to the quiz page
        btn_customise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(modepage.this,quizpage.class);
                startActivity(intent);
            }
        });

        //to the menu page
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(modepage.this,Navigation_page.class);
                startActivity(intent);
            }
        });

        //insert the quiz page into dialog
        builder1.setView(v);

        //building complete
        AlertDialog alert11 = builder1.create();

        //quit the dialog
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert11.dismiss();
            }
        });

        //show the dialog
        alert11.show();
    }

}
