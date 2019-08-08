package com.example.feelme.userinterface;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.feelme.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainPage extends Fragment  {
    SharedPreferences sharedPreferences;
    ImageView mother,father,sister,brother,uncle,aunty,grandpa,grandma;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sharedPreferences = getActivity().getSharedPreferences("Mypref", Context.MODE_PRIVATE);
        View view =  inflater.inflate(R.layout.activity_main_page, container, false);
        mother = (ImageView) view. findViewById(R.id.mother);
        father = (ImageView)view.findViewById(R.id.father);
        sister = (ImageView)view.findViewById(R.id.sis);
        brother = (ImageView)view.findViewById(R.id.bro);
        uncle = (ImageView)view.findViewById(R.id.uncle);
        aunty = (ImageView)view.findViewById(R.id.aunty);
        grandpa = (ImageView)view.findViewById(R.id.grandpa);
        grandma = (ImageView)view.findViewById(R.id.grandma);
        String userid = sharedPreferences.getString("userid","");
        DatabaseReference myRef = database.getReference("users/user/"+userid);
myRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String moth, fath, sist, grandfa, grandmo, unc, aun;
        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
        Glide.with( getActivity() ).load( dataSnapshot1.child("father").getValue().toString()).into(father);
        Glide.with( getActivity() ).load(dataSnapshot1.child("mother").getValue().toString()).into(mother);
        Glide.with( getActivity() ).load( dataSnapshot1.child("uncle").getValue().toString()).into(uncle);
        Glide.with( getActivity() ).load( dataSnapshot1.child("aunt").getValue().toString()).into(aunty);
        Glide.with( getActivity() ).load( dataSnapshot1.child("grandfather").getValue().toString()).into(grandpa);
        Glide.with( getActivity() ).load( dataSnapshot1.child("grandmother").getValue().toString()).into(grandma);
        Glide.with( getActivity() ).load( dataSnapshot1.child("brother").getValue().toString()).into(brother);
        Glide.with( getActivity() ).load( dataSnapshot1.child("sister").getValue().toString()).into(sister);
        }
    }
    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

        mother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,80);
            }
        });

        father.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,45);
            }
        });

        sister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,78);
            }
        });
        brother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,87);
            }
        });

        uncle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,45);
            }
        });
        aunty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,79);
            }
        });

        grandpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,46);
            }
        });
        grandma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,79);
            }
        });
        return view ;
    }



  public void createEmoji(View v,int phoneNo){
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      View mView = View.inflate(getActivity(),R.layout.emoji_layout,null);
      builder.setView(mView);
      final AlertDialog alertDialog = builder.create();
      alertDialog.show();
      String msg="";
      ImageView angry,pain,happy,confused,sad,sick;


          try {
              SmsManager smsManager = SmsManager.getDefault();
              ArrayList<String> messageParts = smsManager.divideMessage(msg);
              smsManager.sendMultipartTextMessage(String.valueOf(phoneNo), null, messageParts, null, null);
              Toast.makeText(getContext(), "Message Sent",
                      Toast.LENGTH_LONG).show();
          } catch (Exception ex) {
              Toast.makeText(getContext(),ex.getMessage().toString(),
                      Toast.LENGTH_LONG).show();
              ex.printStackTrace();
          }


  }
}
