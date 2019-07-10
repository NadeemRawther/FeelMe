package com.example.feelme.userinterface;

import android.app.AlertDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.feelme.R;

public class MainPage extends Fragment  {
    ImageView mother,father,sister,brother,uncle,aunty,grandpa,grandma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_video, container, false);
        mother = (ImageView) view. findViewById(R.id.mother);
        father = (ImageView)view.findViewById(R.id.father);
        sister = (ImageView)view.findViewById(R.id.sis);
        brother = (ImageView)view.findViewById(R.id.bro);
        uncle = (ImageView)view.findViewById(R.id.uncle);
        aunty = (ImageView)view.findViewById(R.id.aunty);
        grandpa = (ImageView)view.findViewById(R.id.grandpa);
        grandma = (ImageView)view.findViewById(R.id.grandma);



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
        return
    }



  public void createEmoji(View v){
      AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
      View mView = View.inflate(getActivity(),R.layout.emoji_layout,null);
      builder.setView(mView);
      final AlertDialog alertDialog = builder.create();
      alertDialog.show();
  }
}
