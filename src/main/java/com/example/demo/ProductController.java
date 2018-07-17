package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ResponseBody
    @RequestMapping("/produkty")
    public String wyswietlProdukty() {
        List<Produkt> produkty = productRepository.getProdukty();

        String listaProduktow = "";
        double price = 0;
        for (Produkt produkt : produkty) {

            listaProduktow += produkt.toString() + "<br>";
            price += produkt.getCena();
        }
        return listaProduktow + "</br>" + "Cena wszystkich produktów: " + price;
    }

    @RequestMapping("/rodzaj")
    @ResponseBody
    public String wyswietlProduktySpozywcze(HttpServletRequest request) {
        Kategoria kategoria = Kategoria.valueOf(request.getParameter("kategoria"));

        List<Produkt> produktyWKategorii = productRepository.getProduktyWKategorii(kategoria);

        String listaProduktow = " ";
        double price = 0;

        for (Produkt produkt : produktyWKategorii) {
            listaProduktow += produkt.toString() + "</br>";
            price += produkt.getCena();
        }
        return listaProduktow + "</br>" + "Cena wszystkich produktów: " + price;
    }

    @RequestMapping("/add")
    public String dodajProdukt(HttpServletRequest request){
        String nazwa = request.getParameter("nazwa");
        String cena = request.getParameter("cena");
        String kategoria = request.getParameter("kategoria");

        Produkt prd = new Produkt(nazwa, Double.parseDouble(cena), Kategoria.valueOf(kategoria));
        boolean isAdded = productRepository.add(prd);

        if(isAdded) {
            return "/success.html";
        }
        return  "/error.html";
    }
}