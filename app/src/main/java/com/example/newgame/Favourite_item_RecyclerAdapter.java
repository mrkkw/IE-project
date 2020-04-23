package com.example.newgame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Favourite_item_RecyclerAdapter extends RecyclerView.Adapter<Favourite_item_RecyclerAdapter.FavViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public Favourite_item_RecyclerAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);

    }

    @Override
    public void onBindViewHolder(Favourite_item_RecyclerAdapter.FavViewHolder holder, final int position) {
        holder.textView.setText(mDatas.get(position));

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
    public Favourite_item_RecyclerAdapter.FavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.favourite_item,parent, false);
        Favourite_item_RecyclerAdapter.FavViewHolder holder= new Favourite_item_RecyclerAdapter.FavViewHolder(view);

        return holder;
    }

    class FavViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        Button btn;
        public FavViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.fav_item_text);
            btn = view.findViewById(R.id.delete_button);
        }

    }
}
