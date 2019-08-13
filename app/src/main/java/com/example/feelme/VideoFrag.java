package com.example.feelme;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 */


public class VideoFrag extends Fragment {
    public static final String DEVELOPER_KEY =  "AIzaSyDXzWPBNo05rtn7442jgMmklYgJxYckpq0";
    public static final String YOUTUBE_VIDEO_CODE = "_oEA18Y8gM0";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users/videos");

    ArrayList<String> arrayList;
    public VideoFrag() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.card_video, container, false);
        final RecyclerView labourcycle = v.findViewById(R.id.recyclerforcycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        labourcycle.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                  Log.e("RadioVideos",dataSnapshot1.getValue().toString());
                  arrayList.add(dataSnapshot1.getValue().toString());
              }
               //AdapterForYou reviewAdapter = new AdapterForYou(getActivity(),arrayList);
              //labourcycle.setAdapter(reviewAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return v;
    }
}
