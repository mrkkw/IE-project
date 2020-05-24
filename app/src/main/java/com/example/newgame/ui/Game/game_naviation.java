package com.example.newgame.ui.Game;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.newgame.Navigation_page;
import com.example.newgame.R;
import com.example.newgame.customViewCollection.BubbleView;
import com.example.newgame.customViewCollection.custom_text_view;
import com.example.newgame.gamepage;
import com.example.newgame.knowledge_base_fallpage;
import com.example.newgame.ui.KnowledgeBase.KnowledgeBase;

public class game_naviation extends Fragment {

    private GameNaviationViewModel gameNaviationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gameNaviationViewModel =
                ViewModelProviders.of(this).get(GameNaviationViewModel.class);
        View root = inflater.inflate(R.layout.game_naviation_fragment, container, false);

        cardView_welcome(root);

        cardViewGame(root);

        return root;
    }

    private void cardView_welcome(View view){

        CardView cardView = view.findViewById(R.id.cardview2);

        Button button1 = view.findViewById(R.id.game_item_start_button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setVisibility(View.VISIBLE);
            }
        });

        Button button2 = view.findViewById(R.id.game_item_explore_button);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation_page navigation_page = (Navigation_page) getActivity();
                navigation_page.transfer();

                cardView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void cardViewGame(View view){
        TextView textView = view.findViewById(R.id.gamer_item_text);

        textView.setText("Press the START button and start your game!");

        Button button = view.findViewById(R.id.gamer_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(view.getContext(),gamepage.class);
                startActivity(intent);
            }
        });
    }
}
