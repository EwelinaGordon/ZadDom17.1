package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/produkty") //lepiej GetMapping bo chcemy zaciesniac i wiemy ze uzytkownik bedzie dzialal z poziomu przegladarki
    public String wyswietlProdukty(Model model) {
        List<Produkt> produkty = productRepository.getProdukty();

        double price = 0;
        for (Produkt produkt : produkty) {
            price += produkt.getCena();
        }

        model.addAttribute("produkty", produkty);
        model.addAttribute("suma", price);

        return "listaproduktow";
    }

    @GetMapping("/rodzaj")
    public String wyswietlProduktyKategorii(Model model, @RequestParam (value="kategoria") Kategoria kategoria) {
        List<Produkt> produktyWKategorii = productRepository.getProduktyWKategorii(kategoria);

        double price = 0;

        for (Produkt produkt : produktyWKategorii) {
            price += produkt.getCena();
        }

        model.addAttribute("produktyKat", produktyWKategorii);
        model.addAttribute("suma", price);

        return "listaproduktowkategoria";
    }

    @PostMapping("/add")
    public String dodajProdukt(@RequestParam(value="nazwa") String nazwa, @RequestParam(value="cena") Double cena, @RequestParam(value="kategoria") String kategoria){
        Produkt prd = new Produkt(nazwa, cena, Kategoria.valueOf(kategoria));
        boolean isAdded = productRepository.add(prd);
        if(isAdded) {
            return "redirect:success";
        }
        return "redirect:blad";
    }

    @GetMapping("/success")
    public String success() {
        return "success.html";
    }

    @GetMapping("/blad")
    public String error() {
        return "error.html";
    }
}