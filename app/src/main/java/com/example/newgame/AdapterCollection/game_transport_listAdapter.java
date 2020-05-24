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

public class game_transport_listAdapter extends RecyclerView.Adapter<game_transport_listAdapter.MyViewHolder>{

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

    ArrayList<Integer> rightList = new ArrayList<>();
    ArrayList<Integer> WrongList = new ArrayList<>();

    private String message;

    public game_transport_listAdapter(Context context, List<String> datas,RecyclerView recyclerView) {
        this.mContext = context;
        this.mDatas = datas;
        this.mrecyclerView = recyclerView;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(game_transport_listAdapter.MyViewHolder holder, final int position) {

        initSound(mContext);
        initSoundwrong(mContext);

        //init the image
        Drawable Drawable1 = mContext.getResources().getDrawable(R.drawable.transport_quiz_pic);
        holder.imageView.setImageDrawable(Drawable1);

        holder.step_btn.setVisibility(View.INVISIBLE);
        holder.step_btn.setClickable(false);

        holder.textView.setText("transport_car");
        if(position==0){
            holder.textView.setText("Car accidents often occur, especially in the intersection.Is it?");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==1){
            holder.textView.setText("Driving a car on the regional area road, the limit speed is 100, otherwise the driver and passengers will be injured.");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==2){
            holder.textView.setText("What will be the default speed limit while driving on a road where there is no speed limit sign present?");

            holder.btn_a.setText("60 kms per hour");
            holder.btn_b.setText("40 kms per hour");
            holder.btn_c.setText("50 kms per hour");//R
            holder.btn_d.setText("70 kms per hour");
        }else if(position==3){
            holder.textView.setText("I could start to study driving after a few months, what is the most important thing I must wear when riding in a car?");

            holder.btn_a.setText("A seatbelt");//R
            holder.btn_b.setText("A watch");
            holder.btn_c.setText("A crown");
            holder.btn_d.setText("Boots");
        }else if(position==4){
            holder.textView.setText("Can I sit on my parent’s lap and share their safety belt while they are driving?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==5){
            holder.textView.setText("While driving can I use my mobile phone.");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==6){
            holder.textView.setText("I will be a young driver after a few months, what time is more likely to have crashes for young drivers?");

            holder.btn_a.setText("At dusk");
            holder.btn_b.setText("Between 10pm and 6am");//R
            holder.btn_c.setText("In the morning when the traffic is heaviest");
            holder.btn_d.setText("After got off work ");
        }else if(position==7){
            holder.textView.setText("I will be a new driver soon, is it dangerous for me to turn the radio all the way up while driving?");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==8){
            holder.textView.setText("I sometimes put my seat belt strap behind my back because it is bothersome to my neck. Is this dangerous?");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==9){
            holder.textView.setText("What should I say or do when the outside temperature is 35 degrees and my parents left me alone in the car and said “Just stay here,I will be back about 15 minutes");

            holder.btn_a.setText("Yeah, whatever");
            holder.btn_b.setText("Ok, lock the door");
            holder.btn_c.setText("No, it’s too hot in the car");//R
            holder.btn_d.setText("bye");
        }else if(position==10){
            holder.textView.setText("When my family was on the way to go to the park, my dog likes to stick his head out the window, I tried to stick my head out the window with my dog, but my mom said “keep your body in the car!”  Why shouldn't I do that?");

            holder.btn_a.setText("If you try to put half or more than half of your body out of the window, you might fall from the window.");
            holder.btn_b.setText("Some dirt from the cars in front of you, can get in your eyes");
            holder.btn_c.setText("If you stick your arm out, you might hit a sign and hurt your arm very badly");
            holder.btn_d.setText("All of these");//R
        }else if(position==11){
            holder.textView.setText("When I go to the farm to visit my grandparents, my parents want to use a safety harness for me, is it ok?");

            holder.btn_a.setText("Yes, it could ensure children's safety.");
            holder.btn_b.setText("No, Using a child safety harness (sometimes called an ‘H harness’) is not recommended");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==12){
            holder.textView.setText("My parents often leave the  loose items in the car and I can pick anyone to play while they are driving. Is it ok to do that?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==13){
            holder.textView.setText("Which side of the car should I get in (or) out of the car, when the car is parked on the busy road or on the main road?");

            holder.btn_a.setText("Always get in and out of the car on the kerbside (or) away from the road.");//R
            holder.btn_b.setText("Always get in and out of the car close to the busy road (or) main road.");
            holder.btn_c.setText("Whatever side you feel to get in and get out of the car.");
            holder.btn_d.setText("All of these are right");
        }else if(position==14){
            holder.textView.setText("I’m 7 years old. Our family plans to go on a road trip, can I sit in the front seat?");

            holder.btn_a.setText("Yes, but not safe.");
            holder.btn_b.setText("No, children aged 7 years and over can travel in the front seat. However, research shows that children under 12 years are much safer travelling in the back seat.");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==15){
            holder.textView.setText("When I ride a bike using a single lane roundabout, which side should I ride in?");

            holder.btn_a.setText("Left");//R
            holder.btn_b.setText("Right");
            holder.btn_c.setText("Middle");
            holder.btn_d.setText("Any one ");
        }else if(position==16){
            holder.textView.setText("Before riding a bike, one of the most important safety measures I should consider is wearing a special piece of equipment over my head to protect myself. What's the name of that?");

            holder.btn_a.setText("Cap");
            holder.btn_b.setText("Helmet");//R
            holder.btn_c.setText("Chiffon");
            holder.btn_d.setText("Sombrero");
        }else if(position==17){
            holder.textView.setText("If I plan to ride a bike on the street, in which of these climates would it be the most inconvenient or dangerous to ride a bike especially if there are tram tracks near my house?");

            holder.btn_a.setText("Clear");
            holder.btn_b.setText("Sunny");
            holder.btn_c.setText("Rainy");//R
            holder.btn_d.setText("Partly cloudy");
        }else if(position==18){
            holder.textView.setText("In order to avoid hazards when I ride on the street, I should wear bright-colored clothes. Which of the following colors is the best to wear?");

            holder.btn_a.setText("Brown");
            holder.btn_b.setText("Blue");
            holder.btn_c.setText("Yellow");//R
            holder.btn_d.setText("Black");
        }else if(position==19){
            holder.textView.setText("When riding on the street (especially at night), you shouldn’t ride on the main road where larger vehicles such as buses and trucks travel at a high speed. In order to avoid drivers unable to see you and prevent hazards, which of these items you should take to help?");

            holder.btn_a.setText("Reflective duct tape");//R
            holder.btn_b.setText("Fountain pen");
            holder.btn_c.setText("Sunglasses");
            holder.btn_d.setText("A dark-colored cap");
        }else if(position==20){
            holder.textView.setText("When riding a bike, it is important for people in front of you to know you are there. Which of these items of the bike could help you?");

            holder.btn_a.setText("Speaker");
            holder.btn_b.setText("Bell");//R
            holder.btn_c.setText("Disinfectant Spray");
            holder.btn_d.setText("Chain");
        }else if(position==21){
            holder.textView.setText("Making turns with a bike incorrectly causes an accident, what should I do if my bike is not fitted with tail light to signal someone behind me while I’m turning?");

            holder.btn_a.setText("Stop abruptly (or) right away before turning");//R
            holder.btn_b.setText("Use hand signal");
            holder.btn_c.setText("Yell the people behind you");
            holder.btn_d.setText("Do nothing");
        }else if(position==22){
            holder.textView.setText("While riding a bike, you should be aware of environmental sounds ranging from nature sounds like animals to car horns. Which of these items would be wise not to wear when riding a bike on a busy road?");

            holder.btn_a.setText("Headphones");//R
            holder.btn_b.setText("Helmet");
            holder.btn_c.setText("Glasses");
            holder.btn_d.setText("Shirt");
        }else if(position==23){
            holder.textView.setText("When riding a bike what are the three basic protective gears that you should use?");

            holder.btn_a.setText("Helmet, wrist guards and knee pads");//R
            holder.btn_b.setText("Glasses, knee pads and Helmet ");
            holder.btn_c.setText("Coat, shoes and wrist guards");
            holder.btn_d.setText("Gloves, glasses and coat");
        }else if(position==24){
            holder.textView.setText("If I’m not older than 12 years old, I have to ride a bike under adult supervision.");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==25){
            holder.textView.setText("I should do some practice riding a bike under my parents' guidance in a safe area like a backyard or a park before heading onto the footpath.");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==26){
            holder.textView.setText("Is it ok to wear damaged protective gears such as a helmet while riding a bike?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==27){
            holder.textView.setText("Can I ride my brothers’ bike in my free time as he does not use it much?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==28){
            holder.textView.setText("I ride my bike on day instead of at night, so I don’t need to use lights, is it right?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==29){
            holder.textView.setText("When riding a bike, it is essential for people in the front and behind you to see you, keep distance and use a bell to prevent accidents, is it right?");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }

        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(position==0){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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

                        message = "The right answer is: Yes";
                        reportdialog(mContext,message,1);
                    }

                }else if(position==1){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(2);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: YES";
                        reportdialog(mContext,message,2);
                    }
                }else if(position==2){
                    switch (checkedId){
                        case R.id.radio_fall_c:
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
                                move(3);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: 50 kms per hour";
                        reportdialog(mContext,message,3);
                    }
                }else if(position==3){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(4);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: A seat belt";
                        reportdialog(mContext,message,4);
                    }
                }else if(position==4){
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
                                move(5);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO";
                        reportdialog(mContext,message,5);
                    }
                }else if(position==5){
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
                                move(6);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO";
                        reportdialog(mContext,message,6);
                    }
                }else if(position==6){
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
                                move(7);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Between 10pm and 6am";
                        reportdialog(mContext,message,7);
                    }
                }else if(position==7){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(8);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: YES";
                        reportdialog(mContext,message,8);
                    }
                }else if(position==8){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(9);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: YES";
                        reportdialog(mContext,message,9);
                    }
                }else if(position==9){
                    switch (checkedId){
                        case R.id.radio_fall_c:
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
                                move(10);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: No, it’s too hot in the car";
                        reportdialog(mContext,message,10);
                    }
                }else if(position==10){
                    switch (checkedId){
                        case R.id.radio_fall_d:
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
                                move(11);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: All of these";
                        reportdialog(mContext,message,11);
                    }
                }else if(position==11){
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
                                move(12);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO";
                        reportdialog(mContext,message,12);
                    }
                }else if(position==12){
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
                                move(13);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO";
                        reportdialog(mContext,message,13);
                    }
                }else if(position==13){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(14);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Always get in and out of the car on the kerbside (or) away from the road.";
                        reportdialog(mContext,message,14);
                    }
                }else if(position==14){
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
                                move(15);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: No.";
                        reportdialog(mContext,message,15);
                    }
                }else if(position==15){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(16);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Left.";
                        reportdialog(mContext,message,16);
                    }
                }else if(position==16){
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
                                move(17);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Helmet.";
                        reportdialog(mContext,message,17);
                    }
                }else if(position==17){
                    switch (checkedId){
                        case R.id.radio_fall_c:
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
                                move(18);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Rainy.";
                        reportdialog(mContext,message,18);
                    }
                }else if(position==18){
                    switch (checkedId){
                        case R.id.radio_fall_c:
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
                                move(19);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Yellow.";
                        reportdialog(mContext,message,19);
                    }
                }else if(position==19){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(20);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Reflective tape.";
                        reportdialog(mContext,message,20);
                    }
                }else if(position==20){
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
                                move(21);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Bell.";
                        reportdialog(mContext,message,21);
                    }
                }else if(position==21){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(22);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Stop abruptly (or) right wawy before turning.";
                        reportdialog(mContext,message,22);
                    }
                }else if(position==22){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(23);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Headphones.";
                        reportdialog(mContext,message,23);
                    }
                }else if(position==23){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(24);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Helmets, wrist guards and knee pads.";
                        reportdialog(mContext,message,24);
                    }
                }else if(position==24){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(25);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Yes.";
                        reportdialog(mContext,message,25);
                    }
                }else if(position==25){
                    switch (checkedId){
                        case R.id.radio_fall_a:
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
                                move(26);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Yes.";
                        reportdialog(mContext,message,26);
                    }
                }else if(position==26){
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
                                move(27);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is:Yes.";
                        reportdialog(mContext,message,27);
                    }
                }else if(position==27){
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
                                move(28);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO.";
                        reportdialog(mContext,message,28);
                    }
                }else if(position==28){
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
                                move(29);
                            }
                        });
                    }else{
                        WrongList.add(rightAnswer);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: NO.";
                        reportdialog(mContext,message,29);
                    }
                }else if(position==29){
                    switch (checkedId){
                        case R.id.radio_fall_a:
                            rightAnswer = 0;
                            break;
                        default:
                            rightAnswer = 1;
                            break;
                    }

                    if(rightAnswer==0){
                        rightList.add(rightAnswer);
                        playSound(soundID,soundPool1);
                    }else{
                        WrongList.add(rightAnswer);
                        playSound(soundIDwrong,soundPool2);
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
    public game_transport_listAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.quiz_item_frame,parent, false);
        game_transport_listAdapter.MyViewHolder holder= new game_transport_listAdapter.MyViewHolder(view);
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
