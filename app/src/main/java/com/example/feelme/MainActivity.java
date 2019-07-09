package com.example.feelme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.feelme.userinterface.MainPage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
Button login;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users/user");
EditText usaername,passwrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usaername = (EditText)findViewById(R.id.username);
        passwrd = (EditText)findViewById(R.id.passwrd);




         login = (Button)findViewById(R.id.login);
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String usr,psd;

                 usr = usaername.getText().toString();
                 psd = passwrd.getText().toString();


                 logMethod(usr,psd);


             }
         });


    }

    public void logMethod(String usar ,String psd){
myRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});



    }





}
