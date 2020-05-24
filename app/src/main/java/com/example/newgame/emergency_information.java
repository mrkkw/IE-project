package com.example.newgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.newgame.AdapterCollection.emergency_adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import dmax.dialog.SpotsDialog;

public class emergency_information extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private emergency_adapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_information);

        //back
        back();

        //init data
        initData();

        //get emergency information
        getEmergencyInfor getEmergencyInfor = new getEmergencyInfor();

        getEmergencyInfor.execute();
    }

    private void initData() {
        mDatas = new ArrayList<String>();

        mDatas.add("Broken bones are painful so do not touch!\n1.\tIf the injured person is in a safe place, is breathing, is awake?\nYes--- go next steps\nNo---call and follow ‘DRSABCD’ \n\nGiven in General Emergency Aid section\n1.\tCall for help from an adult or send someone to call for help\n2.\tAsk if injured person wants you to help \n3.\tAsk injured person where it hurts\n4.\tMaking injured person comfortable by using your jumper or something soft to rest the injured part on.\n5.\tIf a leg is injured put a jumper between the legs, and under the knees to make them more comfortable and keep them still. If it hurts her, don't move her legs.\n6.\tAlways tell injured person what you are doing so that she won't get scared and to avoid sudden movements.");

        mDatas.add("Features:\n1.\tShivering and shaking. \n2.\tDizziness.\n3.\tFeeling sick. \n4.\tTroubled breathing.\n\nSteps:\n1.\tKeep affected person warm by wrapping or covering her with a blanket, or even your jumper if there is nothing else around.\n2.\tTalk to him/her to keep her calm.\n3.\tHelp her/him to lie down and lift her/him feet higher than her/him head to stop the dizziness. This sends blood back to the brain. You get dizzy when blood goes away from the brain.\n[Don’t do this if the legs are injured as it could really hurt your poor friend!]\n4.\tTry to shade your friend if the weather is hot.\n5.\tPut something underneath her/him to stop the heat, or the cold, from the ground and to help keep her body temperature steady - but not if it means moving the injured ");

        mDatas.add("1.\tRemaining stingers from insects can be removed with a fingernail or similar.\n2.\tUsing tweezers should be avoided, as they can release more venom into the site.\n3.\tA band-aid, followed by a topical cream, such as calamine lotion, will ease swelling and itching.\n");

        mDatas.add("1.\tApply warm water and soap to flush out the abrasion.\n2.\tIf the splinter remains, use a sterilised pair of tweezers to remove it.\n3.\tDo not rush or you may push it in further or leave some of the splinter behind.\n4.\tAfter a day or so, it may come out by itself. In this case, a band-aid in the meantime is the best course of action.\n");

        mDatas.add("1.\tDo not tilt child’s head backwards\n2.\tHave them lean forward while you pinch their nostrils closed continuously, for five to 10 minutes, while the bleeding stops.\n3.\tIf the nosebleed is a result of trauma, an ice pack against the bridge of the nose may assist with swelling reduction.\n");

        mDatas.add("1.\tHold the burned area under cool, running water, immediately.\n2.\tMake sure any small blisters are covered with a loose band-aid or plaster.\n3.\tDo not pop or otherwise damage the area in any way.\n4.\tAnti-biotic cream can be applied to ease and fasten healing.\n");
    }

    private void back(){
        Button btn_back = (Button) findViewById(R.id. back_button_emergency_information);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(emergency_information.this, Navigation_page.class);
                startActivity(intent1);
            }
        });
    }

    private class getEmergencyInfor extends AsyncTask<Void,Void,String> {

        @Override
        protected void onPreExecute(){
            setDialog();
        }

        @Override
        protected String doInBackground(Void...Void) {
            return callingAWSWS.getGeneral_Emergency_Aid();
        }

        @Override
        protected void onPostExecute(String response) {

            String information="";

            try {
                JSONArray arr = new JSONArray(response);
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject temp = (JSONObject) arr.get(i);

                   information+=temp.getString("fai_text");
                }
            }catch (JSONException e) {
                e.printStackTrace();
            }

            mDatas.add(information);

            //set recycler adapter and layout manager
            recyclerView = (RecyclerView)findViewById(R.id.emergency_infor_list);

            recycleAdapter= new emergency_adapter(emergency_information.this,mDatas);

            LinearLayoutManager layoutManager = new LinearLayoutManager(emergency_information.this);

            recyclerView.setLayoutManager(layoutManager);

            layoutManager.setOrientation(RecyclerView.VERTICAL);

            recyclerView.setAdapter(recycleAdapter);

        }

    }
    //dialog
    public void setDialog(){
        //spot dialog
        SpotsDialog.Builder builder1 = new SpotsDialog.Builder();

        //building complete
        SpotsDialog alert11 = (SpotsDialog) builder1.setContext(this).build();

        builder1.setCancelable(true);
        alert11.setCanceledOnTouchOutside(true);

        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                alert11.dismiss();
                t.cancel();
            }
        }, 2000);

        alert11.show();
    }
}
