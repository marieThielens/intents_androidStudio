package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnEntrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // récupérer mes éléments
        btnEntrer = findViewById(R.id.bouton_accueil_renter);

        // Ecouter mon bouton
        btnEntrer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnEntrer) {
            Intent intent = new Intent(getApplicationContext(), ConnectActivity.class);
            startActivity(intent); // demarrer l'activité
            finish();
        }
    }
}