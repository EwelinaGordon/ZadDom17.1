package com.example.demo;

public enum Kategoria {

    SPOZYWCZE("Art. spożywcze"),
    GOSP_DOM("Art. gosp. domowego"),
    INNE("Inne");

    private final String description;

    Kategoria(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }




}


