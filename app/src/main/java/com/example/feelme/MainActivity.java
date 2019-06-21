package com.example.feelme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.feelme.userinterface.MainPage;

public class MainActivity extends AppCompatActivity {
Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         login = (Button)findViewById(R.id.login);
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, MainPage.class);
                 startActivity(intent);
             }
         });


    }
}
