package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView questionCouleur;
    private Button btnRose, btnBleu, btnAmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Référencer mes élements
        questionCouleur = findViewById(R.id.couleur_question_phrase);
        btnRose = findViewById(R.id.btn_choix_rose);
        btnBleu = findViewById(R.id.btn_choix_bleu);
        btnAmi = findViewById(R.id.btn_choix_ami);

        // récupérer l'intent envoyé depuis connect
        Bundle extra = this.getIntent().getExtras();
        String data = extra.getString("nom");

        String.format(getString(R.string.titre_couleur_question), data);

       //  Toast.makeText(getApplicationContext(), data , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), ConnectActivity.class);


        if(v == btnRose) {

        } else if (v == btnBleu) {

        } else if (v == btnAmi) {

        }
    }
}