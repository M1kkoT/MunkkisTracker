package com.example.munkkistracker;

/**
 * Hillomunkki-luokka toteuttaa rajapintaluokan Munkki
 * Konstruktori
 * asettaa arvot hillomunkin olimuuttujille (fat, sugar, cal)
 *
 * metodit
 * getRasva()
 * @return palauttaa hillomunkin oliomuuttujan rasva (fat) arvon (9)
 * getKcal()
 * @return palauttaa hillomunkin oliomuuttujan kalori (cal) arvon (241)
 * getSokeri()
 * @return palauttaa hillomunkin oliomuuttujan sokeri (sugar) arvon (16)
 * toString()
 * @return palauttaa String tekstin "Hillomunkki"
 *
 */

public class Hillomunkki implements Munkki { //luokka hillomunkin tiedoille
    private double fat;
    private double sugar;
    private int cal;

    public Hillomunkki() {
        this.fat = 9;
        this.cal = 241;
        this.sugar = 16;
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
        return "Hillomunkki";
    }
}
