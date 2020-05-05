package com.example.newgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.newgame.customViewCollection.custom_toast;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class quizpage extends AppCompatActivity {
    String age=null;
    String gender=null;
    String topic=null;
    String livingArea=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizpage);

        showDialog();

        changePortrait();

        genderRadioBtn();

        ageSpinner();

        topicSpinner();

        livingareaSpinner();

        saveBtn();

        checkBtn();
    }

    private void changePortrait(){
        Button btn_portrait = (Button)findViewById(R.id.portrait_save_button);

        btn_portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageFromAlbum();
            }
        });
    }

    private String nickname(){
        String nickname;
        //edit text
        EditText editText = (EditText)findViewById(R.id.nickname_edit);
        nickname = editText.getText().toString();

        return nickname;

    }

    private void ageSpinner(){
        //nice spinner1 initialisation
        NiceSpinner niceSpinner1 = (NiceSpinner) findViewById(R.id.nice_spinner1);
        List<String> dataset1 = new LinkedList<>(Arrays.asList("Under 12", "12", "Over 12"));
        niceSpinner1.attachDataSource(dataset1);

        //ser selected toast for spinner1
        niceSpinner1.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                if(age==null){
                    age = "Under 12";
                }else{
                    age = niceSpinner1.getSelectedItem().toString();
                }
            }
        });
    }

    private void topicSpinner(){
        //nice spinner2 initialisation
        NiceSpinner niceSpinner2 = (NiceSpinner) findViewById(R.id.nice_spinner2);
        List<String> dataset2 = new LinkedList<>(Arrays.asList("Transport", "Machine", "Fall down", "Heat injury"));
        niceSpinner2.attachDataSource(dataset2);

        //set selected toast for spinner2
        niceSpinner2.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                if(topic == null){
                    topic = "Animal";
                }else{
                    topic = niceSpinner2.getSelectedItem().toString();
                }
            }
        });


    }

    private void livingareaSpinner(){
        //nice spinner2 initialisation
        NiceSpinner niceSpinner3 = (NiceSpinner) findViewById(R.id.nice_spinner3);
        List<String> dataset3 = new LinkedList<>(Arrays.asList("Rural Victoria","Urban Victoria","Don't want to say"));
        niceSpinner3.attachDataSource(dataset3);

        //set selected toast for spinner2
        niceSpinner3.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                if (livingArea == null) {
                    livingArea = "Rural Victoria";
                } else {
                    livingArea = niceSpinner3.getSelectedItem().toString();
                }
            }
        });
    }

    private void genderRadioBtn(){
        //radio button set
        RadioGroup gender_group = (RadioGroup)findViewById(R.id.radio_group);
        RadioButton btn_male = (RadioButton) findViewById(R.id.radio_male);
        RadioButton btn_female = (RadioButton) findViewById(R.id.radio_female);
        RadioButton btn_unisex = (RadioButton) findViewById(R.id.radio_unisex);

        //set gender
        gender_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.radio_female:
                        gender = "Female";
                        break;
                    case R.id.radio_unisex:
                        gender = "other";
                        break;
                    default:
                        gender = "Male";
                        break;
                }
            }
        });
    }

    private void checkBtn(){
        Button btn_save = (Button) findViewById(R.id.check_duplicate_button);
        custom_toast ct = new custom_toast();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check duplicate
                checkUser checkuser  = new checkUser();
                if(nickname().isEmpty()){
                    ct.showToast(getApplicationContext(),"Empty!");
                }else{
                    checkuser.execute(nickname());
                }
            }
        });
    }

    private void saveBtn(){
        Button btn_save = (Button) findViewById(R.id.quiz_save_button);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //custom toast
                custom_toast ct = new custom_toast();

                String message;

                //stored user name
                String nickname = nickname();

                //validation
                if(nickname.isEmpty()){
                    ct.showToast(getApplicationContext(),"Nick name should not be empty(Default: mrkkw)");
                    EditText editText = (EditText) findViewById(R.id.nickname_edit);
                    editText.setError("Nickname should not be empty!");

                } else if (nickname.length()>10){
                    EditText editText = (EditText) findViewById(R.id.nickname_edit);
                    editText.setError("Nickname should not beyond 10 words!");
                    editText.setTextColor(getResources().getColor(R.color.hongse));

                    editText.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            if(editText.getText().toString().length()<=10){
                                editText.setTextColor(getResources().getColor(R.color.black));
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });

                } else if(nickname.equals("WrOnG!")){
                    ct.showToast(getApplicationContext(),"Duplicate nickname");
                } else{
                        //toast
                        message = "Your character is: "+ nickname + "(" + gender + ")" + ", age: " + age + ", topic: " + topic;

                        //asyncTask post
                        userAsyncTask postUser = new userAsyncTask();

                        postUser.execute(nickname,gender,age,livingArea,topic);

                        //SharedPreferences
                        SharedPreferences sp = getSharedPreferences("sp_name", Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = sp.edit();

                        //store information
                        editor.putString("nickname",nickname);

                        editor.putString("age",age);

                        editor.putString("gender",gender);

                        editor.putString("topic",topic);

                        editor.putString("living area",livingArea);

                        editor.commit();

                        Intent intent = new Intent(quizpage.this,gamepage.class);
                        startActivity(intent);
                    }
            }
        });
    }

    //choose the image from album
    protected void getImageFromAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        custom_toast ct  = new custom_toast();

        if (requestCode == 101) {
            Uri uri = data.getData();
            String str = uri.toString();

            ImageView imageView = (ImageView)findViewById(R.id.icon_image);
            imageView.setImageURI(uri);

            //store the uri
            SharedPreferences sp = getSharedPreferences("sp_name", Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sp.edit();

            editor.putString("uri",str);

            editor.commit();
            //set show
            ct.showToast(getApplicationContext(),"Portrait set succeed!");
        } else{

            //fail show
            ct.showToast(getApplicationContext(),"Access image failed!");
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
        View v = LayoutInflater.from(this).inflate(R.layout.activity_custome_dialog,null);

        //insert the quiz page into dialog
        builder1.setView(v);

        //building complete
        AlertDialog alert11 = builder1.create();

        //initialise the start button
        Button btn_cancel = (Button) v.findViewById(R.id.cancel_button);

        //quit the dialog
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert11.dismiss();
            }
        });

        //initialise the text view
        TextView textView = (TextView) v.findViewById(R.id.welcome_text);
        textView.setText("Hi new eagle!\nThis is the first time you sign in, customise a character for yourself!\nWhen finished, click the start button and go ahead!");
        //show the dialog
        alert11.show();
    }

    //post the user information to aws
    private class userAsyncTask extends AsyncTask<String, Void,String>
    {
        @Override
        protected String doInBackground (String ...params) {

            callingAWSWS.createUser(params[0],params[1],params[2],params[3],params[4]);
            return  "Character was added";
        }

        @Override
        protected void onPostExecute(String response) {
            custom_toast ct = new custom_toast();
            ct.showToast(getApplicationContext(),response);
        }
    }

    private class checkUser extends AsyncTask<String,Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            return callingAWSWS.checkUserexist(strings[0]);
        }

        @Override
        protected void onPostExecute(String response) {

            String substring = response.substring(response.lastIndexOf(":")+1);
            EditText editText = (EditText) findViewById(R.id.nickname_edit);
            Character subbstring = substring.charAt(0);

            int subint = Integer.valueOf(subbstring);

            if(subint==49){

                editText.setError("Nickname should not duplicate!");
                editText.setText("WrOnG!");
                editText.setTextColor(getResources().getColor(R.color.hongse));

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(editText.getText().toString().length()==0){
                            editText.setTextColor(getResources().getColor(R.color.black));
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }else{
               custom_toast ct = new custom_toast();
               ct.showToast(getApplicationContext(),"Nickname can be used!");
            }
        }
    }
}

