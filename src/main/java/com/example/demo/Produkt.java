package com.example.demo;

public class Produkt {
    private String nazwa;
    private double cena;
    private Kategoria kategoria;

    public Produkt(String name, double price, Kategoria kategoria) {
        this.nazwa = name;
        this.cena = price;
        this.kategoria = kategoria;
    }

    public double getCena() {
        return cena;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    @Override
    public String toString() {
        return "Produkt: " + nazwa + ", cena:  " + cena + ", kategoria:  " + kategoria.getDescription();
    }
}
