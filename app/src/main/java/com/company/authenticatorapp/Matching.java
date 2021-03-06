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

import java.util.ArrayList;
import java.util.Random;

public class Matching extends AppCompatActivity{
public DatabaseReference randomRef;

    private Button button;

    public DatabaseReference userName(){ // grabs the user id for the active user

        FirebaseDatabase reference = FirebaseDatabase.getInstance();
        DatabaseReference myRef = reference.getReference("Users/" + FirebaseAuth.getInstance().getCurrentUser().getUid());

       return myRef;
    }

    public DatabaseReference matchingName(){ //grabs a reference for a generic user token
        FirebaseDatabase reference = FirebaseDatabase.getInstance();
        DatabaseReference myRef = reference.getReference();
        return myRef;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matching);
        TextView textView = (TextView) findViewById(R.id.textView4);
        TextView textView2 = (TextView) findViewById(R.id.textView5);

        reference(userName() , textView);
        random(matchingName(), textView2);

        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeScreen();
            }
        });
    }

    public void homeScreen(){//function to have a back button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

public void reference(DatabaseReference myRef, TextView textView){//grabs the users name based on the user id key provided
    myRef.child("Name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
        @Override
        public void onComplete(@NonNull Task<DataSnapshot> task) {
            String name =(String.valueOf(task.getResult().getValue()));
            textView.setText(name);
        }


    });
}
public void random(DatabaseReference myRef, TextView textView){//generates a random user id
    FirebaseDatabase reference = FirebaseDatabase.getInstance();
    myRef.child("Users/").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            Random random;
            ArrayList list = new ArrayList<String>();// references all objects in the database as a list
            for(DataSnapshot arr: snapshot.getChildren()){
                String s1 = arr.toString().substring(arr.toString().indexOf("=")+1);// this returns only the child function we need to get the user id
                s1 = s1.split(",")[0];
                s1 = s1.replaceAll(" ", "");
                list.add(s1);
            }
            random = new Random();
            String[] array = new String[list.size()];
            int index = 0;
            for(Object Value: list){
                array[index] = (String) Value;
                index++;
            }
            String key = array[(int)Math.floor(Math.random()*(array.length))];
            randomRef = reference.getReference("Users/" + key);
            while(randomRef == userName()){
                key = "";
                key = array[random.nextInt(array.length)];
                randomRef = reference.getReference("Users/" + key);
            }
           reference(randomRef, textView);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            System.out.println("error");
        }
    });
}
}
