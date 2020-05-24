package com.example.newgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Build;
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

import com.example.newgame.customViewCollection.custom_toast;
import com.example.newgame.ui.Favourite.Favourite;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import dmax.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        signinbutton();

        signupbutton();

        Imagevisible();

    }

    private String nickname(){
        String nickname;
        //edit text
        EditText editText = (EditText)findViewById(R.id.et_userName);
        nickname = editText.getText().toString();

        return nickname;
    }

    private void signinbutton(){
        Button btn = (Button)findViewById(R.id.welcome_button);
        EditText editText = (EditText)findViewById(R.id.et_userName);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkUser checkuser  = new checkUser();
                getUserinformation getuser = new getUserinformation();

                //check duplicate
                if(nickname().isEmpty()){
                    editText.setError("Nick name should not be empty!");
                }else{
                    getuser.execute(nickname());
                    checkuser.execute(nickname());
                }

            }
        });
    }

    private void signupbutton(){
        Button btn = (Button)findViewById(R.id.sign_up_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Introduction_page.class);
                startActivity(intent);
            }
        });
    }


    private void Imagevisible(){
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
                        imageView.setVisibility(View.INVISIBLE);
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable s) {
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

    private class getUserinformation extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground (String... strings){

            return callingAWSWS.getUserinformation(strings[0]);
        }

        @Override
        protected void onPostExecute (String user){

            int start = user.indexOf("[");
            int end = user.indexOf("]");

            String sub = user.substring(start+1,end);

            try{
                JSONObject jsonObject = new JSONObject(sub);

                String nickname = jsonObject.getString("user_name");

                String gender = jsonObject.getString("user_gender");

                if(gender.equals("M")){
                    gender = "Male";
                }else{
                    gender = "Female";
                }

                String age = jsonObject.getString("user_age_category");

                String livingArea = jsonObject.getString("user_region");

                String topic = jsonObject.getString("user_fav_topic");

                //SharedPreferences
                SharedPreferences sp = getSharedPreferences("sp_name1", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sp.edit();

                //store information
                editor.putString("nickname",nickname);

                editor.putString("age",age);

                editor.putString("gender",gender);

                editor.putString("topic",topic);

                editor.putString("living area",livingArea);

                editor.putString("uri","123");

                editor.apply();
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
    }

    //check user existence
    private class checkUser extends AsyncTask<String,Void, String>{

        @Override
        protected void onPreExecute(){
            showDialog();
        }

        @Override
        protected String doInBackground(String... strings) {

            return callingAWSWS.checkUserexist(strings[0]);
        }

        @Override
        protected void onPostExecute(String response) {

            String substring = response.substring(response.lastIndexOf(":")+1);
            Character subbstring = substring.charAt(0);

            int subint = Integer.valueOf(subbstring);

            if(subint==49){
                Intent intent = new Intent(MainActivity.this,Navigation_page.class);
                startActivity(intent);
            }else{
                custom_toast ct = new custom_toast();
                ct.showToast(getApplicationContext(),"No such nickname founded! Sign up for a new character!");
            }
        }
    }

    //dialog
    public void showDialog(){
        SpotsDialog.Builder builder1 = new SpotsDialog.Builder();

        builder1.setCancelable(true);

        //building complete
        SpotsDialog alert11 = (SpotsDialog) builder1.setContext(this).build();

        alert11.setCanceledOnTouchOutside(true);

        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                alert11.dismiss();
                t.cancel();
            }
        }, 3000);

        //show the dialog
        alert11.show();
    }
}
