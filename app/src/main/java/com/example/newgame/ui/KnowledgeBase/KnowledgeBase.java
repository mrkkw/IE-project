package com.example.newgame.ui.KnowledgeBase;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newgame.R;
import com.example.newgame.ui.Favourite.FavouriteViewModel;

public class KnowledgeBase extends Fragment {

    private KnowledgeBaseViewModel knowledgeBaseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        knowledgeBaseViewModel =
                ViewModelProviders.of(this).get(KnowledgeBaseViewModel.class);
        View root = inflater.inflate(R.layout.knowledge_base_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_KB);
        knowledgeBaseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
