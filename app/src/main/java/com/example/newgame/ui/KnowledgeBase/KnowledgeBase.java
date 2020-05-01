package com.example.newgame.ui.KnowledgeBase;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newgame.R;
import com.example.newgame.knowledge_base_fallpage;
import com.example.newgame.knowledge_base_heatinjurypage;
import com.example.newgame.knowledge_base_machinepage;
import com.example.newgame.knowledge_base_transportpage;
import com.example.newgame.ui.Favourite.FavouriteViewModel;

public class KnowledgeBase extends Fragment {

    private KnowledgeBaseViewModel knowledgeBaseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        knowledgeBaseViewModel =
                ViewModelProviders.of(this).get(KnowledgeBaseViewModel.class);
        View root = inflater.inflate(R.layout.knowledge_base_fragment, container, false);

        //set image
        setImage_fall(root);

        //set image
        setImage_transport(root);

        //set image'
        setImage_machine(root);

        //set image
        setImage_heat(root);

        return root;
    }

    private void setImage_fall(View view){
        ImageView imageView = (ImageView) view.findViewById(R.id.KB_Falls);
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.fall);
        imageView.setImageDrawable(drawable);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    imageView.setAlpha((float) 0.5);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    imageView.setAlpha((float) 1);
                }
                return false;
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), knowledge_base_fallpage.class);
                startActivity(intent);
            }
        });
    }

    private void setImage_machine(View view){
        ImageView imageView = (ImageView) view.findViewById(R.id.KB_Machinery);
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.machine);
        imageView.setImageDrawable(drawable);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    imageView.setAlpha((float) 0.5);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    imageView.setAlpha((float) 1);
                }
                return false;
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), knowledge_base_machinepage.class);
                startActivity(intent);
            }
        });
    }

    private void setImage_transport(View view){
        ImageView imageView = (ImageView) view.findViewById(R.id.KB_Transport);
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.transport);
        imageView.setImageDrawable(drawable);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    imageView.setAlpha((float) 0.5);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    imageView.setAlpha((float) 1);
                }
                return false;
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), knowledge_base_transportpage.class);
                startActivity(intent);
            }
        });
    }

    private void setImage_heat(View view){
        ImageView imageView = (ImageView) view.findViewById(R.id.KB_Heat_Induced_Stress_Injuries);
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.sunshine);
        imageView.setImageDrawable(drawable);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    imageView.setAlpha((float) 0.5);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    imageView.setAlpha((float) 1);
                }
                return false;
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), knowledge_base_heatinjurypage.class);
                startActivity(intent);
            }
        });
    }
}
