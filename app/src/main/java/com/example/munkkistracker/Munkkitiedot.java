package com.example.munkkistracker;

import java.util.ArrayList;
import java.util.List;

public class Munkkitiedot { //luokka johon tallennetaan tiedot ja joka tallennetaan singleton luokkaan
    private double fat;
    private double sugar;
    private int cal;
    private double hinta;
    private String pvm;
    private ArrayList<Double> ratingslist;
    private int arvostelumaara = 0;
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
        ratingslist = new ArrayList<>();
        ratingslist.add(rating);
        this.arvostelumaara ++;
        if (tyyppi.equals("Berliininmunkki")){
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

    public void setArvostelu(double arvostelu) {
        this.ratingslist.add(arvostelu);
        this.arvostelumaara ++;
    }

    public double getArvostelu() { //palauttaa keskiarvon arvosteluista
        if (arvostelumaara > 1){
            double summa = 0;
            for (double i : ratingslist){
                summa += i;
            }
            double ka = (double) (summa / arvostelumaara);
            return ka;

        } else {
            return ratingslist.get(0);
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



    @Override
    public String toString() {
        return "fat=" + fat + " g" +
                ", sugar=" + sugar + " g" +
                ", cal=" + cal + " Kcal" +
                ", hinta=" + hinta + " €";
    }
}
