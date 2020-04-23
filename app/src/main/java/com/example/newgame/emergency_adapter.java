package com.example.newgame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class emergency_adapter extends RecyclerView.Adapter<emergency_adapter.MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public emergency_adapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(emergency_adapter.MyViewHolder holder, final int position) {
        holder.btn.setText( mDatas.get(position));
        Drawable myDrawable = mContext.getResources().getDrawable(R.drawable.alert_icon);
        holder.imageView.setImageDrawable(myDrawable);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public emergency_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.emergency_item,parent, false);
        emergency_adapter.MyViewHolder holder= new emergency_adapter.MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        Button btn;

        public MyViewHolder(View view) {
            super(view);
            imageView=(ImageView) view.findViewById(R.id.emergency_list_image);
            btn = (Button) view.findViewById(R.id.emergency_select_button);
        }

    }
}
