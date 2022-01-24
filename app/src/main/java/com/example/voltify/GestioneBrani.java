package com.example.voltify;

import android.content.Intent;

import androidx.viewpager.widget.PagerTabStrip;

import java.util.ArrayList;

public class GestioneBrani {
    ArrayList<Brano> brani;

    public GestioneBrani()  {
        brani=new ArrayList<Brano>();
    }

    public void addBrano(String titolo, String autore, String genere, int durata) {
            Brano br = new Brano(titolo, autore, genere, durata);
            brani.add(br);
    }

    public String mostraBrani() {
        StringBuilder sb = new StringBuilder();
        for (Brano s : brani)
        {
            sb.append(s.getTitolo().toString());
            sb.append(s.getAutore().toString());
            sb.append(s.getGenere().toString());
            sb.append("\t");
        }
        return sb.toString();
    }
}
