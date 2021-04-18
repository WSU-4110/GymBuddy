package com.company.authenticatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            setContentView(R.layout.activity_main);
            Button PrefButton = (Button) findViewById(R.id.button2);
        }
        else{
            setContentView(R.layout.activity_log_in);
        }
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),LogIn.class));
        finish();
    }

    public void preferences(View view){
        setContentView(R.layout.activity_user_preferences);
        startActivity(new Intent(MainActivity.this,userPreferences.class));
        finish();
    }
}