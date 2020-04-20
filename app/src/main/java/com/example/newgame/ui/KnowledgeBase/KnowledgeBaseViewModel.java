package com.example.newgame.ui.KnowledgeBase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KnowledgeBaseViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public KnowledgeBaseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Knoledge Base information");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
