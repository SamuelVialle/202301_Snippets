package com.samuelvialle.snippets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class A51_ListView extends AppCompatActivity {

    private final String[] listeStagiaires = new String[]{
            "Imothepu", "Tri", "Inan", "Jason", "Mathias", "Nicolas", "Perre 1", "Yacouba", "Philippe", "Pierre 2", "Michel" };

    private void afficheListView(){
        // Le lien le design et le java
        ListView listView = findViewById(R.id.lvListView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_checked, listeStagiaires);

        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a51_list_view);

        afficheListView(); // Appel de la méthode pour afficher le listView
    }
}