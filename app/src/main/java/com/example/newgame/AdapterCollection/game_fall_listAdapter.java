package com.example.newgame.AdapterCollection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
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
import com.example.newgame.customViewCollection.custom_toast;
import com.example.newgame.gamepage;
import com.example.newgame.quiz_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class game_fall_listAdapter extends RecyclerView.Adapter<game_fall_listAdapter.MyViewHolder>{

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;
    private RecyclerView mrecyclerView;

    private SoundPool soundPool1;
    private SoundPool soundPool2;
    private int soundID;
    private int soundIDwrong;

    private boolean rightAnswer;
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

    ArrayList<Integer> rightList = new ArrayList<>();
    ArrayList<Integer> WrongList = new ArrayList<>();

    private String message;

    public game_fall_listAdapter(Context context, List<String> datas,RecyclerView recyclerView) {
        this.mContext = context;
        this.mDatas = datas;
        this.mrecyclerView = recyclerView;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(game_fall_listAdapter.MyViewHolder holder, final int position) {

        //init the image
        Drawable Drawable1 = mContext.getResources().getDrawable(R.drawable.fall_quiz_pic);
        holder.imageView.setImageDrawable(Drawable1);

        //initiate the right sound source
        initSound(mContext);

        //initiate the wrong sound source
        initSoundwrong(mContext);

        holder.step_btn.setVisibility(View.INVISIBLE);
        holder.step_btn.setClickable(false);

        if(position==0){
            holder.textView.setText("What kind of playground surfaces are less likely to cause severe injury?");

            holder.btn_a.setText("Synthetic turf, Sand and wood chips");//R
            holder.btn_b.setText("Concrete surfaces");
            holder.btn_c.setText("Brick surfaces");
            holder.btn_d.setText("All of the above-mentioned surfaces");
        }else if(position==1){
            holder.textView.setText("What are things that are not allowed while playing on the playground?");

            holder.btn_a.setText("Shoving (i.e. pushing someone or something roughly)");
            holder.btn_b.setText("Pushing");
            holder.btn_c.setText("crowding (i.e. moving close to someone)");
            holder.btn_d.setText("All of the above");//R
        }else if(position==2){
            holder.textView.setText("In which weather condition we should not use the playground equipment?");

            holder.btn_a.setText("Sunny and when the playground equipment is dry");
            holder.btn_b.setText("Rainy and when the playground equipment is Wet and slippery");//R
            holder.btn_c.setText("Does not matter, we can use the equipment all the time.");
            holder.btn_d.setText("All are right");
        }else if(position==3){
            holder.textView.setText("You should not use the playground equipment when it is in _______?");

            holder.btn_a.setText("Proper condition");
            holder.btn_b.setText("Any condition ");
            holder.btn_c.setText("Looks good condition");
            holder.btn_d.setText("Broken Condition");//R
        }else if(position==4){
            holder.textView.setText("What is not allowed for playing on the slide equipment?");

            holder.btn_a.setText("Always climb using the ladder");
            holder.btn_b.setText("Always Slide from the front side");
            holder.btn_c.setText("Always what you like");
            holder.btn_d.setText("Always climb up from the front side");//R
        }else if(position==5){
            holder.textView.setText("What is not allowed for playing on the swing equipment?");

            holder.btn_a.setText("Always sit and swing");
            holder.btn_b.setText("Always walk in front of the swing when someone is swinging");//R
            holder.btn_c.setText("Always stand while swinging and jump off from the swing");
            holder.btn_d.setText("All of the above");
        }else if(position==6){
            holder.textView.setText("What are the most common rules for a Geometric Dome equipment?");

            holder.btn_a.setText("Children should have at least three body parts in contact with the dome at all times, such as two arms and one leg.");
            holder.btn_b.setText("Children should not jump off the dome");
            holder.btn_c.setText("Children should not play on the surface under the dome");
            holder.btn_d.setText("All of the above");//R
        }else if(position==7){
            holder.textView.setText("What are the most common rules for a See-saw equipment?");

            holder.btn_a.setText("Children should always sit facing each other on the see-saw");
            holder.btn_b.setText("Always hold tightly with both hands when using the see-saw");
            holder.btn_c.setText("Do not touch the ground or push off with your hands on the see-saw");
            holder.btn_d.setText("All of the above");//R
        }else if(position==8){
            holder.textView.setText("Is it necessary for a child to always go along with any elderly family member to the playground?");

            holder.btn_a.setText("Yes");//R
            holder.btn_b.setText("No");
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==9){
            holder.textView.setText("Is it ok? If I wore a neck chain while I am playing on the playground equipment?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==10){
            holder.textView.setText("Can I stand on the swing instead of sitting on it, while swinging on it? Is it ok?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==11){
            holder.textView.setText("Is it ok? If I leave my bag near the equipment and quickly start playing on the equipment?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==12){
            holder.textView.setText("Is it ok? If I hang upside down from the bars of Climbers equipment?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }else if(position==13) {
            holder.textView.setText("When I was playing on the Merry-Go-Round, my friends started going back to their home. I want to go along with them. Is it ok if I get off the Merry-Go-Round when it is moving?");

            holder.btn_a.setText("Yes");
            holder.btn_b.setText("No");//R
            holder.btn_c.setAlpha((float)0);
            holder.btn_d.setAlpha((float)0);
        }

        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(position==0){
                    switch (checkedId){
                        case R.id.radio_fall_a:
                            rightAnswer = true;
                            break;
                        default:
                            rightAnswer = false;
                            break;
                    }

                    if(rightAnswer){
                        rightList.add(1);

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
                        WrongList.add(1);

                        playSound(soundIDwrong,soundPool2);

                        message = "The right answer is: Synthetic turf, Sand and wood chips";
                        reportdialog(mContext,message,1);
                    }

                }else if(position==1){
                    switch (checkedId){
                        case R.id.radio_fall_d:
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

                        message = "The right answer is: All of the above";
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

                        message = "The right answer is: Rainy and when the playground equipment is Wet and slippery";
                        reportdialog(mContext,message,3);
                    }

                }else if(position==3){
                    switch (checkedId){
                        case R.id.radio_fall_d:
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

                        message = "The right answer is: Broken Condition";
                        reportdialog(mContext,message,4);
                    }

                }else if(position==4){
                    switch (checkedId){
                        case R.id.radio_fall_d:
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

                        message = "The right answer is: Always climb up from the front side";
                        reportdialog(mContext,message,5);
                    }

                }else if(position==5){
                    switch (checkedId){
                        case R.id.radio_fall_b:
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

                        message = "The right answer is: Always walk in front of the swing when someone is swinging";
                        reportdialog(mContext,message,6);
                    }

                }else if(position==6){
                    switch (checkedId){
                        case R.id.radio_fall_d:
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

                        message = "The right answer is: All of the above";
                        reportdialog(mContext,message,7);
                    }

                }else if(position==7){
                    switch (checkedId){
                        case R.id.radio_fall_d:
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

                        message = "The right answer is: All of the above";
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

                        message = "The right answer is: Yes";
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
                        case R.id.radio_fall_b:
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

                        message = "The right answer is: NO";
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
                    }else {
                        playSound(soundIDwrong,soundPool2);
                        WrongList.add(rightAnswer13);
                    }

                    message = "Finish\n"+"Right answer: "+rightList.size()+"\n"+"Wrong answer: "+WrongList.size();

                    holder.step_btn.setVisibility(View.VISIBLE);
                    holder.step_btn.setClickable(true);
                    holder.step_btn.setText("Finish!");

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
    public game_fall_listAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.quiz_item_frame,parent, false);
        game_fall_listAdapter.MyViewHolder holder= new game_fall_listAdapter.MyViewHolder(view);
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

            imageView = view.findViewById(R.id.quiz_theme_image);
            textView = view.findViewById(R.id.quiz_fall_text);
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
                    Intent intent = new Intent(mContext.getApplicationContext(),gamepage.class);
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
