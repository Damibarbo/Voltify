package com.example.voltify;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GestoreFile {
    public String esporta(String fileName, String contenuto, Context c) {
        String esito = "";  //poichè questo metodo crea o scrive (in caso esista già) un file non ha un responso grafico sul successo dell'operazione ed è quindi necessario restituire una stringa che contenga dei messaggi riguardanti il successo o fallimento dell'operazuone di scrittura
        FileOutputStream fileO;

        try {
            fileO = c.openFileOutput(fileName, Context.MODE_PRIVATE);  //apro il file all'interno di fileO
            fileO.write(contenuto.getBytes()); //scrivo nel file il contenuto della stringa str convertendolo però in bytes
            fileO.close(); //chiudo il file altrimenti potrei incappare in errori
            esito = "Esportazione contenuto nel file avvenuta con successo";  //memorizzo nella stringa esito un messaggio di successo
        }

        catch (FileNotFoundException e) {
            Log.e("MainActivity", "il file non esiste");
            e.printStackTrace();
            esito = "Il file a cui si vuole accedere non esiste"; //memorizzo nella stringa esito il messaggio del fallimento e la motivazione
        }

        catch (IOException e) {
            Log.e("MainActivity", "errore di I/O");
            e.printStackTrace();
            esito = "Impossibile gestire le operazioni di input o output"; //memorizzo nella stringa esito il messaggio del fallimento e la motivazione
        }
        return esito;
    }

    public String importa(Context c) {
        AssetManager am= c.getAssets();
        StringBuilder sb = new StringBuilder();
        try {
            InputStream fdl= am.open("qualcheBrano.txt");
            BufferedReader fileIn = new BufferedReader(new InputStreamReader(fdl));
            String riga;
            while ((riga = fileIn.readLine()) != null) {  //ciclo while che scorre il file riga per riga ed assegma il valore della riga a fileOut, il ciclo continua fino a che non si arriva alla fine del file quando fileOut sarà null
                sb.append(riga + "\n");  //Ogni riga letta dal file viene "appesa" assieme al carattere /n che permette di andare a capo nell'oggetto sb così, in questo modo sb avrà lo stesso contemuto del file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public Brano leggiJson(Context c) throws JSONException {
        Resources res;
        StringBuilder sb = new StringBuilder();
        res=c.getResources();
        InputStream fdl;
        fdl= res.openRawResource(R.raw.canzoni);
        String contenutoFile;
        try {
            BufferedReader fileIn = new BufferedReader(new InputStreamReader(fdl));
            String riga;
            while ((riga = fileIn.readLine()) != null) {  //ciclo while che scorre il file riga per riga ed assegma il valore della riga a fileOut, il ciclo continua fino a che non si arriva alla fine del file quando fileOut sarà null
                sb.append(riga + "\n");  //Ogni riga letta dal file viene "appesa" assieme al carattere /n che permette di andare a capo nell'oggetto sb così, in questo modo sb avrà lo stesso contemuto del file
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        contenutoFile=sb.toString();
        JSONObject jsonRoot = new JSONObject(contenutoFile);
        String nome=jsonRoot.getString("Nome");
        String autore=jsonRoot.getString("Autore");
        String genere=jsonRoot.getString("Genere");
        int durata=jsonRoot.getInt("Durata");

        Brano br=new Brano(nome,autore,genere,durata);

        return br;
    }
}
