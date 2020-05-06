package com.example.newgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newgame.ui.Favourite.Favourite;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        signinbutton();

        Imagevisble();
        //CoursesAsyncTask getAllCourses = new CoursesAsyncTask();
        //getAllCourses.execute();

    }

    private void signinbutton(){
        Button btn = (Button)findViewById(R.id.welcome_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Introduction_page.class);
                startActivity(intent);

            }
        });
    }

    private void Imagevisble(){
        ImageView imageView = (ImageView) findViewById(R.id.iv_unameClear);

        EditText editText = (EditText)findViewById(R.id.et_userName);

        editText.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                imageView.setVisibility(View.VISIBLE);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText("");
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable s) {
                imageView.setVisibility(View.INVISIBLE);

            }
        });

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    imageView.setAlpha((float) 0.5);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    imageView.setAlpha((float) 1);
                }
                return false;
            }
        });
    }

    private class CoursesAsyncTask extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground (Void...params){

            return callingAWSWS.testAWS();
        }
        @Override
        protected void onPostExecute (String courses){
            TextView textView = (TextView)findViewById(R.id.testWS);
            textView.setText(courses);
        }
    }



    /*
     public void showDialog(View view){

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Welocme!New eagle!\nHow old are you? ");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Over 12",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent1 = new Intent(MainActivity.this,quizpage.class);
                        startActivity(intent1);
                    }
                });

        builder1.setNegativeButton(
                "Under 12",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent1 = new Intent(MainActivity.this,gamepage.class);
                        startActivity(intent1);
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
     */


}
