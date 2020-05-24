package com.example.newgame.AdapterCollection;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.newgame.R;
import com.example.newgame.quiz_1;
import com.example.newgame.quiz_2;
import com.example.newgame.quiz_3;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public MyRecyclerAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.btn.setText( mDatas.get(position));

        Drawable Drawable1 = mContext.getResources().getDrawable(R.drawable.fall);
        Drawable Drawable2 = mContext.getResources().getDrawable(R.drawable.transport);
        Drawable Drawable3 = mContext.getResources().getDrawable(R.drawable.machine);

        if(position==0){
            holder.imageView.setImageDrawable(Drawable1);
        }else if(position==1){
            holder.imageView.setImageDrawable(Drawable2);
        }else if(position==2){
            holder.imageView.setImageDrawable(Drawable3);
        }

        //set click listener for recycler view
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    Intent intent1 = new Intent(mContext, quiz_1.class);
                    mContext.startActivity(intent1);
                }else if(position == 1){
                    Intent intent2 = new Intent(mContext, quiz_2.class);
                    mContext.startActivity(intent2);
                }else if(position == 2){
                    Intent intent3 = new Intent(mContext, quiz_3.class);
                    mContext.startActivity(intent3);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.game_item_frame,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        Button btn;

        public MyViewHolder(View view) {
            super(view);
            imageView=(ImageView) view.findViewById(R.id.item_image);
            btn = (Button) view.findViewById(R.id.item_select_button);
        }

    }

}

