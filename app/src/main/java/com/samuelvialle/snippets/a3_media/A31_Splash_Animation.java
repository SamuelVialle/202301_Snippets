package com.samuelvialle.snippets.a3_media;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.samuelvialle.snippets.R;

public class A31_Splash_Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a31_splash_animation);

        ImageView imageView = findViewById(R.id.ivSplash);

        imageView.animate().alpha(1).rotation(3600).setDuration(2000);
    }
}