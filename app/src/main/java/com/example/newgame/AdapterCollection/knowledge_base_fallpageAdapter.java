package com.example.newgame.AdapterCollection;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.newgame.R;
import com.example.newgame.quiz_1;
import com.example.newgame.quiz_2;
import com.example.newgame.quiz_3;
import com.example.newgame.quiz_4;

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

        holder.btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    holder.btn.setAlpha((float) 0.5);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    holder.btn.setAlpha(1);
                }
                return false;
            }
        });
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

        TextView textView;
        Button btn;

        public MyViewHolder(View view) {
            super(view);
            textView=(TextView) view.findViewById(R.id.KB_item_text);
            btn = (Button) view.findViewById(R.id.KB_fav_button);
        }

    }
}
