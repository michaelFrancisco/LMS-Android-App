package com.huntersolutions.flcandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoadingActivity extends AppCompatActivity
{
    private FirebaseDatabase database;
    private EditText LoadingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        database = FirebaseDatabase.getInstance();
        TruckInformation truckInformation = new TruckInformation();
        String truckName = truckInformation.TruckName;
        String driverName = truckInformation.driverName;
        LoadingMessage  = findViewById(R.id.txtLoadingMessage);
        LoadingMessage.setText("Hello "+ driverName+", you are not currently assigned a shipment. We'll let you know when you do.");
        DatabaseReference myRef = database
                .getReference("/locations/" + truckName + "/hasDelivery");
        myRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                boolean hasDelivery = dataSnapshot.getValue(boolean.class);
                if (hasDelivery)
                {
                    Intent goToMainActivity = new Intent(getApplicationContext(),
                            MainActivity.class);
                    startActivity(goToMainActivity);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Toast.makeText(LoadingActivity.this, "Connection failed.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
