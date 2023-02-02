package com.samuelvialle.snippets.a1_layout_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.samuelvialle.snippets.R;

public class A11_LinearLayoutXml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a11_linear_layout_xml);

        // Méthode 1 - Utilisation d'un listener sur le bouton
        Button btnLinearVertical;
        btnLinearVertical = findViewById(R.id.btnLinearVertical);
        btnLinearVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Noter ici le nom de la méthode ;)
                // Le code pour l'action
                Intent intent = new Intent(A11_LinearLayoutXml.this, A11_1_LinearLayoutVerticalXml.class);
                startActivity(intent);
            }
        });
        // END Méthode 1
    }
    // Méthode 2 - L'appel de la méthode suivante est faite en utilisant l'attribut
    // onClick du XML, il s'agit de la même méthode appelée par le listener de la méthode 1
    public void gestionDuClic(View view){
        // Attacher le widget à cette méthode avec l'attribut onClick du xml
        Intent intent = new Intent(A11_LinearLayoutXml.this, A11_1_LinearLayoutVerticalXml.class);
        startActivity(intent);
    }
}