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



    }
}
