package com.example.atlascwiczen.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AktywnosciPozatreningoweViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AktywnosciPozatreningoweViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("AktywnościPozatreningowe fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}