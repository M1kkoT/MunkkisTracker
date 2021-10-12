package com.example.munkkistracker;


/**
 * @author Kerttu Kyyrä
 * Laskija-luokka laskutoimituksille
 * viisi luokkamuuttujaa , hinnalle, kaloreille, rasvalle, sokerille ja kappalemäärälle
 * konstruktori
 * @param munkki Munkki-rajapinnan toteuttava olio
 * @param hinta munkkien hinta
 * @param lukum munkkien lukumäärä
 * metodit
 * getCost()
 * @return palauttaa kokonaishinnan (hinta * kappalemäärä) (double)
 * getKcal()
 * @return palauttaa kalorimäärän (kalorimäärä * kappalemäärä) (int)
 * getfat()
 * palauttaa kokonaisrasvamäärän (kalorimäärä * kappalemäärä) (double)
 * geSugar()
 * palauttaa kokonaissokerimäärän (sokerimäärä * kappalemäärä) (double)
 * getKpl()
 * palauttaa kappalemäärän (ei käytetä tällä hetkellä mihinkään) (double(koska sovellus hyväksyy käyttäjältä osittaisia munkkeja esim. puolikkaita))
 * toString()
 * palauttaa tekstin, joka kertoo kaikkien edellämainittujen tietojen arvot
 *
 */

public class Counter {
    private double cost;
    private int kcal;
    private double fat;
    private double sugar;
    private double kpl;


    public Counter(Munkki munkki, double hinta, double lukum) { //konstruktori saa parametreinä munkin, kplhinnan ja lukumäärän
        this.cost = hinta;
        this.kpl = lukum;
        this. kcal = munkki.getKcal();
        this.fat = munkki.getRasva();
        this.sugar = munkki.getSokeri();
    }

    public double getCost() {
        return cost * kpl;
    }

    public int getKcal() {
        return (int)(kcal * kpl);
    }

    public double getFat() {
        return fat * kpl;
    }

    public double getSugar() {
        return sugar * kpl;
    }

    public double getKpl() {
        return kpl;
    }

    @Override
    public String toString() {
        return "cost=" + cost +
                ", kcal=" + kcal +
                ", fat=" + fat +
                ", sugar=" + sugar +
                ", kpl=" + kpl;
    }
}
