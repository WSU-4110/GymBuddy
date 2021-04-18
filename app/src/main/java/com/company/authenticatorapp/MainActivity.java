package com.company.authenticatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            System.out.println("main function" + uid); //delete this later. this calls the user id to the console for id pass through verification
           // System.out.println("username: " + );
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