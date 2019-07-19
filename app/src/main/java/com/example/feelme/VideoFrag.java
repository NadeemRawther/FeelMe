package com.example.feelme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFrag extends Fragment implements YouTubePlayer.OnInitializedListener  {

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
        youTubePlayerFragment= (YouTubePlayerSupportFragment)v.findViewById(R.id.youtube_player_fragment);
        youTubePlayerFragment.initialize(DEVELOPER_KEY, (YouTubePlayer.OnInitializedListener) getActivity());
        return v;
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(YOUTUBE_VIDEO_CODE);
        youTubePlayer.play();



    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {


    }
}
