package com.samuelvialle.snippets.a4_media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.SeekBar;

import com.samuelvialle.snippets.R;

import java.util.Timer;
import java.util.TimerTask;

public class A41_Audio_Auto extends AppCompatActivity {

    /** 1 Lancement automatique du morceau de musique au chargement de la page, parfait pour un
     * fond sonore pour un splash screen **/
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_a41_audio_auto);
//
//        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.mp_audio_uptown_funk);
//        mediaPlayer.start();
//    }

    /** 2 Média player avec contrôle **/
    /**
     * VARIABLES GLOBALES
     **/
    // Variable du Mediaplayer
    MediaPlayer mediaPlayer;

    /**
     * MÉTHODES PERSO
     **/
    // Méthode de gestion pour le bouton Play
    public void myPlay(View view) {
        mediaPlayer.start();
    }

    // Méthode de gestion pour le bouton Pause
    public void myPause(View view) {
        mediaPlayer.pause();
    }

    // Méthode pour la gestion de la position
    private void position(){
        SeekBar sbPosition = findViewById(R.id.sbPosition); // Lien entre le design et le java
        sbPosition.setMax(mediaPlayer.getDuration());

        sbPosition.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                myPause(sbPosition);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                myPlay(sbPosition);
                mediaPlayer.seekTo(sbPosition.getProgress());
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // ce que l'on veut faire
                sbPosition.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 300);
    }

    /**
     * MÉTHODES DU CYCLE DE VIE
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a41_audio_auto);

        // 2.2 Valorisation du MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.mp_audio_uptown_funk);

        position();

        // == Volume
        SeekBar sbVolume = findViewById(R.id.sbVolume);
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Le volume max du téléphone
        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        sbVolume.setMax(volumeMax);

        // Le volume actuel sélectionné par l'utilisateur
        int volumeCurrent = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        sbVolume.setProgress(volumeCurrent);

        // La gestion des événements de la seekbar
        sbVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}