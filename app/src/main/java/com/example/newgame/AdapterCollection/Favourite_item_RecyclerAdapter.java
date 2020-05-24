package com.example.newgame.AdapterCollection;

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

import java.util.ArrayList;
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

        holder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(holder.textView.getText().toString(),position);
            }
        });

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

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
                custom_toast ct = new custom_toast();
                ct.showToast(mContext,"item deleted!");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void removeItem(int position){
        mDatas.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    @Override
    public Favourite_item_RecyclerAdapter.FavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.favourite_item,parent, false);
        Favourite_item_RecyclerAdapter.FavViewHolder holder= new Favourite_item_RecyclerAdapter.FavViewHolder(view);

        return holder;
    }

    class FavViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        TextView textView1;
        Button btn;

        public FavViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.fav_item_image);
            textView = view.findViewById(R.id.fav_item_text);
            textView1 = view.findViewById(R.id.fav_item_explore_text);
            btn = view.findViewById(R.id.fav_bin);
        }
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
}
