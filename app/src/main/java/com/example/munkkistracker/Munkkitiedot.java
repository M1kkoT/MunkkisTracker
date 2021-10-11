package com.example.munkkistracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka johon tallennetaan kaikki mahdolliset sovelluksessa tarvittavat tiedot
 * tänän luokan olio kuvaa käyttäjän yhtenä päivänä syöttämiä tietoja
 * Tämän luokan olioita tallennetaan singleton luokkaan "MunkkiList"
 * konstruktori
 * @param rasva saa double tyyppisen rasvamäärän
 * @param sokeri saa double tyyppisen sokerimäärän
 * @param kalori saa int tyyppisen kalorimäärän
 * @param cost saa double tyyppisen hinnan
 * @param paiva saa string tyyppisen päivämäärän
 * @param rating saa double tyyppisen arvostelun (luku välillä 0-5)
 * @param tyyppi saa string tyyppisen tekstin, joka kertoo mitä munkkia tallennettiin
 * @param kappale saa double tyyppisen kappalemäärän
 *
 * konstuktori tallentaa saadut tiedot luokkamuuttujiin
 * arvostelut lisätään Arraylistaan keskiarvon laskemista varten
 * konstruktori katsoo mikä munkki lisättiin munkin tyypin perusteella ja luokkamuuttuja pitävät
 *               kirjaa kuinka monta kutakin munkkia on lisätty
 *
 * metodit
 * getFat()
 * palauttaa tallennetun rasvan määrän (double)
 *
 * setFat(double fat)
 * tällä voi muokata rasvan määrää
 * @param fat rasvamäärä mikä asetetaan uudeksi arvoksi (double)
 *
 * getSugar()
 * palauttaa tallennetun sokerin määrän (double)
 *
 * setSugar(double sugar)
 * tällä voi muokata sokerin määrää
 * @param sugar sokerimäärä mikä asetetaan uudeksi arvoksi (double)
 *
 * getCal()
 * palauttaa tallennettujen kalorien määrän (int)
 *
 * setCal(int cal)
 * tällä voi muokata kalorien määrää
 * @param cal kalorimäärä mikä lasetetaan uudeksi arvoksi (int)
 *
 * getHinta()
 * palauttaa tallennetun hinnan (double)
 *
 * setHinta(double hinta)
 * tällä voi muokata hintaa
 * @param hinta hinta mikä asetetaan uudeksi arvoksi (double)
 *
 * getPvm()
 * palauttaa tallennetun päivämäärän (String)
 *
 * getArvostelu()
 * palauttaa keskiarvon Arraylist ratingslistalle tallennetuista arvosteluista
 *
 * addArvostelu(double arvostelu)
 * metodi lisää ratingslist Arraylistalle uuden arvostelun
 * @param arvostelu arvostelu (0-5) mikä lisätään ratingslistalle (double)
 *
 * getBerlin()
 * palauttaa tallennettujen berliininmunkkien määrän (double)
 *
 * getHillo()
 * palauttaa tallennettujen hillomunkkien määrän (double)
 *
 * getRinkila()
 * palauttaa tallennettujen munkkirinkilöiden määrän(double)
 *
 * addMunkkiKpl(String munkki, double kpl)
 * tällä metodilla voi lisätä tiettyä munkkia luokkamuuttujiin
 * @param munkki teksti, joka kertoo, mitä munkkia lisätään
 *               ("berliininmunkki", "hillomunkki" tai "sokerimunkki") **tällä hetkellä sovellus tukee vain kolmea munkkityyppiä
 * @param kpl kappalemäärä kuinka monta munkkia lisätään tietoihin (double)
 *
 */

public class Munkkitiedot { //luokka johon tallennetaan tiedot ja joka tallennetaan singleton luokkaan
    private double fat;
    private double sugar;
    private int cal;
    private double hinta;
    private String pvm;
    private ArrayList<Double> ratingslist;
    private double berlin = 0;
    private double hillo = 0;
    private double rinkila = 0;

    public Munkkitiedot(double rasva, double sokeri, int kalori , double cost, String paiva, //konstruktori
                        double rating, String tyyppi, double kappale){
        this.fat = rasva;
        this.sugar = sokeri;
        this.cal = kalori;
        this.hinta = cost;
        this.pvm = paiva;
        ratingslist = new ArrayList<>(); //lista arvosteluista keskiarvon laskemista varten
        ratingslist.add(rating);
        if (tyyppi.equals("Berliininmunkki")){ //katsoo mikä munkki lisättiin myöhempää laskentaa varten
            this.berlin += kappale;
        } else if (tyyppi.equals("Hillomunkki")){
            this.hillo += kappale;
        }else if (tyyppi.equals("Munkkirinkila")){
            this.rinkila += kappale;
        }
    }

    public double getFat() {
        return fat;
    }

    public double getSugar() {
        return sugar;
    }

    public int getCal() {
        return cal;
    }

    public double getHinta() {
        return hinta;
    }

    public String getPvm() {
        return pvm;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    public void addArvostelu(double arvostelu) {
        this.ratingslist.add(arvostelu);

    }

    public double getArvostelu() { //palauttaa keskiarvon arvosteluista
        if (ratingslist.size() > 1){
            double summa = 0;
            for (double i : ratingslist){
                summa += i;
            }
            double ka = (double) (summa / ratingslist.size());
            return ka;

        } else {
            return ratingslist.get(0); //jos arvosteluja on vain yksi
        }
    }

    public double getBerlin() {
        return berlin;
    }

    public double getHillo() {
        return hillo;
    }

    public double getRinkila() {
        return rinkila;
    }

    public void addMunkkiKpl(String munkki, double kpl){
        if (munkki.equals("Berliininmunkki")){
            this.berlin += kpl;
        } else if (munkki.equals("Hillomunkki")){
            this.hillo += kpl;
        }else if (munkki.equals("Munkkirinkila")){
            this.rinkila += kpl;
        }

    }


}
