package com.example.voltify;

import android.content.Intent;

import androidx.viewpager.widget.PagerTabStrip;

import java.util.ArrayList;

public class GestioneBrani {
    ArrayList<Brano> brani;  //dichiaro un arrayList di oggetti di tipo "Brano"

    public GestioneBrani()  {
        brani=new ArrayList<Brano>();
    }  //costruttore classe GestioneBrano

    public void addBrano(String titolo, String autore, String genere, int durata) {
            Brano br = new Brano(titolo, autore, genere, durata); //istanzio un oggetto della xlasse Brano
            brani.add(br);  //aggiungo all'arrayList l'oggetto precedentemente istanziato
    }

    public String mostraBrani() {
        StringBuilder sb = new StringBuilder();  //istanzio un oggetto della classe StringBuilder
        for (Brano s : brani)   //scorre l'ArrayList contenente i brani aggiunti, s assume ad ogni ciclo il valore del brano che si trovava in quella posizione dell'arrayList
        {
            sb.append(s.getTitolo().toString());   //attacca all'oggetto sb il titolo del brano
            sb.append(",");
            sb.append(s.getAutore().toString());   //attacca all'oggetto sb l'auotore del brano
            sb.append(",");
            sb.append(s.getGenere().toString());   //attacca all'oggetto sb il genere del brano
            sb.append(",");
            sb.append(s.getDurata().toString());
            sb.append("\n");   //attacca ad sb i caratteri "/n" per andare a capo ogni volta che un brano dell'array list è stato aggiunto
        }
        return sb.toString();  //restituisco il contenuto dell'oggetto sb
    }
}

