package com.example.newgame.ui.Me;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MeViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public MeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Personal information");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
