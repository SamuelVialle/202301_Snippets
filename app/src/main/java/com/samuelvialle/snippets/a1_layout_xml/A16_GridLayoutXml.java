package com.samuelvialle.snippets.a1_layout_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.samuelvialle.snippets.R;

public class A16_GridLayoutXml extends AppCompatActivity {

    private static final String TAG = "A16_GridLayoutXml";

    public void playSound(View view){
        Button boutonPresse = (Button) view;
        String tag = boutonPresse.getTag().toString();
        Log.i(TAG, "playSound: " + tag);

        MediaPlayer mediaPlayer = MediaPlayer.create(this,
                getResources().getIdentifier(tag, "raw", getPackageName()));

        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a16_grid_layout_xml);
    }
}