package com.company.authenticatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class userPreferences extends AppCompatActivity{

    private EditText fullName, phoneNumber, aboutMe;
    private String gender, name, phone, info;
    private DatabaseReference database;
    private FirebaseAuth auth;
    private ArrayAdapter<String> adaptSpinner;
    private Spinner dropdownSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preferences);

        fullName = (EditText)findViewById(R.id.setName);
        aboutMe = (EditText)findViewById(R.id.setAboutMe);
        phoneNumber = (EditText)findViewById(R.id.setPhone);

        Button submit = (Button)findViewById(R.id.btsubmit);

        auth = FirebaseAuth.getInstance();
        String userID = (auth.getCurrentUser()).getUid();

        database = FirebaseDatabase.getInstance().getReference().child("Users").child(userID);

        //getting the info back
        getUserInfo();

       /* //creating the spinner menu for gender
        dropdownSpinner = findViewById(R.id.setGender);
        String[] str = new String[]{Data.Update.male, Data.Update.female};
        adaptSpinner = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, str);
        dropdownSpinner.setAdapter(adaptSpinner);
        dropdownSpinner.setOnItemSelectedListener(this);*/

        //saving info
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInformation();
            }
        });

    }

    private void getUserInfo() {
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                    Map<String, Object> uInfo = (Map<String, Object>) dataSnapshot.getValue();

                    if (uInfo.get("name") != null) {
                        name = uInfo.get("name").toString();
                        fullName.setText(name);
                    }
                    if (uInfo.get("phone") != null) {
                        phone = uInfo.get("phone").toString();
                        phoneNumber.setText(phone);
                    }
                    if (uInfo.get("sex") != null) {
                        gender = uInfo.get("sex").toString();
                    }
                    if (uInfo.get("aboutme") != null) {
                        info = uInfo.get("aboutme").toString();
                        aboutMe.setText(info);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void saveUserInformation() {
        String name = fullName.getText().toString();
        String phone = phoneNumber.getText().toString();
        String information = aboutMe.getText().toString();
        String gender1 = gender;

        Map<String, Object> uInfo = new HashMap<String, Object>();
        uInfo.put("name", name);
        uInfo.put("phone", phone );
        uInfo.put("gender", gender1);
        uInfo.put("aboutme", information);

        database.updateChildren(uInfo);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}