package com.example.newgame.ui.Game;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameNaviationViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public GameNaviationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Favourite information");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
