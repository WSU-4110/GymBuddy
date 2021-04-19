package com.company.authenticatorapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Matching extends AppCompatActivity{

    public void userName(){
        setContentView(R.layout.matching);
        TextView textView = (TextView) findViewById(R.id.textView4);
        FirebaseDatabase reference = FirebaseDatabase.getInstance();
        DatabaseReference myRef = reference.getReference("Users/" + FirebaseAuth.getInstance().getCurrentUser().getUid());
        //String ID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        myRef.child("Name").get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                String name =(String.valueOf(dataSnapshot.getValue())); //only one user name displays at a time fix this tomorrow
                textView.setText(name);
            }
        });
    }
//O9vCI2bybBbFMxdmZv7paNh9vsF2
    public void matchingName(){
        setContentView(R.layout.matching);
        TextView textView = (TextView) findViewById(R.id.textView5);
        FirebaseDatabase reference = FirebaseDatabase.getInstance();
        DatabaseReference myRef = reference.getReference("Users/O9vCI2bybBbFMxdmZv7paNh9vsF2");
        //String ID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        myRef.child("Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                String name =(String.valueOf(task.getResult().getValue()));
                textView.setText(name);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userName();
        matchingName();

    }
}
