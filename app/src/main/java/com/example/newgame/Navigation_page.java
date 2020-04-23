package com.example.newgame;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.github.clans.fab.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class Navigation_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_page_again);

        //configuration
        configure();

        //float button phone
        floatBtn_phone();

        //float button information
        floatBtn_information();
    }

    //configuration of fragment
    private void configure(){
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setItemIconTintList(null);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_me, R.id.navigation_map, R.id.navigation_favourite, R.id.navigation_KB)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    //phone button
    private void floatBtn_phone() {
        FloatingActionButton phone_btn = (FloatingActionButton) findViewById(R.id.emergency_phone);

        phone_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    //information button
    private void floatBtn_information(){
        FloatingActionButton phone_btn = (FloatingActionButton) findViewById(R.id.emergency_information);

        phone_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Navigation_page.this,emergency_information.class);
                startActivity(intent);

            }
        });
    }


    public void showDialog() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Welocme! New eagle!");
        builder1.setCancelable(true);

        builder1.setTitle("Emergency Contact!");
        builder1.setIcon(R.drawable.alert_icon);

        //set the view for the dialog
        View v = LayoutInflater.from(this).inflate(R.layout.activity_emergency_custom_dialog, null);

        //initialise the three buttons
        Button btn_contact_off = (Button) v.findViewById(R.id.emergency_contact_button);
        Button btn_contact_pri = (Button) v.findViewById(R.id.emergency_contact_button2);
        Button btn_cancel = (Button) v.findViewById(R.id.emergency_contact_button3);

        //to the official contact
        btn_contact_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("0415702125");
            }
        });

        //to the private emergency contact，preset private dial number
        btn_contact_pri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("0415702125");
            }
        });

        //insert the emergency dialog into page
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

    /**
     * call phone
     * DIAL PAGE
     * @param phone phone number
     */
    private void call(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
