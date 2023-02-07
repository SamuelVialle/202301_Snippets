package com.samuelvialle.snippets.a5_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.samuelvialle.snippets.R;

public class A51_ListView extends AppCompatActivity {

    private final String[] listeStagiaires = new String[]{
            "Imothepu", "Tri", "Inan", "Jason", "Mathias", "Nicolas", "Pierre 1", "Yacouba", "Philippe", "Pierre 2", "Michel" };

    private void afficheListView(){
        // Le lien le design et le java
        ListView listView = findViewById(R.id.lvListView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_checked, listeStagiaires);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valItem = (String) listView.getItemAtPosition(position);
                Toast.makeText(A51_ListView.this, "Le stagiaire : " + valItem, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a51_list_view);
        afficheListView(); // Appel de la méthode pour afficher le listView
    }
}