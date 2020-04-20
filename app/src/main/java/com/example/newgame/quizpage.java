package com.example.newgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class quizpage extends AppCompatActivity {
    String nickname;
    String age;
    String gender;
    String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizpage);

        bakcbtn();

        nickname();

        genderRadioBtn();

        ageSpinner();

        topicSpinner();

        saveBtn();
    }

    private void bakcbtn(){
        Button btn_back = (Button) findViewById(R.id.back_button2);

        //back button2 , back to the mode page
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quizpage.this,modepage.class);
                startActivity(intent);
            }
        });
    }

    private void nickname(){
        //edit text
        final EditText editText = (EditText)findViewById(R.id.nickname_edit);
        nickname = editText.getText().toString();
    }

    private void ageSpinner(){
        //nice spinner1 initialisation
        NiceSpinner niceSpinner1 = (NiceSpinner) findViewById(R.id.nice_spinner1);
        List<String> dataset1 = new LinkedList<>(Arrays.asList("Under 12", "12", "Over 12 under 15", "over 15"));
        niceSpinner1.attachDataSource(dataset1);

        //ser selected toast for spinner1
        niceSpinner1.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                age = niceSpinner1.getSelectedItem().toString();
            }
        });
    }

    private void topicSpinner(){
        //nice spinner2 initialisation
        NiceSpinner niceSpinner2 = (NiceSpinner) findViewById(R.id.nice_spinner2);
        List<String> dataset2 = new LinkedList<>(Arrays.asList("Animal", "Machine", "Transport", "Chemist"));
        niceSpinner2.attachDataSource(dataset2);

        //set selected toast for spinner2
        niceSpinner2.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                topic = niceSpinner2.getSelectedItem().toString();
            }
        });
    }

    private void genderRadioBtn(){
        //radio button set
        RadioGroup gender_group = (RadioGroup)findViewById(R.id.radio_group);
        RadioButton btn_male = (RadioButton) findViewById(R.id.radio_male);
        RadioButton btn_female = (RadioButton) findViewById(R.id.radio_female);

        //set gender
        gender_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.radio_female:
                        gender = "Female";
                        break;
                    default:
                        gender = "Male";
                        break;
                }
            }
        });
    }

    private void saveBtn(){
        Button btn_save = (Button) findViewById(R.id.quiz_save_button);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //stored object for future use
                //User user = new User(nickname,age,gender,topic);

                //show toast
                String message = "Your character is: "+ nickname + "(" + gender + ")" + ", age: " + age + ", topic: " + topic;
                custom_toast ct = new custom_toast();
                ct.showToast(getApplicationContext(),message);
            }
        });
    }


}
