package com.example.newgame.AdapterCollection;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgame.R;

import java.util.List;

public class statistic_RecyclerAdapter extends RecyclerView.Adapter<statistic_RecyclerAdapter.MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;
    private RecyclerView mrecyclerView;

    public statistic_RecyclerAdapter(Context context, List<String> datas,RecyclerView recyclerView) {
        this.mContext = context;
        this.mDatas = datas;
        this.mrecyclerView = recyclerView;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Drawable Drawable1 = mContext.getResources().getDrawable(R.drawable.statistic_pic1);
        Drawable Drawable2 = mContext.getResources().getDrawable(R.drawable.statistic_pic2);
        Drawable Drawable3 = mContext.getResources().getDrawable(R.drawable.statistic_pic3);
        Drawable Drawable4 = mContext.getResources().getDrawable(R.drawable.statistic_pic4);
        Drawable Drawable5 = mContext.getResources().getDrawable(R.drawable.statistic_pic5);
        Drawable Drawable6 = mContext.getResources().getDrawable(R.drawable.statistic_pic6);
        Drawable Drawable7 = mContext.getResources().getDrawable(R.drawable.statistic_pic7);
        Drawable Drawable8 = mContext.getResources().getDrawable(R.drawable.statistic_pic8);

        Animation alphaAnimation = AnimationUtils.loadAnimation(mContext, R.anim.alpha);

        //set animation for button
        holder.forward.startAnimation(alphaAnimation);
        alphaAnimation.setFillAfter(false);

        holder.back.startAnimation(alphaAnimation);
        alphaAnimation.setFillAfter(false);

        if(position==0){

            holder.statistic_image.setImageDrawable(Drawable1);

            holder.back.setVisibility(View.INVISIBLE);
            holder.back.setClickable(false);

            holder.forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(1);
                }
            });

        }else if(position == 1){

            holder.statistic_image.setImageDrawable(Drawable2);

            holder.forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(2);
                }
            });

            holder.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(0);
                }
            });

        }else if(position == 2){

            holder.statistic_image.setImageDrawable(Drawable3);

            holder.forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(3);
                }
            });

            holder.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(1);
                }
            });

        }else if(position == 3){

            holder.statistic_image.setImageDrawable(Drawable4);

            holder.forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(4);
                }
            });

            holder.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(2);
                }
            });

        }else if(position == 4){

            holder.statistic_image.setImageDrawable(Drawable5);

            holder.forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(5);
                }
            });

            holder.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(3);
                }
            });

        }else if(position == 5){

            holder.statistic_image.setImageDrawable(Drawable6);

            holder.forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(6);
                }
            });

            holder.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(4);
                }
            });

        }else if(position == 6){

            holder.statistic_image.setImageDrawable(Drawable7);

            holder.forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(7);
                }
            });

            holder.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(5);
                }
            });

        }else if(position == 7){

            holder.forward.setVisibility(View.INVISIBLE);
            holder.forward.setClickable(false);

            holder.back.setVisibility(View.VISIBLE);
            holder.back.setClickable(true);

            holder.statistic_image.setImageDrawable(Drawable8);

            holder.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    move(6);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void move(int n){
        mrecyclerView.smoothScrollToPosition(n);
    }

    @Override
    public statistic_RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.statistic_item_frame,parent, false);
        statistic_RecyclerAdapter.MyViewHolder holder= new statistic_RecyclerAdapter.MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView forward;
        ImageView back;
        ImageView statistic_image;

        public MyViewHolder(View view) {
            super(view);
            statistic_image = (ImageView) view.findViewById(R.id.statistic_image_option);

            forward = view.findViewById(R.id.forward_stat);
            back = view.findViewById(R.id.back_stat);
        }
    }

}
