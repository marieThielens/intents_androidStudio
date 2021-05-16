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
``
btnConnect.setOnClickListener(new View.OnClickListener() {`
````







