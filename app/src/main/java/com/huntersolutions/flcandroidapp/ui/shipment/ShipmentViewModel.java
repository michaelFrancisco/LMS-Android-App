package com.huntersolutions.flcandroidapp.ui.shipment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShipmentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShipmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}