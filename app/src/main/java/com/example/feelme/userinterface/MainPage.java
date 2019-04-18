package com.example.feelme.userinterface;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.feelme.R;

public class MainPage extends AppCompatActivity {
    ImageView mother,father,sister,brother,uncle,aunty,grandpa,grandma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        mother = (ImageView) findViewById(R.id.mother);
        father = (ImageView)findViewById(R.id.father);
        sister = (ImageView)findViewById(R.id.sis);
        brother = (ImageView)findViewById(R.id.bro);
        uncle = (ImageView)findViewById(R.id.uncle);
        aunty = (ImageView)findViewById(R.id.aunty);
        grandpa = (ImageView)findViewById(R.id.grandpa);
        grandma = (ImageView)findViewById(R.id.grandma);



        mother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v);
            }
        });

        father.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v);
            }
        });

        sister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v);
            }
        });
        brother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v);
            }
        });

        uncle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v);
            }
        });
        aunty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v);
            }
        });

        grandpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v);
            }
        });
        grandma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
createEmoji(v);
            }
        });
    }
  public void createEmoji(View v){
      AlertDialog.Builder builder = new AlertDialog.Builder(MainPage.this);
      View mView = View.inflate(MainPage.this,R.layout.emoji_layout,null);
      builder.setView(mView);
      final AlertDialog alertDialog = builder.create();
      alertDialog.show();
  }
}
