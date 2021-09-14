package com.e.cobanavbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    ImageView newsImage;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        newsImage = findViewById(R.id.imagenews);
        newsImage.setAnimation(animation);
        newsImage.animate().translationY(2350).setDuration(1500).setStartDelay(2100);
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(),Register.class));
            finish();
        },4000L);

    }
}