package com.huntersolutions.flcandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity
{

    private FirebaseAuth mAuth;
    private EditText txtEmail;
    private EditText txtPassword;
    private String password;
    private String email;
    private FirebaseDatabase database;


    @Override
    public void onStart()
    {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                txtEmail = findViewById(R.id.txtEmail);
                txtPassword = findViewById(R.id.txtPassword);
                email = txtEmail.getText().toString();
                password = txtPassword.getText().toString();
                signIn(email, password);
            }
        });
    }

    private String truckName(String Email)
    {
        switch (Email)
        {
            case "michaelfrancisco64@gmail.com":
                return "420";
            default:
                throw new IllegalStateException("Unexpected value: " + Email);
        }
    }

    private void signIn(final String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            TruckInformation truckInformation = new TruckInformation();
                            truckInformation.TruckName = truckName(email);
                            truckInformation.Email = email;
                            Toast.makeText(LoginActivity.this, "Authentication Success ",
                                    Toast.LENGTH_SHORT).show();
                            DatabaseReference myRef = database
                                    .getReference("/locations/" + truckInformation.TruckName);
                            myRef.addListenerForSingleValueEvent(new ValueEventListener()
                            {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                                {
                                    TruckInformation truckInformation = new TruckInformation();
                                        truckInformation.driverName = dataSnapshot.child("driverName").getValue(String.class);
                                        truckInformation.hasDelivery = dataSnapshot.child("hasDelivery").getValue(boolean.class);
                                    if (truckInformation.hasDelivery)
                                    {
                                        Intent goToMainActivity = new Intent(getApplicationContext(),
                                                MainActivity.class);
                                        startActivity(goToMainActivity);
                                    } else
                                    {
                                        Intent goToLoadingActivity = new Intent(getApplicationContext(),
                                                LoadingActivity.class);
                                        startActivity(goToLoadingActivity);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError)
                                {
                                    Toast.makeText(LoginActivity.this, "Connection failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });

                        } else
                        {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
