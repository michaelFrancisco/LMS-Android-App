package com.huntersolutions.flcandroidapp.ui.shipment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.huntersolutions.flcandroidapp.R;


public class ShipmentFragment extends Fragment {

    private ShipmentViewModel shipmentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shipmentViewModel =
                ViewModelProviders.of(this).get(ShipmentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_shipment, container, false);
        return root;
    }
}
