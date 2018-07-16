package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Produkt> produkty;

    public ProductRepository() {

        produkty = new ArrayList<>();

        produkty.add(new Produkt("Mleko", 4.5, Kategoria.SPOZYWCZE));
        produkty.add(new Produkt("Mydło", 15, Kategoria.GOSP_DOM));
        produkty.add(new Produkt("Guziki", 24.5, Kategoria.INNE));
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public List<Produkt> getProduktyWKategorii(Kategoria kategoria) {
        List<Produkt> result = new ArrayList<>();
        for (Produkt produkt : produkty) {
            if (produkt.getKategoria().equals(kategoria)) {
                result.add(produkt);
            }
        }
        return result;
    }

    public void add(Produkt produkt){
        produkty.add(produkt);
    }
}
