package com.example.feelme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends AppCompatActivity  {

    Button login,signup;
    SharedPreferences sharedPreferences;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users/user");
    EditText usaername,passwrd;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usaername = (EditText)findViewById(R.id.username);
        passwrd = (EditText)findViewById(R.id.passwrd);
        signup = (Button)findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
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

    public void logMethod(final String usar , final String psd){



myRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           if (dataSnapshot.hasChild(usar)){
               for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                   if(dataSnapshot1.child("password").getValue().toString().equals(psd)){
                       sharedPreferences = getApplicationContext().getSharedPreferences("Mypref", Context.MODE_PRIVATE);
                       editor = sharedPreferences.edit();
                       editor.putString("userid",usar);
                       Intent intent = new Intent(MainActivity.this,UserPage.class);
                       startActivity(intent);
                   }
               }
               }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});



    }



}
