package com.example.newgame.AdapterCollection;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newgame.MainActivity;
import com.example.newgame.Navigation_page;
import com.example.newgame.R;
import com.example.newgame.callingAWSWS;
import com.example.newgame.customViewCollection.custom_toast;

import java.util.List;

import dmax.dialog.SpotsDialog;

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

        String sub = mDatas.get(position).substring(0,50);

        sub += "\n.....\nClick expand for more details!";

        holder.textView.setText(sub);

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
                showDialog(mDatas.get(position),position+1);
            }
        });

        switch (position){
            case 0:
              holder.tip.setText("Emergency Tips | Fracture or Sprain");
              break;
            case 1:
                holder.tip.setText("Emergency Tips | Dizziness or Fainting");
                break;
            case 2:
                holder.tip.setText("Emergency Tips | Bites and Stings");
                break;
            case 3:
                holder.tip.setText("Emergency Tips | Splinters");
                break;
            case 4:
                holder.tip.setText("Emergency Tips | Burns");
                break;
            case 5:
                holder.tip.setText("Emergency Tips | Cuts and Scrapes");
                break;
            case 6:
                holder.tip.setText("Emergency Tips | General Emergency Aid");
                break;
            default:
                break;
        }
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

        TextView textView;
        TextView textView1;
        TextView tip;

        public MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.emergency_item_text);
            textView1 = view.findViewById(R.id.emergency_item_explore_text);
            tip = view.findViewById(R.id.emergency_item_tip_number);
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
