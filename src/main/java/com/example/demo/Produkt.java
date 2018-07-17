package com.example.demo;

import java.util.Objects;

public class Produkt {
    private String nazwa;
    private double cena;
    private Kategoria kategoria;

    public Produkt(String name, double price, Kategoria kategoria) {
        this.nazwa = name;
        this.cena = price;
        this.kategoria = kategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return Double.compare(produkt.cena, cena) == 0 &&
                Objects.equals(nazwa, produkt.nazwa) &&
                kategoria == produkt.kategoria;
    }

    @Override
    public int hashCode() {

        return Objects.hash(nazwa, cena, kategoria);
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
