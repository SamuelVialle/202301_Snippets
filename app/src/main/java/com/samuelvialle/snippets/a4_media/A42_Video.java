package com.samuelvialle.snippets.a4_media;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.samuelvialle.snippets.R;

public class A42_Video extends AppCompatActivity {

    /** VARS GLOBALES **/
    VideoView vvVideo;
    MediaController mediaController;
    int position;

    /** MÉTHODES PERSO **/
    private void initUI(){
        vvVideo = findViewById(R.id.vvVideo);
        String uriPath = ("android.resource://" + getPackageName() + "/raw/" + R.raw.mp_ts_drunk);
        Uri uri = Uri.parse(uriPath);
        vvVideo.setVideoURI(uri);
    }


    // Phase un lancement sans contrôle
    private void phase1_sansControle(){
        initUI();
        vvVideo.start();
    }

    // Phase 2 avec controle
    private void phase2_avecControle(){
        initUI();

        if(this.mediaController == null){
            this.mediaController = new MediaController(A42_Video.this);
        }

        mediaController.setAnchorView(vvVideo);
        vvVideo.setMediaController(mediaController);
    }

    private void seekToPositionInVideo(){
        vvVideo.seekTo(position);
        vvVideo.start();
    }

    // Gestion de l'enregistrement de la position après la mise le passage par la méthode onPause
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CurrentPosition", position);
        vvVideo.pause();
    }

    // Gestion de la position après rotation
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("CurrentPosition");
        seekToPositionInVideo(); // Après rotation
    }

    // Gestion du mode plein écran
    // Cf Manifest pour la configuration de l'orientation et de la taille de l'écran
    // On commence par initialiser un objet de type Configuration
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a42_video);
//        phase1_sansControle();
        phase2_avecControle();
    }

    @Override
    protected void onStart() {
        super.onStart();
        seekToPositionInVideo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        position = vvVideo.getCurrentPosition();
    }
}