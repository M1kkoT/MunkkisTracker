package com.example.munkkistracker;

/**
 * Munkkirinkila-luokka toteuttaa rajapinnan Munkki
 * Kontruktori
 * asettaa arvot Munkkirinkilan oliomuuttujille (fat, sugar, cal)
 *
 * metodit
 * getRasva()
 * @return palauttaa munkkirinkilan oliomuuttujan rasva (fat) arvon (14)
 * getKcal()
 * @return palauttaa munkkirinkilan oliomuuttujan kalori (kcl) arvon (328)
 * getSokeri()
 * @return palauttaa munkkirinkilan oliomuuttujan sokeri (sugar) arvon (7)
 * toString()
 * @return palauttaa String "Munkkirinkila"
 */

public class Munkkirinkila implements Munkki{ //luokka munkkirinkilän tiedoille
    private double fat;
    private double sugar;
    private int cal;

    public Munkkirinkila() {
        this.cal = 328;
        this.fat = 14;
        this.sugar = 7;
    }

    @Override
    public double getRasva() {
        return this.fat;
    }

    @Override
    public int getKcal() {
        return this.cal;
    }

    @Override
    public double getSokeri() {
        return this.sugar;
    }

    @Override
    public String toString() {
        return "Munkkirinkila";
    }
}
