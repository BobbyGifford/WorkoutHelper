package com.example.bobby.notes;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHandler.getExercises();

        EasySplashScreen splashScreen = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(2000)
                .withBackgroundColor(Color.parseColor("#74d0e0"))
                .withBeforeLogoText("Workout")
                .withLogo(R.mipmap.ic_launcher_round)
                .withAfterLogoText("Buddy");
        View view = splashScreen.create();

        setContentView(view);
    }


}
