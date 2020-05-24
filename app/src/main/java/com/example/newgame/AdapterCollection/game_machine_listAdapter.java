package com.example.newgame.AdapterCollection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgame.R;
import com.example.newgame.gamepage;

import java.util.ArrayList;
import java.util.List;

public class game_machine_listAdapter extends RecyclerView.Adapter<game_machine_listAdapter.MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    private RecyclerView mrecyclerView;
    private SoundPool soundPool1;
    private SoundPool soundPool2;
    private int soundID;
    private int soundIDwrong;

    private int rightAnswer;
    private int rightAnswer1;
    private int rightAnswer2;
    private int rightAnswer3;
    private int rightAnswer4;
    private int rightAnswer5;
    private int rightAnswer6;
    private int rightAnswer7;
    private int rightAnswer8;
    private int rightAnswer9;
    private int rightAnswer10;
    private int rightAnswer11;
    private int rightAnswer12;
    private int rightAnswer13;
    private int rightAnswer14;
    private int rightAnswer15;

    ArrayList<Integer> rightList = new ArrayList<>();
    ArrayList<Integer> WrongList = new ArrayList<>();

    private String message;

    public game_machine_listAdapter(Context context, List<String> datas,RecyclerView recyclerView) {
        this.mContext = context;
        this.mDatas = datas;
        this.mrecyclerView = recyclerView;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(game_machine_listAdapter.MyViewHolder holder, final int position) {

        initSound(mContext);
        initSoundwrong(mContext);

        //init the image
        Drawable Drawable1 = mContext.getResources().getDrawable(R.drawable.machine_quiz_pic);
        holder.imageView.setImageDrawable(Drawable1);

        holder.step_btn.setVisibility(View.INVISIBLE);
        holder.step_btn.setClickable(false);

        if(position==0){
            holder.textView.setText("If I am under 16 years old, can I operate a quad bike?");

            holder.btn_a.setText("Yes, as long as I know how to use it.");
            holder.btn_b.setText("No, it's important to recognise that children lack the body weight, strength and judgement to handle a full-sized vehicle. Children under the age of 16 are not permitted to operate an adult quad bike.");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==1){
            holder.textView.setText("I’m so excited that I could go to visit the farm and I can’t wait to try the farm machinery I never used, it’s so cool. Is it right?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==2){
            holder.textView.setText("I’m 14 years old, the younger children are more vulnerable than I am on the farm?");

            holder.btn_a.setText("Yes, I have more flexibility and strength than younger children");
            holder.btn_b.setText("No, For non-fatal injury of children on farms, older children (5 - 14 years) figure more prominently - particularly in relation to injury from 2 and 4 wheeled motorbikes (and horses).");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==3){
            holder.textView.setText("Which one has a high probability of injury, quad bikes and motorbikes?");

            holder.btn_a.setText("Quad bikes");
            holder.btn_b.setText("Motorbikes");
            holder.btn_c.setText("Both of them are dangerous, but four times as many children being injured riding quad bikes than 2 wheel motorbikes on farms");//R
            holder.btn_d.setText("They have same probability");
        }else if(position==4){
            holder.textView.setText("I have a master farmer grandfather who has many years farming practice experience, can I ask him to carry me on quads?");

            holder.btn_a.setText("Yes, my grandfather could ensure my safety");
            holder.btn_b.setText("No, do not carry any passengers on the quad");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==5){
            holder.textView.setText("If I want to ride a bike or horse, which following items should I wear?");

            holder.btn_a.setText("Helmets");//R
            holder.btn_b.setText("Hat");
            holder.btn_c.setText("Gloves");
            holder.btn_d.setText("Bright Coat");
        }else if(position==6){
            holder.textView.setText("It’s so cool to take a photo with that heavy huge farming machinery, can I do that?");

            holder.btn_a.setText("Yes, as long as under adult supervision");
            holder.btn_b.setText("No, preventing children from lifting heavy items.");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==7){
            holder.textView.setText("Is it totally safe if I ride a children bike?");

            holder.btn_a.setText("Yes, the children bike is designed for children and it can make sure my safety on the road.");
            holder.btn_b.setText("Not totally safe");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==8){
            holder.textView.setText("Is there a speed limit when I ride a quad on a farm if I am older than 17?");

            holder.btn_a.setText("Yes.Set speed limits and establish ‘no go’ areas on the farm, such as hills and slopes, dam banks or anywhere the quad is at higher risk of roll");//R
            holder.btn_b.setText("No, no speed limit as long as in a rural area where there’s no one ");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==9){
            holder.textView.setText("My parents are doing farm work, they give me a phone and tell me “don’t run everywhere, I will be back soon” is it right?");

            holder.btn_a.setText("Yes, I have a phone to play and my parents don’t need to take care of me.");
            holder.btn_b.setText("No, creating a safe play area, especially for younger children such as a securely fenced house yard to define boundaries between safe and unsafe areas");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==10){
            holder.textView.setText("I want to learn how to use farm machinery, and I plan to ask my grandfather who has many years of farming experience, is it ok?");

            holder.btn_a.setText("Yes, he has many years actual farming experience.");
            holder.btn_b.setText("No, use a trainer from a Registered Training Organisation, who can train to develop the skills necessary for rural production and issue a Certificate of Competency. Make sure that you keep a note of all training provided.");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==11){
            holder.textView.setText("If the key on the quad bike or the doors is open, can I go to try the quad?");

            holder.btn_a.setText("Yes, as long as I wear helmet");
            holder.btn_b.setText("No, adults should keep doors shut or locked, and removing the keys, so children cannot access unsafe areas");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==12){
            holder.textView.setText("Children can only be employed to perform light work including not being harmful to a child's health safety and welfare; does not affect a child's ability to attend school. Is it right?");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==13){
            holder.textView.setText("When my father cleans the grass in the yard, my older brother and I help my father to gather the weeds into a heap. Is it right?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==14) {
            holder.textView.setText("When I do some light work on a farm, I should wear fitting clothing, clothes with strings, tie back long hair, is it right?");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float) 0);
            holder.btn_d.setAlpha((float) 0);
        }else if(position==15){
            holder.textView.setText("I should change my clothes with the different weather when I do some light jobs on the farm. Which one of the following options is right?");

            holder.btn_a.setText("Hot weather: lightweight, light colored; Cold weather: layers of warm clothes and outerwear, hat, gloves and boots");//R
            holder.btn_b.setText("Hot weather: layers of warm clothes and outerwear, hat, gloves and boots; Cold weather:  lightweight, light colored");
            holder.btn_c.setAlpha((float) 0);
            holder.btn_d.setAlpha((float) 0);
        }

        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(position==0){
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer = 0;
                            break;
                        default:
                            rightAnswer = 1;
                            break;
                    }

                    if(rightAnswer==0){
                        rightList.add(rightAnswer);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(1);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: No, it's important to recognise that children lack the body weight, strength and judgement to handle a full-sized vehicle. Children under the age of 16 are not permitted to operate an adult quad bike.";
                        reportdialog(mContext,message,1);
                    }

                }else if(position==1){
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer1 = 0;
                            break;
                        default:
                            rightAnswer1 = 1;
                            break;
                    }

                    if(rightAnswer1==0){
                        rightList.add(rightAnswer1);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(2);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer1);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO";
                        reportdialog(mContext,message,2);
                    }

                }else if(position==2){
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer2 = 0;
                            break;
                        default:
                            rightAnswer2 = 1;
                            break;
                    }

                    if(rightAnswer2==0){
                        rightList.add(rightAnswer2);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(3);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer2);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: No";
                        reportdialog(mContext,message,3);
                    }

                }else if(position==3){
                    switch (checkedId){
                        case R.id.radio_fall_c:
                            rightAnswer3 = 0;
                            break;
                        default:
                            rightAnswer3 = 1;
                            break;
                    }

                    if(rightAnswer3==0){
                        rightList.add(rightAnswer3);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(4);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer3);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Both of them are dangerous, but four times as many children being injured riding quad bikes than 2 wheel motorbikes on farms";
                        reportdialog(mContext,message,4);
                    }

                }else if(position==4){
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer4 = 0;
                            break;
                        default:
                            rightAnswer4 = 1;
                            break;
                    }

                    if(rightAnswer4==0){
                        rightList.add(rightAnswer4);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(5);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer4);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: No, do not carry any passengers on the quad";
                        reportdialog(mContext,message,5);
                    }

                }else if(position==5){
                    switch (checkedId){
                        case R.id.radio_fall_a:
                            rightAnswer5 = 0;
                            break;
                        default:
                            rightAnswer5 = 1;
                            break;
                    }

                    if(rightAnswer5==0){
                        rightList.add(rightAnswer5);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(6);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer5);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Helmets";
                        reportdialog(mContext,message,6);
                    }

                }else if(position==6){
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer6 = 0;
                            break;
                        default:
                            rightAnswer6 = 1;
                            break;
                    }

                    if(rightAnswer6==0){
                        rightList.add(rightAnswer6);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(7);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer6);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: No";
                        reportdialog(mContext,message,7);
                    }

                }else if(position==7){
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer7 = 0;
                            break;
                        default:
                            rightAnswer7 = 1;
                            break;
                    }

                    if(rightAnswer7==0){
                        rightList.add(rightAnswer7);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(8);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer7);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Not totally safe";
                        reportdialog(mContext,message,8);
                    }

                }else if(position==8){
                    switch (checkedId){
                        case R.id.radio_fall_a:
                            rightAnswer8 = 0;
                            break;
                        default:
                            rightAnswer8 = 1;
                            break;
                    }

                    if(rightAnswer8==0){
                        rightList.add(rightAnswer8);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(9);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer8);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Yes.Set speed limits and establish ‘no go’ areas on the farm, such as hills and slopes, dam banks or anywhere the quad is at higher risk of roll";
                        reportdialog(mContext,message,9);
                    }

                }else if(position==9){
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer9 = 0;
                            break;
                        default:
                            rightAnswer9 = 1;
                            break;
                    }

                    if(rightAnswer9==0){
                        rightList.add(rightAnswer9);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(10);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer9);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO";
                        reportdialog(mContext,message,10);
                    }

                }else if(position==10){
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer10 = 0;
                            break;
                        default:
                            rightAnswer10 = 1;
                            break;
                    }

                    if(rightAnswer10==0){
                        rightList.add(rightAnswer10);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(11);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer10);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO";
                        reportdialog(mContext,message,11);
                    }

                }else if(position==11){
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer11 = 0;
                            break;
                        default:
                            rightAnswer11 = 1;
                            break;
                    }

                    if(rightAnswer11==0){
                        rightList.add(rightAnswer11);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(12);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer11);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO";
                        reportdialog(mContext,message,12);
                    }

                }else if(position==12){
                    switch (checkedId){
                        case R.id.radio_fall_a:
                            rightAnswer12 = 0;
                            break;
                        default:
                            rightAnswer12 = 1;
                            break;
                    }

                    if(rightAnswer12==0){
                        rightList.add(rightAnswer12);

                        playSound(soundID,soundPool1);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(13);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer12);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: YES";
                        reportdialog(mContext,message,13);
                    }

                }else if(position==13) {
                    switch (checkedId){
                        case R.id.radio_fall_b:
                            rightAnswer13 = 0;
                            break;
                        default:
                            rightAnswer13 = 1;
                            break;
                    }

                    if(rightAnswer13==0){
                        playSound(soundID,soundPool1);
                        rightList.add(rightAnswer13);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(14);
                            }
                        });
                    }else {
                        playSound(soundIDwrong,soundPool2);
                        WrongList.add(rightAnswer13);

                        message = "The right answer is: YES";
                        reportdialog(mContext,message,14);
                    }

                }else if(position==14){
                    switch (checkedId){
                        case R.id.radio_fall_a:
                            rightAnswer14 = 0;
                            break;
                        default:
                            rightAnswer14 = 1;
                            break;
                    }

                    if(rightAnswer14==0){
                        playSound(soundID,soundPool1);
                        rightList.add(rightAnswer14);

                        holder.step_btn.setVisibility(View.VISIBLE);
                        holder.step_btn.setClickable(true);

                        holder.step_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                move(15);
                            }
                        });
                    }else {
                        playSound(soundIDwrong,soundPool2);
                        WrongList.add(rightAnswer14);

                        message = "The right answer is: YES";
                        reportdialog(mContext,message,15);
                    }
                }else if(position==15){
                    switch (checkedId){
                        case R.id.radio_fall_a:
                            rightAnswer15 = 0;
                            break;
                        default:
                            rightAnswer15 = 1;
                            break;
                    }

                    if(rightAnswer15==0){
                        playSound(soundID,soundPool1);
                        rightList.add(rightAnswer15);
                    }else {
                        playSound(soundIDwrong,soundPool2);
                        WrongList.add(rightAnswer15);
                    }

                    holder.step_btn.setVisibility(View.VISIBLE);
                    holder.step_btn.setClickable(true);
                    holder.step_btn.setTextSize(16);
                    holder.step_btn.setText("Finish!");

                    message = "Finish\n"+"Right answer: "+rightList.size()+"\n"+"Wrong answer: "+WrongList.size();

                    holder.step_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            reportdialog1(mContext,message);
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public game_machine_listAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.quiz_item_frame,parent, false);
        game_machine_listAdapter.MyViewHolder holder= new game_machine_listAdapter.MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        RadioGroup radioGroup;

        RadioButton btn_a;
        RadioButton btn_b;
        RadioButton btn_c;
        RadioButton btn_d;

        Button step_btn;

        public MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.quiz_fall_text);
            imageView = view.findViewById(R.id.quiz_theme_image);
            radioGroup = view.findViewById(R.id.radio_group_fall);

            btn_a = view.findViewById(R.id.radio_fall_a);
            btn_b = view.findViewById(R.id.radio_fall_b);
            btn_c = view.findViewById(R.id.radio_fall_c);
            btn_d = view.findViewById(R.id.radio_fall_d);

            step_btn = view.findViewById(R.id.step_button_quiz1);
        }
    }

    public void move(int n){
        mrecyclerView.smoothScrollToPosition(n);
    }

    public void reportdialog(Context mContext,String message,int Step){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
        builder1.setMessage("Good job! New eagle!");
        builder1.setCancelable(true);

        builder1.setTitle("Quiz report!");
        builder1.setIcon(R.drawable.alert_icon);

        //set the view for the dialog
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_custome_dialog,null);

        //insert the quiz page into dialog
        builder1.setView(v);

        //building complete
        AlertDialog alert11 = builder1.create();

        //initialise the start button
        Button btn_cancel = (Button) v.findViewById(R.id.cancel_button);

        btn_cancel.setText("Next!");

        //quit the dialog
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Step==110){
                    alert11.dismiss();
                    Intent intent = new Intent(mContext.getApplicationContext(), gamepage.class);
                    mContext.startActivity(intent);
                }else {
                    alert11.dismiss();
                    move(Step);
                }
            }
        });

        //initialise the text view
        TextView textView = (TextView) v.findViewById(R.id.welcome_text);
        textView.setText(message);

        Drawable drawable = v.getResources().getDrawable(R.drawable.thumb_down);
        ImageView imageView = (ImageView) v.findViewById(R.id.dialog_image);
        imageView.setImageDrawable(drawable);
        //show the dialog
        alert11.show();
    }

    public void reportdialog1(Context mContext,String message){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
        builder1.setMessage("Good job! New eagle!");
        builder1.setCancelable(true);

        builder1.setTitle("Quiz report!");
        builder1.setIcon(R.drawable.alert_icon);

        //set the view for the dialog
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_custome_dialog,null);

        //insert the quiz page into dialog
        builder1.setView(v);

        //building complete
        AlertDialog alert11 = builder1.create();

        //initialise the start button
        Button btn_cancel = (Button) v.findViewById(R.id.cancel_button);

        btn_cancel.setText("Finish!");

        //quit the dialog
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert11.dismiss();
                Intent intent = new Intent(mContext.getApplicationContext(),gamepage.class);
                mContext.startActivity(intent);

            }
        });

        //initialise the text view
        TextView textView = (TextView) v.findViewById(R.id.welcome_text);
        textView.setText(message);

        Drawable drawable = v.getResources().getDrawable(R.drawable.thumb_up_pic);
        ImageView imageView = (ImageView) v.findViewById(R.id.dialog_image);
        imageView.setImageDrawable(drawable);

        //show the dialog
        alert11.show();
    }

    @SuppressLint("NewApi")
    private void initSound(Context mContext) {
        soundPool1 = new SoundPool.Builder().build();
        soundID = soundPool1.load(mContext, R.raw.right_answer, 1);
    }

    @SuppressLint("NewApi")
    private void initSoundwrong(Context mContext) {
        soundPool2 = new SoundPool.Builder().build();
        soundIDwrong = soundPool2.load(mContext, R.raw.wrong_answer, 1);
    }

    private void playSound(int soundID,SoundPool soundPool) {
        soundPool.play(
                soundID,
                1.0f,
                1.0f,
                0,
                0,
                1
        );
    }
}
