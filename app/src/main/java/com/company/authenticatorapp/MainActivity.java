package com.company.authenticatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity{

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            System.out.println("main function" + uid); //delete this later. this calls the user id to the console for id pass through verification
            FirebaseDatabase reference = FirebaseDatabase.getInstance();
            DatabaseReference myRef = reference.getReference("Users/" + FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Name");

           System.out.println("username: " + reference.getReference("Users/" + FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Name"));

            setContentView(R.layout.activity_main);
            Button PrefButton = (Button) findViewById(R.id.button2);
            PrefButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    preferences(findViewById(R.id.button2));
                }
            });
        }
        else{
            setContentView(R.layout.activity_log_in);
        }

        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessaging();
            }
        });
    }

    public void openMessaging(){
        Intent intent = new Intent(this, Messaging.class);
        startActivity(intent);
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),LogIn.class));
        finish();
    }

    public void preferences(View view){
        //Intent intent = new Intent(this, userPreferences.class);
        setContentView(R.layout.activity_user_preferences);
        startActivity(new Intent(this,userPreferences.class));
        //finish();
    }
}