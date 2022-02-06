package com.example.atlascwiczen.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CwiczeniaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CwiczeniaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cwiczenia fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}