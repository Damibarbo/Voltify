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

    public String getTitle() {
        return titolo;
    }
    public void setTitle(String title) {
        this.titolo = titolo;
    }
    public String getArtist() {
        return autore;
    }
    public void setArtist(String artist) {
        this.autore = autore;
    }
    public String getGenre() {
        return genere;
    }
    public void setGenre(String genre) {
        this.genere = genere;
    }
    public Integer getDuration() { return durata; }
    public void setDuration(Integer duration) {
        this.durata = durata;
    }
}
