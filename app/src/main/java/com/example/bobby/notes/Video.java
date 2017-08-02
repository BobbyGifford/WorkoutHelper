package com.example.bobby.notes;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Video extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    static final String GOOGLE_API_KEY = "AIzaSyBrpVTj1uKL-uXYW-fnc1HlfqBXio34oYo";
    static final String VIDEO_ID = "U-OKDttXQE0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayer);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST = 1;

        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this, REQUEST).show();
        } else{
            String error = String.format("There is an error (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }

    }
}
