package com.example.munkkistracker;

/**
 * Berliininmunkki-luokka toteuttaa rajapinnan Munkki
 * Konstruktori
 * asettaa arvot berliininmunkin oliomuuttujille (fat, sugar, cal)
 *
 * metodit
 * getRasva()
 * @return palauttaa berliininmunkin oliomuuttujan rasva (fat) arvon (15)
 * getKcal()
 * @return palauttaa berliininmunkin oliomuuttujan kalori (kcl) arvon (405)
 * getSokeri()
 * @return palauttaa berliininmunkin oliomuuttujan sokekeri (sugar) arvon (36)
 * toString
 * @return palauttaa String "Berliininmunkki"
 */

public class Berliininmunkki implements Munkki{ //luokka berliininmunkin tiedoille
    private double fat;
    private double sugar;
    private int cal;

    public Berliininmunkki(){
        this.fat = 15;
        this.sugar = 36;
        this.cal = 405;
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
        return "Berliininmunkki";
    }
}
