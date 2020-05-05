package com.example.newgame.ui.Me;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.SharedPreferences;
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

import java.net.URI;

public class Me extends Fragment {

    String nickname;
    String age;
    String gender;
    String topic;
    private MeViewModel meViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        meViewModel =
                ViewModelProviders.of(this).get(MeViewModel.class);
        View root = inflater.inflate(R.layout.me_fragment, container, false);

        SharedPreferences sp = this.getActivity().getSharedPreferences("sp_name", Context.MODE_PRIVATE);

        //image
        String str_uri = sp.getString("uri","mrkkw");
        Uri uri = Uri.parse(str_uri);

        //set image
        ImageView imageView = root.findViewById(R.id.portrait_me);
        imageView.setImageURI(uri);

        //nickname
        nickname = sp.getString("nickname","mrkkw");

        TextView textView = root.findViewById(R.id.nickname_me);
        textView.setText(nickname);

        //age
        age = sp.getString("age","10");

        //gender
        gender = sp.getString("gender","gender");

        //topic
        topic = sp.getString("topic","mrkkw");

        return root;
    }


}
