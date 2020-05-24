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
import com.example.newgame.knowledge_base_fallpage;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.List;

public class knowledge_base_fallpageAdapter extends RecyclerView.Adapter<knowledge_base_fallpageAdapter.MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public knowledge_base_fallpageAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(knowledge_base_fallpageAdapter.MyViewHolder holder, final int position) {

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

        //like button initiation
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

        //text view1 initiation
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
            holder.textView.setText(setText("Synthetic turf, Sand and wood chips are surfaces less likely to cause severe injury"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Synthetic turf, Sand and wood chips are surfaces less likely to cause severe injury",1);
                }
            });

            if(test.contains("Synthetic turf, Sand and wood chips are surfaces less likely to cause severe injury")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==1){
            holder.textView.setText(setText("Shoving, Pushing and crowding are not allowed while playing on the playground"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Shoving, Pushing and crowding are not allowed while playing on the playground",2);
                }
            });


            if(test.contains("Shoving, Pushing and crowding are not allowed while playing on the playground")){
                holder.likeButton.setLiked(true);
            }

        }else if(position ==2){
            holder.textView.setText(setText("Rainy and when the playground equipment is Wet and slippery that we should not use the playground equipment"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Rainy and when the playground equipment is Wet and slippery that we should not use the playground equipment",3);
                }
            });


            if(test.contains("Rainy and when the playground equipment is Wet and slippery that we should not use the playground equipment")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==3){
            holder.textView.setText(setText("You should not use the playground equipment when it is in Broken ConditionP"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("You should not use the playground equipment when it is in Broken Condition",4);
                }
            });


            if(test.contains("You should not use the playground equipment when it is in Broken ConditionP")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==4){
            holder.textView.setText(setText("Always climb up from the front side is not allowed for playing on the slide equipment"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Always climb up from the front side is not allowed for playing on the slide equipment",5);
                }
            });


            if(test.contains("Always climb up from the front side is not allowed for playing on the slide equipment")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==5){
            holder.textView.setText(setText("Always walk in front of the swing when someone is swinging is not allowed for playing on the swing equipment"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Always walk in front of the swing when someone is swinging is not allowed for playing on the swing equipment",6);
                }
            });


            if(test.contains("Always walk in front of the swing when someone is swinging is not allowed for playing on the swing equipment")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==6){
            holder.textView.setText(setText("Hildren should not play on the surface under the dome, jump off the dome"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Hildren should not play on the surface under the dome, jump off the dome",7);
                }
            });


            if(test.contains("Hildren should not play on the surface under the dome, jump off the dome")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==7){
            holder.textView.setText(setText("Do not touch the ground or push off with your hands on the see-saw"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("Do not touch the ground or push off with your hands on the see-saw",8);
                }
            });


            if(test.contains("Do not touch the ground or push off with your hands on the see-saw")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==8){
            holder.textView.setText(setText("It is necessary for a child to always go along with any elderly family member to the playground"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("It is necessary for a child to always go along with any elderly family member to the playground",9);
                }
            });

            if(test.contains("It is necessary for a child to always go along with any elderly family member to the playground")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==9){
            holder.textView.setText(setText("I should not a neck chain while I am playing on the playground equipment"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I should not a neck chain while I am playing on the playground equipment",10);
                }
            });

            if(test.contains("I should not a neck chain while I am playing on the playground equipment")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==10){
            holder.textView.setText(setText("I can't stand on the swing instead of sitting on it, while swinging on it"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I can't stand on the swing instead of sitting on it, while swinging on it",11);
                }
            });

            if(test.contains("I can't stand on the swing instead of sitting on it, while swinging on it")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==11){
            holder.textView.setText(setText("I should not leave my bag near the equipment and quickly start playing on the equipment"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I should not leave my bag near the equipment and quickly start playing on the equipment",12);
                }
            });

            if(test.contains("I should not leave my bag near the equipment and quickly start playing on the equipment")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==12){
            holder.textView.setText(setText("I can't hang upside down from the bars of Climbers equipment"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I can't hang upside down from the bars of Climbers equipment",13);
                }
            });

            if(test.contains("I can't hang upside down from the bars of Climbers equipment")){
                holder.likeButton.setLiked(true);
            }
        }else if(position ==13){
            holder.textView.setText(setText("I should not get off the Merry-Go-Round when it is moving"));

            holder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog("I should not get off the Merry-Go-Round when it is moving",14);
                }
            });

            if(test.contains("I should not get off the Merry-Go-Round when it is moving")){
                holder.likeButton.setLiked(true);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    @Override
    public knowledge_base_fallpageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.knowledgebase_item_list_frame,parent, false);
        knowledge_base_fallpageAdapter.MyViewHolder holder= new knowledge_base_fallpageAdapter.MyViewHolder(view);
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
