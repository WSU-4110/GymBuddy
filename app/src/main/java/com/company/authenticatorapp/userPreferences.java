package com.company.authenticatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.company.authenticatorapp.Data.Update;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class userPreferences extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{

    private EditText fullName, aboutMe;
    private String gender;
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

        Button submit = (Button) findViewById(R.id.btsubmit);

        String userID = Objects.requireNonNull(auth.getCurrentUser()).getUid();


        database = FirebaseDatabase.getInstance().getReference().child(Data.Update.users).child(userID);

        //getting the info back
        getUserInfo();

        //creating the spinner menu for gender
        dropdownSpinner = findViewById(R.id.setGender);
        String[] str = new String[]{Data.Update.male, Data.Update.female};
        adaptSpinner = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, str);
        dropdownSpinner.setAdapter(adaptSpinner);
        dropdownSpinner.setOnItemSelectedListener(this);

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
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {

                    Map<String, Object> uInfo = (Map<String, Object>) dataSnapshot.getValue();

                    assert uInfo != null;
                    if(uInfo.get(Data.Update.fname) != null) {
                        fullName.setText(Objects.requireNonNull(uInfo.get(Data.Update.fname)).toString());
                    }
                    if(uInfo.get(Data.Update.user_gender) != null) {
                        int spinnerPosition = adaptSpinner.getPosition(Objects.requireNonNull(uInfo.get(Data.Update.user_gender)).toString());
                        dropdownSpinner.setSelection(spinnerPosition);
                    }
                    if(uInfo.get(Data.Update.user_aboutMe) != null) {
                        aboutMe.setText(Objects.requireNonNull(uInfo.get(Data.Update.user_aboutMe)).toString());
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
        String information = aboutMe.getText().toString();
        String gender1 = gender;

        Map<String, Object> uInfo = new HashMap<String, Object>();
        uInfo.put(Data.Update.fname, name);
        uInfo.put(Data.Update.user_gender, gender1);
        uInfo.put(Data.Update.user_aboutMe, information);

        database.updateChildren(uInfo);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long x) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long x) {
        switch(position)
        {
            case 0:
                gender = Data.Update.male;
                break;
            case 1:
                gender = Data.Update.female;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}