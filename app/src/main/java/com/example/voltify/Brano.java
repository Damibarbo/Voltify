package com.example.voltify;

public class Brano {
    private String titolo;
    private String autore;
    private String genere;
    private Integer durata;

    public Brano(String titolo, String autore, String genere, Integer durata) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.durata = durata;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }
}
