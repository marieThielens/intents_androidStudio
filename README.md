# Java. Utils - 

Récuperer les inputs de l'utilisateur. Le saluer et lui poser une question. 
Avoir la possibilité de passer un coup de fil

## Juste un bouton pour changer d'activité ( de page )

### Fichier MainActivity.java

- implement View.onClickListener 
- Déclarer mon bouton récupérer l'id de mon bouton crée dans le layout ( activity_main.xml) 
- Ecouter le bouton
- Lancer activité sur le clic du bouton

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Déclarer ma variable
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
            // Creation d'un intent pour ouvrir l'activité ConnectActivity.java
            Intent intent = new Intent(getApplicationContext(), ConnectActivity.class);
            startActivity(intent); // demarrer l'activité
            finish(); 
        }
    }
}
``` 


### Fichier ConnectActivity.java

```java
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
    
            btnConnect.setOnClickListener(v -> {
    
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                intent.putExtra("nom", nom.getText().toString());
                intent.putExtra("prenom", prenom.getText().toString());
    
                startActivity(intent);
                finish();
            });
        }
    }
````

```
   btnConnect.setOnClickListener(v -> { 
```
est l'équivalant d'écrire 
````
btnConnect.setOnClickListener(new View.OnClickListener() {
````

### Le fichier QuestionActivity.java. Faire un choix entre 3 éléments. Pouvoir passer un coup de fil

! Il faut donner la permission dans le manifest juste après la balise manifest
```
 <uses-permission android:name="android.permission.CALL_PHONE" />
```

```java
package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{
    public TextView questionCouleur;
    public Button btnRose, btnBleu, btnAmi;

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

        String saluer = String.format(getString(R.string.titre_couleur_question), data);

       //  Toast.makeText(getApplicationContext(), data , Toast.LENGTH_LONG).show();

        // Ecouter les boutons
        btnRose.setOnClickListener(this);
        btnBleu.setOnClickListener(this);
        btnAmi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == btnRose) {
            Toast.makeText(getApplicationContext(), "Le bleu c'est aussi joli" , Toast.LENGTH_LONG).show();
        } else if (v == btnBleu) {
            Toast.makeText(getApplicationContext(), "Le rose c'est aussi joli" , Toast.LENGTH_LONG).show();
        } else if (v == btnAmi) {

            Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
            // Téléphoner
            Uri numTelephone = Uri.parse("tel:0494275721");
            Intent telIntent = new Intent(Intent.ACTION_DIAL, numTelephone);
            startActivity(telIntent);
          //  Toast.makeText(getApplicationContext(), "Le rose c'est aussi joli" , Toast.LENGTH_LONG).show();

        }
    }
}```











