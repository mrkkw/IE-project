package com.example.newgame.AdapterCollection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.newgame.R;

import java.util.List;

public class game_machine_listAdapter extends RecyclerView.Adapter<game_machine_listAdapter.MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public game_machine_listAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onBindViewHolder(game_machine_listAdapter.MyViewHolder holder, final int position) {

        holder.textView.setText("machine");

        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public game_machine_listAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.quiz_item_frame,parent, false);
        game_machine_listAdapter.MyViewHolder holder= new game_machine_listAdapter.MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        RadioGroup radioGroup;

        public MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.quiz_fall_text);
            radioGroup = view.findViewById(R.id.radio_group_fall);
        }

    }
}
