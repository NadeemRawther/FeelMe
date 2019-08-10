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
    String userid;
    ImageView angry,pain,happy,confused,sad,sick;
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
        userid = sharedPreferences.getString("userid","");
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
                createEmoji(v,"phonemother");
            }
        });

        father.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,"phonefather");
            }
        });

        sister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,"phonesister");
            }
        });
        brother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,"phonebrother");
            }
        });

        uncle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,"phoneuncle");
            }
        });
        aunty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,"phoneaunt");
            }
        });

        grandpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,"phonegrandfather");
            }
        });
        grandma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEmoji(v,"phonegrandmother");
            }
        });
        return view ;
    }
  public void createEmoji(View v, final String relation){
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      View mView = View.inflate(getActivity(),R.layout.emoji_layout,null);
      builder.setView(mView);

              angry = (ImageView)mView.findViewById(R.id.angrye);
              pain = (ImageView)mView.findViewById(R.id.pain);
              happy = (ImageView)mView.findViewById(R.id.happye);
              confused = (ImageView)mView.findViewById(R.id.confusede);
              sad = (ImageView)mView.findViewById(R.id.sade);
              sick = (ImageView)mView.findViewById(R.id.sick);

             sad.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     send_re("sad",relation);
                 }
             });

             angry.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     send_re("angry",relation);
                 }
             });
             pain.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     send_re("pain",relation);
                 }
             });
             happy.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     send_re("happy",relation);
                 }
             });

             confused.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     send_re("confused",relation);
                 }
             });

             sick.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     send_re("sick",relation);

                 }
             });
      final AlertDialog alertDialog = builder.create();
      alertDialog.show();
  }


  public void send_re(String emot, final String relation){

        String emoti = "";

        switch(emot){
            case "sad":
                emoti = "Iam sad";
            case "happy":
                emoti = "Iam extremely happy";
            case "pain":
                emoti = "I am in pain ";
            case "angry":
                emoti = "Iam angry";
            case "sick":
                emoti = "Iam sick";
            case "confused":
                emoti = "Iam confused";






      }

final String msg = emoti;




      DatabaseReference myRef7 = database.getReference("users/user/"+userid);

      myRef7.addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              dataSnapshot.child(relation);
              try {
                  SmsManager smsManager = SmsManager.getDefault();
                  ArrayList<String> messageParts = smsManager.divideMessage(msg);
                  smsManager.sendMultipartTextMessage(String.valueOf(dataSnapshot.child(relation)), null, messageParts, null, null);
                  Toast.makeText(getContext(), "Message Sent",
                          Toast.LENGTH_LONG).show();
              } catch (Exception ex) {
                  Toast.makeText(getContext(), ex.getMessage().toString(),
                          Toast.LENGTH_LONG).show();
                  ex.printStackTrace();
              }
          }
          @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {
          }
      });
  }
}
