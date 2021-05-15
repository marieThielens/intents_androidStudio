package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class QuestionActivity extends AppCompatActivity {
    private TextView questionCouleur;
    private Button btnRose, btnBleu, btnAucun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Référencer mes élements
        questionCouleur = findViewById(R.id.couleur_question_phrase);
        btnRose = findViewById(R.id.btn_choix_rose);
        btnBleu = findViewById(R.id.btn_choix_bleu);
        btnAucun = findViewById(R.id.btn_choix_stereotype);

    }
}