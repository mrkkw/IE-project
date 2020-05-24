package com.example.newgame.ui.Me;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.PeriodicSync;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newgame.R;

public class Me extends Fragment {

    String nickname;
    String age;
    String gender;
    String topic;
    String living_area;
    String text;
    String gender_text;
    String fav_text;
    String living_text;
    String age_text;

    private MeViewModel meViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        meViewModel =
                ViewModelProviders.of(this).get(MeViewModel.class);
        View root = inflater.inflate(R.layout.me_fragment, container, false);

        SharedPreferences sp = getActivity().getSharedPreferences("sp_name1", Context.MODE_PRIVATE);

        //set portrait
        setImage(root,sp);

        //nickname
        setNickname(root,sp);

        //gender
        setGender(root,sp);

        //age
        setAge(root,sp);

        //topic
        setTopic(root,sp);

        //living area
        setLiving_area(root,sp);

        return root;
    }

    private void setImage(View root,SharedPreferences sp){
        //image
        String str_uri = sp.getString("uri","mrkkw");
        Uri uri = Uri.parse(str_uri);

        //set image
        ImageView imageView = root.findViewById(R.id.portrait_me);
        imageView.setBackground(null);

        if(str_uri.equals("123")){
            Drawable drawable = root.getResources().getDrawable(R.drawable.default_icon);
            imageView.setImageDrawable(drawable);
        }else {
            imageView.setImageURI(uri);
        }
    }

    private void setNickname(View root,SharedPreferences sp){
        nickname = sp.getString("nickname","mrkkw");

        TextView textView = root.findViewById(R.id.nickname_me);

        text = "Nick name | "+ nickname;

        textView.setText(text);
    }

    private void setGender(View root,SharedPreferences sp){
        gender = sp.getString("gender","gender");

        ImageView imageView2 = root.findViewById(R.id.gender_icon);

        if(gender.equals("Male")){
            Drawable Drawable1 = getContext().getResources().getDrawable(R.drawable.male_icon);
            imageView2.setImageDrawable(Drawable1);
        }else if (gender.equals("Female")){
            Drawable Drawable1 = getContext().getResources().getDrawable(R.drawable.female_icon);
            imageView2.setImageDrawable(Drawable1);
        }

        TextView textView1 = root.findViewById(R.id.gender_text);

        gender_text = "Gender | "+ gender;

        textView1.setText(gender_text);
    }

    private void  setAge(View root,SharedPreferences sp){
        TextView textView4 = root.findViewById(R.id.age_text);

        age = sp.getString("age","10");

        age_text = "Age | "+ age;

        textView4.setText(age_text);
    }

    private void setTopic(View root,SharedPreferences sp){
        TextView textView2 = root.findViewById(R.id.fav_text);

        topic = sp.getString("topic","mrkkw");

        fav_text = "Favourite topic | "+ topic;

        textView2.setText(fav_text);
    }

    private void setLiving_area(View root,SharedPreferences sp){
        TextView textView3 = root.findViewById(R.id.home_text);

        living_area = sp.getString("living area","mrkkw");

        living_text = "Living area | "+ living_area;

        textView3.setText(living_text);
    }
}
