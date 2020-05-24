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

public class knowledge_base_machinepageAdapter extends RecyclerView.Adapter<knowledge_base_machinepageAdapter.MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public knowledge_base_machinepageAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(knowledge_base_machinepageAdapter.MyViewHolder holder, final int position) {

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
            holder.textView.setText(setText("I am under 16 years old, i can't operate a quad bike"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I am under 16 years old, i can't operate a quad bike",1);
                }
            });

            if(test.contains("I am under 16 years old, i can't operate a quad bike")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==1){
            holder.textView.setText(setText("I can’t try the farm machinery I never used"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I can’t try the farm machinery I never used",2);
                }
            });

            if(test.contains("I can’t try the farm machinery I never used")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==2){
            holder.textView.setText(setText("I’m 14 years old, not the younger children who are more vulnerable than I am on the farm"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I’m 14 years old, not the younger children who are more vulnerable than I am on the farm",3);
                }
            });

            if(test.contains("I’m 14 years old, not the younger children who are more vulnerable than I am on the farm")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==3){
            holder.textView.setText(setText("Quad bikes and Motorbikes both have a high probability of injury"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Quad bikes and Motorbikes both have a high probability of injury",4);
                }
            });

            if(test.contains("Quad bikes and Motorbikes both have a high probability of injury")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==4){
            holder.textView.setText(setText("I can't ask other people to carry me on quads"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I can't ask other people to carry me on quads",5);
                }
            });

            if(test.contains("I can't ask other people to carry me on quads")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==5){
            holder.textView.setText(setText("If I want to ride a bike or horse, i should wear a helmet"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("If I want to ride a bike or horse, i should wear a helmet",6);
                }
            });

            if(test.contains("If I want to ride a bike or horse, i should wear a helmet")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==6){
            holder.textView.setText(setText("Preventing children from lifting heavy items"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Preventing children from lifting heavy items",7);
                }
            });

            if(test.contains("Preventing children from lifting heavy items")){
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
            holder.textView.setText(setText("Set speed limits and establish ‘no go’ areas on the farm, such as hills and slopes, dam banks or anywhere the quad is at higher risk of roll"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Set speed limits and establish ‘no go’ areas on the farm, such as hills and slopes, dam banks or anywhere the quad is at higher risk of roll",9);
                }
            });

            if(test.contains("Set speed limits and establish ‘no go’ areas on the farm, such as hills and slopes, dam banks or anywhere the quad is at higher risk of roll")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==9){
            holder.textView.setText(setText("Creating a safe play area, especially for younger children such as a securely fenced house yard to define boundaries between safe and unsafe areas"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Creating a safe play area, especially for younger children such as a securely fenced house yard to define boundaries between safe and unsafe areas",10);
                }
            });

            if(test.contains("Creating a safe play area, especially for younger children such as a securely fenced house yard to define boundaries between safe and unsafe areas")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==10){
            holder.textView.setText(setText("Use a trainer from a Registered Training Organisation, who can train to develop the skills necessary for rural production and issue a Certificate of Competency. Make sure that you keep a note of all training provided"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Use a trainer from a Registered Training Organisation, who can train to develop the skills necessary for rural production and issue a Certificate of Competency. Make sure that you keep a note of all training provided",11);
                }
            });

            if(test.contains("Use a trainer from a Registered Training Organisation, who can train to develop the skills necessary for rural production and issue a Certificate of Competency. Make sure that you keep a note of all training provided")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==11){
            holder.textView.setText(setText("If the key on the quad bike or the doors is open, i can't go to try the quad"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("If the key on the quad bike or the doors is open, i can't go to try the quad",12);
                }
            });

            if(test.contains("If the key on the quad bike or the doors is open, i can't go to try the quad")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==12){
            holder.textView.setText(setText("Children can only be employed to perform light work including not being harmful to a child's health safety and welfare; does not affect a child's ability to attend school"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Children can only be employed to perform light work including not being harmful to a child's health safety and welfare; does not affect a child's ability to attend school",13);
                }
            });

            if(test.contains("Children can only be employed to perform light work including not being harmful to a child's health safety and welfare; does not affect a child's ability to attend school")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==13){
            holder.textView.setText(setText("Hen my father cleans the grass in the yard, my older brother and I can't help my father to gather the weeds into a heap"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Hen my father cleans the grass in the yard, my older brother and I can't help my father to gather the weeds into a heap",14);
                }
            });

            if(test.contains("Hen my father cleans the grass in the yard, my older brother and I can't help my father to gather the weeds into a heap")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==14){
            holder.textView.setText(setText("When I do some light work on a farm, I should wear fitting clothing, clothes with strings, tie back long hair"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("When I do some light work on a farm, I should wear fitting clothing, clothes with strings, tie back long hair",16);
                }
            });

            if(test.contains("When I do some light work on a farm, I should wear fitting clothing, clothes with strings, tie back long hair")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==15){
            holder.textView.setText(setText("I should change my clothes with the different weather when I do some light jobs on the farm"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I should change my clothes with the different weather when I do some light jobs on the farm",16);
                }
            });

            if(test.contains("I should change my clothes with the different weather when I do some light jobs on the farm")){
                holder.likeButton.setLiked(true);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public knowledge_base_machinepageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.knowledgebase_item_list_frame,parent, false);
        knowledge_base_machinepageAdapter.MyViewHolder holder= new knowledge_base_machinepageAdapter.MyViewHolder(view);
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

