package com.example.feelme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SignUp extends AppCompatActivity {
Button fatherimg_btn,motherimg_btn,grandpaimg_btn,grandmaimg_btn,uncleimg_btn,auntimg_btn,sisterimg_btn,brotherimg_btn,submit;
ImageView fatherimg ,motherimg ,grandpaimg ,grandmaimg,uncleimg,auntimg,sisterimg,brotherimg;
EditText name, userid , password , fath_phone ,mother_phone,grandpa_phone,grandma_phone,uncle_phone,aunt_phone,sister_phone,brother_phone;
Bitmap fatherimgb ,motherimgb ,grandpaimgb ,grandmaimgb,uncleimgb,auntimgb,sisterimgb,brotherimgb;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    ArrayList<Imageuploading> arrayList = new ArrayList<>();
ArrayList<ImageUploa> stringArrayList = new ArrayList<>();

    private final int PICK_IMAGE_FATHER = 1;
    private final int PICK_IMAGE_MOTHER = 2;
    private final int PICK_IMAGE_GRANDFATHER = 3;
    private final int PICK_IMAGE_GRANDMOTHER = 4;
    private final int PICK_IMAGE_UNCLE = 5;
    private final int PICK_IMAGE_AUNT = 6;
    private final int PICK_IMAGE_SISTER = 7;
    private final int PICK_IMAGE_BROTHER = 8;
    private Uri filePath;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();
    ProgressDialog progressDialog;
    DatabaseReference myRef = database.getReference("users/user");
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       initialize_button();

    }


    public void uploadimg(final String useridupload, Bitmap img, final String names){
        final StorageReference imagesRef = storageRef.child(useridupload+names+".jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        img.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();
        final String phonefather,phoneaunt,phoneuncle,phonegrandfather,phonegrandmother,phonebrother,phonesister,phonemother,usersid,passwords,namesd;
        UploadTask uploadTask = imagesRef.putBytes(data);
        phonefather = fath_phone.getText().toString();
        phoneaunt = aunt_phone.getText().toString();
        phonebrother = brother_phone.getText().toString();
        phonesister = sister_phone.getText().toString();
        phonegrandfather = grandpa_phone.getText().toString();
        phonegrandmother = grandma_phone.getText().toString();
        phonemother = mother_phone.getText().toString();
        phoneuncle = uncle_phone.getText().toString();
        usersid = userid.getText().toString();
        passwords = password.getText().toString();
        namesd = name.getText().toString();
        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }
                // Continue with the task to get the download URL
                return imagesRef.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                    Log.e("MASTER",downloadUri.toString());
                    ImageUploa imageUploa = new ImageUploa(downloadUri.toString(),names);
                    stringArrayList.add(imageUploa);

                   //LabourModel labourModel = new LabourModel(password,name,details,place,phone,charge,downloadUri.toString(),5.0);
                    //myRef.child(userid).setValue(labourModel);
                    //Intent intent = new Intent(Signupforuser.this,MainActivity.class);
                    //intent.putExtra("finish", true);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                      //      Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        //    Intent.FLAG_ACTIVITY_NEW_TASK);
                    //startActivity(intent);
                    if(stringArrayList.size() == arrayList.size()){

                        Log.e("MASTERNadeem",stringArrayList.get(3).getName().toString());
                        UserDetails userDetails = new UserDetails(phonefather,phoneaunt,phoneuncle,phonegrandfather,phonegrandmother,phonebrother,phonesister,phonemother,namesd,passwords);
                        add_User(useridupload,stringArrayList,userDetails);
                    }
                }
                else {
                    // Handle failures
                    // ...
                }
            }
        });
    }

public void add_User(String userd,ArrayList<ImageUploa> arrayList,UserDetails userDetails){

UserRegister userRegister = new UserRegister(userDetails.getPhonefather(),userDetails.getPhoneaunt(),userDetails.getPhoneuncle(),userDetails.getPhonegrandfather(),userDetails.getPhonegrandmother(),userDetails.getPhonebrother(),userDetails.getPhonesister(),userDetails.getPhonemother(),userDetails.getName(),userDetails.getPassword(),arrayList.get(0).getUrl(),arrayList.get(1).getUrl(),arrayList.get(2).getUrl(),arrayList.get(3).getUrl(),arrayList.get(4).getUrl(),arrayList.get(5).getUrl(),arrayList.get(6).getUrl(),arrayList.get(7).getUrl());

        myRef.child(userd).setValue(userRegister);
    progressDialog.dismiss();
    Intent intent = new Intent(SignUp.this,MainActivity.class);
    intent.putExtra("finish", true);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
            Intent.FLAG_ACTIVITY_CLEAR_TASK |
            Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);





}
    public void initialize_button(){
        submit = (Button)findViewById(R.id.submitforuser);
        name = (EditText)findViewById(R.id.nameuser);
        userid = (EditText)findViewById(R.id.useriduser);
        password = (EditText)findViewById(R.id.passuser);
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
        fath_phone = (EditText) findViewById(R.id.father_phone);
        mother_phone = (EditText) findViewById(R.id.motherphone);
        grandpa_phone = (EditText) findViewById(R.id.grandpa_phone);
        grandma_phone = (EditText) findViewById(R.id.grandma_phone);
        uncle_phone = (EditText) findViewById(R.id.uncle_phone);
        aunt_phone = (EditText) findViewById(R.id.aunt_phone);
        sister_phone = (EditText) findViewById(R.id.sisterphone);
        brother_phone = (EditText) findViewById(R.id.brother_phone);
        fatherimgb=((BitmapDrawable)fatherimg.getDrawable()).getBitmap();
        motherimgb =((BitmapDrawable)motherimg.getDrawable()).getBitmap();
        grandpaimgb =((BitmapDrawable)grandpaimg.getDrawable()).getBitmap();
        grandmaimgb =((BitmapDrawable)grandmaimg.getDrawable()).getBitmap();
        uncleimgb =((BitmapDrawable)uncleimg.getDrawable()).getBitmap();
        auntimgb=((BitmapDrawable)auntimg.getDrawable()).getBitmap();
        sisterimgb =((BitmapDrawable)sisterimg.getDrawable()).getBitmap();
        brotherimgb=((BitmapDrawable)brotherimg.getDrawable()).getBitmap();
        final String phonefather,phoneaunt,phoneuncle,phonegrandfather,phonegrandmother,phonebrother,phonesister,phonemother,usersid,passwords,names;
        phonefather = fath_phone.getText().toString();
        phoneaunt = aunt_phone.getText().toString();
        phonebrother = brother_phone.getText().toString();
        phonesister = sister_phone.getText().toString();
        phonegrandfather = grandpa_phone.getText().toString();
        phonegrandmother = grandma_phone.getText().toString();
        phonemother = mother_phone.getText().toString();
        phoneuncle = uncle_phone.getText().toString();
        usersid = userid.getText().toString();
        passwords = password.getText().toString();
        names = name.getText().toString();

        fatherimg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("NADEEMMASTER","fatherbtn");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_FATHER);
            }
        });
        motherimg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("NADEEMMASTER","motherbtn");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_MOTHER);
            }
        });
        grandpaimg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("NADEEMMASTER","grandpabtn");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_GRANDFATHER);

            }
        });
        grandmaimg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("NADEEMMASTER","grandmabtn");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_GRANDMOTHER);
            }
        });
        uncleimg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("NADEEMMASTER","unclebtn");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_UNCLE);
            }
        });
        auntimg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("NADEEMMASTER","auntbtn");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_AUNT);
            }
        });
        sisterimg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("NADEEMMASTER","sisterbtn");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_SISTER);
            }
        });
        brotherimg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("NADEEMMASTER","brotherbtn");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_BROTHER);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(SignUp.this);
                progressDialog.setMessage("please Wait while loading");
                progressDialog.show();
             //UserDetails userDetails = new UserDetails();
                Log.e("Uploadedimages", "where am i");
                DatabaseReference myRef = database.getReference("users/user");
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("userid", userid.getText().toString());
                        if(dataSnapshot.hasChild(userid.getText().toString())){

                            Toast.makeText(SignUp.this,"MasterNadeem",Toast.LENGTH_LONG).show();
                            return;
                        }
                        else{
                            Bitmap[] bitmaps = {fatherimgb,motherimgb,grandpaimgb,grandmaimgb,uncleimgb,auntimgb,sisterimgb,brotherimgb};
                            String[] names   = {"father","mother","grandfather","grandmother","uncle","aunt","sister","brother"};
                            int i = 0;
                            for (Bitmap bitmap:bitmaps){
                                Imageuploading imageuploading = new Imageuploading(names[i],bitmap);

                                arrayList.add(imageuploading);
                                Log.e("Uploadedimages", arrayList.get(i).getName().toString());
                                Log.e("Uploadedimages", arrayList.get(i).getUrl().toString());
                           i++;
                            }
                              for(int j = 0 ; j<arrayList.size();j++) {
                                 uploadimg(userid.getText().toString(), bitmaps[j], names[j]);

                              }
                 }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            //uploadimg();
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if(requestCode == PICK_IMAGE_FATHER && resultCode == RESULT_OK && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
                fatherimg.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(requestCode == PICK_IMAGE_MOTHER && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
                motherimg.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(requestCode == PICK_IMAGE_GRANDFATHER && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
                grandpaimg.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(requestCode == PICK_IMAGE_GRANDMOTHER && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
                grandmaimg.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(requestCode == PICK_IMAGE_UNCLE && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
                uncleimg.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(requestCode == PICK_IMAGE_AUNT && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
                auntimg.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(requestCode == PICK_IMAGE_SISTER && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
                sisterimg.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else if(requestCode == PICK_IMAGE_BROTHER && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
                brotherimg.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }


}
