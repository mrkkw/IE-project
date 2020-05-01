package com.example.newgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class choice_game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_game);

        TextView textView = (TextView)findViewById(R.id.choice_text);

        textView.setText("Before riding a bike, one of the most important safety measures I should consider is wearing a special piece of equipment over my head to protect myself. What's the name of that?\n");

        Button btn = (Button)findViewById(R.id.quiz_yesOrno_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choice_game.this,yesOrno_game.class);
                startActivity(intent);
            }
        });
    }
}
