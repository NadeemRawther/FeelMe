package com.example.feelme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFrag extends Fragment {
    public static final String DEVELOPER_KEY =  "AIzaSyDXzWPBNo05rtn7442jgMmklYgJxYckpq0";
    public static final String YOUTUBE_VIDEO_CODE = "_oEA18Y8gM0";
    private YouTubePlayerView youTubeView;
    YouTubePlayerFragment youTubePlayerFragment;
    public VideoFrag() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        youTubeView = (YouTubePlayerView) view.findViewById(R.id.youtube_view);
youTubeView.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(YOUTUBE_VIDEO_CODE);
        youTubePlayer.play();
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
});



        return view;
    }


}
