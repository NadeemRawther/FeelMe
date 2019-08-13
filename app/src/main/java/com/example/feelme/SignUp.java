package com.example.feelme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignUp extends AppCompatActivity {
Button fatherimg_btn,motherimg_btn,grandpaimg_btn,grandmaimg_btn,uncleimg_btn,auntimg_btn,sisterimg_btn,brotherimg_btn;
ImageView fatherimg ,motherimg ,grandpaimg ,grandmaimg,uncleimg,auntimg,sisterimg,brotherimg;
EditText fath_phone ,mother_phone,grandpa_phone,grandma_phone,uncle_phone,aunt_phone,sister_phone,brother_phone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fatherimg_btn = (Button)findViewById(R.id.father_img_btn);
        motherimg_btn = (Button)findViewById(R.id.mother_img_btn);
        grandpaimg_btn = (Button)findViewById(R.id.grandpa_img_btn);
        grandmaimg_btn = (Button)findViewById(R.id.grandma_img_btn);
        uncleimg_btn =(Button)findViewById(R.id.uncle_img_btn);
        auntimg_btn = (Button)findViewById(R.id.aunt_img_btn);
        sisterimg_btn = (Button)findViewById(R.id.sister_img_btn);
        brotherimg_btn = (Button)findViewById(R.id.brotherimg_btn);
        fatherimg = (ImageView)findViewById(R.id.father_img);
        motherimg = (ImageView)findViewById(R.id.motherimg);
        grandpaimg = (ImageView)findViewById(R.id.grandpa_img);
        grandmaimg = (ImageView)findViewById(R.id.grandma_img);
        uncleimg= (ImageView)findViewById(R.id.uncle_img);
        auntimg = (ImageView)findViewById(R.id.aunt_img);
        sisterimg = (ImageView)findViewById(R.id.sisterimg);
        brotherimg = (ImageView)findViewById(R.id.brother_img);
        




    }
}
