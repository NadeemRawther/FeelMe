package com.example.feelme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 */


public class VideoFrag extends Fragment {
    public static final String DEVELOPER_KEY =  "AIzaSyDXzWPBNo05rtn7442jgMmklYgJxYckpq0";
    public static final String YOUTUBE_VIDEO_CODE = "_oEA18Y8gM0";
    private YouTubePlayerView youTubeView;
    private YouTubePlayerSupportFragment youTubePlayerFragment;
    private YouTubePlayer youTubePlayer;
    YouTubePlayerFragment myYouTubePlayerFragment;
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
        AdapterForYou reviewAdapter = new AdapterForYou(getActivity(),arrayList);
        labourcycle.setAdapter(reviewAdapter);
        return v;
    }
}
