package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConnectActivity extends AppCompatActivity {

    private TextView titre;
    private EditText nom, prenom;
    private Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        titre = findViewById(R.id.titre_connect);
        nom = findViewById(R.id.nom_main);
        prenom = findViewById(R.id.prenom_main);
        btnConnect = findViewById(R.id.btn_connect);

        btnConnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                intent.putExtra("nom", nom.getText().toString());
                intent.putExtra("prenom", prenom.getText().toString());

                startActivity(intent);
            }
        });
    }
}