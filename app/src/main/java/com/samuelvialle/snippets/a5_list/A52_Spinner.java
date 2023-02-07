package com.samuelvialle.snippets.a5_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.samuelvialle.snippets.R;

public class A52_Spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerXmlJava, spoinnerJavaJava;

    private void methodSpinnerXmlJava() {
        spinnerXmlJava = findViewById(R.id.spinnerXmlJava);
        // Récupérer la liste depuis le fichier strings
        String[] liste = getResources().getStringArray(R.array.stagiaires);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, liste);
        spinnerXmlJava.setAdapter(adapter);
        spinnerXmlJava.setOnItemSelectedListener(this);
    }

    // Spinner Java Java
    String[] itemDeLaliste = {"", "Toto", "Tata", "Tutu", "Titi"};

    private void methodSpinnerJavaJava() {
        spoinnerJavaJava = findViewById(R.id.spinnerJavajava);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(), android.R.layout.simple_list_item_1, itemDeLaliste);
        spoinnerJavaJava.setAdapter(adapter);
        spoinnerJavaJava.setOnItemSelectedListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a52_spinner);

        methodSpinnerXmlJava();
        methodSpinnerJavaJava();
    }

    final Toast myToast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch(parent.getId()){
            case R.id.spinnerXmlJava:
                myToast.setText("Spinner XML JAVA : " + spinnerXmlJava.getSelectedItem().toString());
                myToast.show();
                break;
            case R.id.spinnerJavajava:
                myToast.setText("Spinner Java Java : " + spoinnerJavaJava.getSelectedItem().toString());
                myToast.show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        myToast.setText("");
        myToast.cancel();
    }
}