package com.example.newgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.newgame.ui.Favourite.Favourite;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   // set no title of app name on the top

        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.welcome_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,modepage.class);
                startActivity(intent);
                //CoursesAsyncTask getAllCourses = new CoursesAsyncTask();
               //getAllCourses.execute();
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
