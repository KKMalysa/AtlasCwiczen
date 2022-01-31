package com.example.atlascwiczen.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AtlasCwiczenViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AtlasCwiczenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Atlas Cwiczen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}