package com.samuelvialle.snippets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.samuelvialle.snippets.a1_layout_xml.A11_LinearLayoutXml;
import com.samuelvialle.snippets.a1_layout_xml.A12_FrameLayoutXml;
import com.samuelvialle.snippets.a4_media.A41_Audio_Auto;

public class A0_AccueilActivity extends AppCompatActivity {

    /** VARIABLES GLOBALES **/
    // Les layouts XML
    TextView tvLinearLayout, tvFrameLayout, tvRelativeLatyout;

    // L'audio
    TextView tvAudio;

    /** Méthode pour l'initialiastion des composants graphiques **/
    private void initUI(){
        // Layouts XML
        tvLinearLayout = findViewById(R.id.tvLinearLayout);
        tvFrameLayout = findViewById(R.id.tvFrameLayout);
        tvRelativeLatyout = findViewById(R.id.tvRelativeLayout);
        // Audio
        tvAudio = findViewById(R.id.tvAudio);
    }

    // Les layouts XML
    private void clicLinear(){
        tvLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A0_AccueilActivity.this, A11_LinearLayoutXml.class);
                startActivity(intent);
            }
        });
    }

    private void clicFrame(){
        tvFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(A0_AccueilActivity.this, A12_FrameLayoutXml.class);
                // Ici on peut faire transiter des informations
                startActivity(intent);
            }
        });
    }

    // L'audio
    private void clicAudio(){
        tvAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(A0_AccueilActivity.this, A41_Audio_Auto.class));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a0_accueil);

        initUI(); // appel de la méthode d'initialisation des composants
        // Les layouts XML
        clicLinear();
        clicFrame();
        // L'audio
        clicAudio();

    }

}