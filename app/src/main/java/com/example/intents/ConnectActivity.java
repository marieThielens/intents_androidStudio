package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ConnectActivity extends AppCompatActivity {

    private TextView titre;
    private EditText nom, prenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        titre = findViewById(R.id.titre_connect);
        nom = findViewById(R.id.nom_main);
        prenom = findViewById(R.id.prenom_main);

    }
}