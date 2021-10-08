package com.example.munkkistracker;

public class Munkkitiedot { //luokka johon tallennetaan tiedot ja joka tallennetaan singleton luokkaan
    private double fat;
    private double sugar;
    private int cal;
    private double hinta;
    private String pvm;

    public Munkkitiedot(double rasva, double sokeri, int kalori , double cost, String paiva){
        this.fat = rasva;
        this.sugar = sokeri;
        this.cal = kalori;
        this.hinta = cost;
        this.pvm = paiva;
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

    @Override
    public String toString() {
        return "fat=" + fat + " g" +
                ", sugar=" + sugar + " g" +
                ", cal=" + cal + " Kcal" +
                ", hinta=" + hinta + " €";
    }
}
