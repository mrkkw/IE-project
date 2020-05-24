package com.example.newgame.AdapterCollection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgame.Database.DatabaseHelper;
import com.example.newgame.R;
import com.example.newgame.customViewCollection.custom_toast;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.List;

public class knowledge_base_transportpageAdapter extends RecyclerView.Adapter<knowledge_base_transportpageAdapter.MyViewHolder>{

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public knowledge_base_transportpageAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(knowledge_base_transportpageAdapter.MyViewHolder holder, final int position) {

        DatabaseHelper dbHelper = new DatabaseHelper(mContext, "fav_db",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        custom_toast ct =  new custom_toast();

        //test whether liked by the user
        List<String> xx = new ArrayList<String>();
        List<String> test = new ArrayList<String>();

        for(int index = 0;index<queryAllTips().size();index++){
            if(!xx.contains(queryAllTips().get(index))){
                xx.add(queryAllTips().get(index));
            }
        }

        test = xx;

        holder.likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {

                ct.showToast(mContext,"Tip added!");

                ContentValues values = new ContentValues();
                values.put("Tips",holder.textView.getText().toString());

                db.insert("favourite", null, values);
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                likeButton.setLiked(true);
                ct.showToast(mContext,"Tip havs been added!");
            }
        });

        holder.textView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    holder.textView1.setAlpha((float) 0.5);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    holder.textView1.setAlpha(1);
                }
                return false;
            }
        });

        if(position==0){
            holder.textView.setText(setText("Car accidents often occur, especially in the intersection"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Car accidents often occur, especially in the intersection",1);
                }
            });

            if(test.contains("Car accidents often occur, especially in the intersection")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==1){
            holder.textView.setText(setText("Driving a car on the regional area road, the limit speed is 100, otherwise the driver and passengers will be injured"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Driving a car on the regional area road, the limit speed is 100, otherwise the driver and passengers will be injured",2);
                }
            });

            if(test.contains("Driving a car on the regional area road, the limit speed is 100, otherwise the driver and passengers will be injured")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==2){
            holder.textView.setText(setText("50 kms per hour is the default speed limit while driving on a road where there is no speed limit sign present"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("50 kms per hour is the default speed limit while driving on a road where there is no speed limit sign present",3);
                }
            });

            if(test.contains("50 kms per hour is the default speed limit while driving on a road where there is no speed limit sign present")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==3){
            holder.textView.setText(setText("Seat belt is the most important thing I must wear when riding in a car"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Seat belt is the most important thing I must wear when riding in a car",4);
                }
            });

            if(test.contains("Seat belt is the most important thing I must wear when riding in a car")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==4){
            holder.textView.setText(setText("I can't sit on my parent’s lap and share their safety belt while they are driving"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I can't sit on my parent’s lap and share their safety belt while they are driving",5);
                }
            });

            if(test.contains("I can't sit on my parent’s lap and share their safety belt while they are driving")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==5){
            holder.textView.setText(setText("I can't use my mobile phone while driving"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I can't use my mobile phone while driving",6);
                }
            });

            if(test.contains("I can't use my mobile phone while driving")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==6){
            holder.textView.setText(setText("Between 10pm and 6am is more likely to have crashes for young drivers"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Between 10pm and 6am is more likely to have crashes for young drivers",7);
                }
            });

            if(test.contains("Between 10pm and 6am is more likely to have crashes for young drivers")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==7){
            holder.textView.setText(setText("It totally isn't safe if you ride a children bike"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("It totally isn't safe if you ride a children bike",8);
                }
            });

            if(test.contains("It totally isn't safe if you ride a children bike")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==8){
            holder.textView.setText(setText("It is dangerous for me to turn the radio all the way up while driving"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("It is dangerous for me to turn the radio all the way up while driving", 9);
                }
            });

            if(test.contains("It is dangerous for me to turn the radio all the way up while driving")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==9){
            holder.textView.setText(setText("I should say \"No, it’s too hot in the car\" when the outside temperature is 35 degrees and my parents left me alone in the car and said “Just stay here,I will be back about 15 minutes"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I should say \"No, it’s too hot in the car\" when the outside temperature is 35 degrees and my parents left me alone in the car and said “Just stay here,I will be back about 15 minutes",10);
                }
            });

            if(test.contains("I should say \"No, it’s too hot in the car\" when the outside temperature is 35 degrees and my parents left me alone in the car and said “Just stay here,I will be back about 15 minutes")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==10){
            holder.textView.setText(setText("I’m 7 years old. Our family plans to go on a road trip, i can't sit in the front seat"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I’m 7 years old. Our family plans to go on a road trip, i can't sit in the front seat",11);
                }
            });

            if(test.contains("I’m 7 years old. Our family plans to go on a road trip, i can't sit in the front seat")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==11){
            holder.textView.setText(setText("In order to avoid hazards when I ride on the street, I should wear bright-colored clothes such as colour yellow"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("In order to avoid hazards when I ride on the street, I should wear bright-colored clothes such as colour yellow",12);
                }
            });

            if(test.contains("In order to avoid hazards when I ride on the street, I should wear bright-colored clothes such as colour yellow")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==12){
            holder.textView.setText(setText("When riding a bike, it is important for people in front of you to know you are there using bell"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("When riding a bike, it is important for people in front of you to know you are there using bell",13);
                }
            });

            if(test.contains("When riding a bike, it is important for people in front of you to know you are there using bell")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==13){
            holder.textView.setText(setText("Helmet, wrist guards and knee pads are the three basic protective gears that you should use when riding a bike"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Helmet, wrist guards and knee pads are the three basic protective gears that you should use when riding a bike",14);
                }
            });

            if(test.contains("Helmet, wrist guards and knee pads are the three basic protective gears that you should use when riding a bike")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==14){
            holder.textView.setText(setText("It isn't ok to wear damaged protective gears such as a helmet while riding a bike"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("It isn't ok to wear damaged protective gears such as a helmet while riding a bike",16);
                }
            });

            if(test.contains("It isn't ok to wear damaged protective gears such as a helmet while riding a bike")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==15){
            holder.textView.setText(setText("I can't ride my brothers’ bike in my free time as he does not use it much"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I can't ride my brothers’ bike in my free time as he does not use it much",16);
                }
            });

            if(test.contains("I can't ride my brothers’ bike in my free time as he does not use it much")){
                holder.likeButton.setLiked(true);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public knowledge_base_transportpageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.knowledgebase_item_list_frame,parent, false);
        knowledge_base_transportpageAdapter.MyViewHolder holder= new knowledge_base_transportpageAdapter.MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        TextView textView1;
        LikeButton likeButton;

        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.KB_item_image);
            textView = view.findViewById(R.id.KB_item_text);
            textView1 = view.findViewById(R.id.KB_item_explore_text);
            likeButton = view.findViewById(R.id.star_button);
        }
    }

    private String setText(String text){

        //set the display content
        String sub = text.substring(0,text.length()/2);

        sub += "\n.....\nClick expand for more details!";

        return sub;
    }

    //dialog
    public void showDialog(String message, int title){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);

        builder1.setCancelable(true);

        String title_tip = "Tip"+title;

        builder1.setTitle(title_tip);

        builder1.setIcon(R.drawable.alert_icon);

        builder1.setMessage(message);

        //building complete
        AlertDialog alert11 = builder1.create();

        alert11.setCanceledOnTouchOutside(true);

        //show the dialog
        alert11.show();
    }

    public List<String> queryAllTips(){

        DatabaseHelper dbHelper = new DatabaseHelper(mContext, "fav_db",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query("favourite",null,null,null,null,null,null,null);
        List<String> Tips = new ArrayList<>();
        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {

                String tips = cursor.getString(cursor.getColumnIndex("Tips"));

                Tips.add(tips);

                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return Tips;
    }
}
