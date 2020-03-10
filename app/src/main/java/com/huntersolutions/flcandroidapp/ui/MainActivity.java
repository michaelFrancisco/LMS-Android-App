package com.huntersolutions.flcandroidapp.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.huntersolutions.flcandroidapp.R;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private static final int PERMISSIONS_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_map, R.id.navigation_shipment, R.id.navigation_contact)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //Retrieving Firebase data
        database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("/locations/" + TruckInformation.getTruckName());
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TruckInformation.setDriverName(dataSnapshot.child("driverName").getValue(String.class));
                TruckInformation.setDeliveryDestination(dataSnapshot.child("deliveryDestination").getValue(String.class));
                TruckInformation.setDeliveryOrigin(dataSnapshot.child("deliveryOrigin").getValue(String.class));
                TruckInformation.setDestinationLatitude(dataSnapshot.child("destinationLatitude").getValue(Double.class));
                TruckInformation.setDestinationLongitude(dataSnapshot.child("destinationLongitude").getValue(Double.class));
                TruckInformation.setOriginLatitude(dataSnapshot.child("originLatitude").getValue(Double.class));
                TruckInformation.setOriginLongitude(dataSnapshot.child("originLongitude").getValue(Double.class));
                TruckInformation.setHasDelivery(dataSnapshot.child("hasDelivery").getValue(boolean.class));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Firebase", "Failed to read value.", databaseError.toException());
            }
        });

        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            Toast.makeText(this, "Please enable location services", Toast.LENGTH_SHORT).show();
        }

        // Check location permission is granted - if it is, start
        // the service, otherwise request the permission
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permission == PackageManager.PERMISSION_GRANTED)
        {
            startTrackerService();
        }
        else
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST);
        }
    }

    private void startTrackerService()
    {
        startService(new Intent(this, TrackerService.class));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        if (requestCode == PERMISSIONS_REQUEST && grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            // Start the service when the permission is granted
            startTrackerService();
        }
    }

}
