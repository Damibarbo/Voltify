package com.example.voltify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText titolo, autore, durata;   //credo variabili di tipo EditText
    Button inserisci, mostra;   //creo variabili di tipo button
    Spinner genere;  //creo una variabile di tipo Spinner
    GestioneBrani songManager = new GestioneBrani();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titolo = findViewById(R.id.titoloCanzone); //assegno alla variabile titolo la view che ha come id "titoloCanzone"
        autore = findViewById(R.id.autoreCanzone); //assegno alla variabile autore la view che ha come id "autoreCanzone"
        genere = findViewById(R.id.genereCanzone); //assegno alla variabile genere la view che ha come id "genereCanzone"
        durata = findViewById(R.id.durataCanzone); //assegno alla variabile durata la view che ha come id "durataCanzone"
        inserisci = findViewById(R.id.inserisci);  //assegno alla variabile inserisci la view che ha come id "inserisci"
        mostra = findViewById(R.id.mostra);        //assegno alla variabile mostra la view che ha come id "mostra"
        GestioneBrani gb = new GestioneBrani();   // istanzio un oggetto della classe GestioneBrani

        inserisci.setOnClickListener(new View.OnClickListener() {  //imposto un ascoltatore evento onClick sul bottone inserisci
            @Override
            public void onClick(View v) {   //questa è la funzione che verrà richiamata quando l'ascoltatoremrileverà un click del bottone mostra
                gb.addBrano(titolo.getText().toString(), autore.getText().toString(), genere.getSelectedItem().toString(), Integer.getInteger(durata.getText().toString()));  //richiama la funzione addBrano dalla classe GestioneBrani passando come parametri i valori inseriti dall'utente nelle editText e o Spinner
            }
        });

        mostra.setOnClickListener(new View.OnClickListener() { //imposto un ascoltatore evento onClick sul bottone mostra
            @Override
            public void onClick(View v) { //questa è la funzione che verrà richiamata quando l'ascoltatoremrileverà un click del bottone inserisci
                Intent i = new Intent(MainActivity.this, SecondaActivity.class);   //Istanzio un oggetto della classe Intent passando come contesto la MainActivity e come Activity da lanciare SecondaActivity
                i.putExtra("brani", gb.mostraBrani());  //utilizzo putExtra per passare il risultato del metodo mostraBrani alla seconda activity impostando a questo messaggio l'etichetta brani
                startActivity(i);   //lancio la seconda activity
            }
        });

    }
}
