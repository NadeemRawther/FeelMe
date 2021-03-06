package com.example.feelme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class AdapterForYou extends RecyclerView.Adapter<AdapterForYou.ViewHolder> implements YouTubePlayer.OnInitializedListener  {
    Context context;
    ArrayList<String> arraylist;
    TextView titles,detail,place;

    RatingBar ratingBar;
    public static final String DEVELOPER_KEY =  "AIzaSyDXzWPBNo05rtn7442jgMmklYgJxYckpq0";
    public static final String YOUTUBE_VIDEO_CODE = "_oEA18Y8gM0";
    public AdapterForYou(Context context, ArrayList<String> arraylist){
        this.arraylist = arraylist;
        this.context = context;

    }
    @NonNull
    @Override
    public AdapterForYou.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        FrameLayout view = (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_video,viewGroup,false);
        return new AdapterForYou.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterForYou.ViewHolder viewHolder, final int i) {
        final WebView cardView = viewHolder.cardView;
        final Context context = cardView.getContext();

       /* YouTubePlayerSupportFragment youtubePlayerFragment = new YouTubePlayerSupportFragment();
        youtubePlayerFragment.initialize(DEVELOPER_KEY, this);
        FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragment,youtubePlayerFragment);
        fragmentTransaction.commit();
    */
        cardView.getSettings().setJavaScriptEnabled(true);
        cardView.getSettings().setPluginState(WebSettings.PluginState.ON);
        cardView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        cardView.getSettings().setSupportMultipleWindows(true);
        cardView.getSettings().setSupportZoom(true);
        cardView.getSettings().setBuiltInZoomControls(true);
        cardView.getSettings().setAllowFileAccess(true);
        cardView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                //setProgressBarIndeterminateVisibility(false);
                super.onPageFinished(view, url);
            }
        });
        cardView.loadUrl(arraylist.get(i));

        cardView.setVisibility(View.VISIBLE);




    }
    @Override
    public int getItemCount() {
        int len = arraylist.size();
        return len ;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(YOUTUBE_VIDEO_CODE);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        WebView cardView;

        public ViewHolder(View view) {
            super(view);
            cardView = (WebView) view.findViewById(R.id.frame_fragment);

        }
    }
}