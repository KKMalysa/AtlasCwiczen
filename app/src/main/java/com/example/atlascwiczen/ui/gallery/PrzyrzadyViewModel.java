package com.example.atlascwiczen.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrzyrzadyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PrzyrzadyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("przyrzady fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}