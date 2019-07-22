package com.example.feelme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;



/**
 * A simple {@link Fragment} subclass.
 *
 */
public class VideoFrag extends Fragment implements YouTubePlayer.OnInitializedListener {
    public static final String DEVELOPER_KEY =  "AIzaSyDXzWPBNo05rtn7442jgMmklYgJxYckpq0";
    public static final String YOUTUBE_VIDEO_CODE = "_oEA18Y8gM0";
    private YouTubePlayerView youTubeView;
    private YouTubePlayerSupportFragment youTubePlayerFragment;
    private YouTubePlayer youTubePlayer;
    YouTubePlayerFragment myYouTubePlayerFragment;
    public VideoFrag() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video, container, false);
        YouTubePlayerSupportFragment youtubePlayerFragment = new YouTubePlayerSupportFragment();
        youtubePlayerFragment.initialize(DEVELOPER_KEY, this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragment,youtubePlayerFragment);
        fragmentTransaction.commit();

        return v;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
youTubePlayer.loadVideo(YOUTUBE_VIDEO_CODE);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
