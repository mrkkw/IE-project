package com.example.newgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.newgame.customViewCollection.custom_toast;

public class quiz_5 extends AppCompatActivity {

    String answer = "empty";

    String rightanswer = "Reflective duct tape";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_5);

        radio_quiz();

        text();

        backBtn();

        stepBtn();
    }

    private void radio_quiz(){
        //radio button set
        RadioGroup quiz_group = (RadioGroup)findViewById(R.id.radio_group_quiz5);
        RadioButton btn_a = (RadioButton) findViewById(R.id.radio_quiz5_a);
        RadioButton btn_b = (RadioButton) findViewById(R.id.radio_quiz5_b);
        RadioButton btn_c = (RadioButton) findViewById(R.id.radio_quiz5_c);
        RadioButton btn_d = (RadioButton) findViewById(R.id.radio_quiz5_d);
        //set gender
        quiz_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.radio_quiz5_a:
                        answer = "Reflective duct tape";
                        break;
                    case R.id.radio_quiz5_b:
                        answer = "Fountain pen";
                        break;
                    case R.id.radio_quiz5_c:
                        answer = "Sunglasses";
                        break;
                    case R.id.radio_quiz5_d:
                        answer = "A dark-colored cap";
                        break;
                    default:
                        answer = "empty";
                        break;
                }
            }
        });
    }

    private void text(){
        TextView textView = (TextView)findViewById(R.id.quiz5_text);

        textView.setText("When riding on the street (especially at night), you shouldn’t ride on the main road where larger vehicles such as buses and trucks travel at a high speed. In order to avoid drivers unable to see you and prevent hazards, which of these items you should take to help?\n");

    }

    private void backBtn(){
        Button btn = (Button)findViewById(R.id.back_button_quiz5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(quiz_5.this,gamepage.class);
                startActivity(intent);
            }
        });
    }

    private void stepBtn(){
        Button btn = (Button)findViewById(R.id.quiz5_button_next);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.equals("empty")){
                    custom_toast ct = new custom_toast();
                    ct.showToast(getApplicationContext(),"Answer should not be empty!");
                }else {
                    if (answer.equals(rightanswer)) {
                        custom_toast ct = new custom_toast();
                        ct.showToast(getApplicationContext(), "You are right!");
                    }else{
                        showDialog1(rightanswer);
                    }
                }
            }
        });
    }

    public void showDialog1(String xx) {
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
        textView.setText("The right answer is: " + xx);
        //show the dialog
        alert11.show();
    }
}
