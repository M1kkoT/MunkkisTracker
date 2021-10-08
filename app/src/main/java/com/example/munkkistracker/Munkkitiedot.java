package com.example.munkkistracker;

public class Munkkitiedot { //luokka johon tallennetaan tiedot ja joka tallennetaan singleton luokkaan
    private float fat;
    private float sugar;
    private int cal;
    private float hinta;
    private String pvm;

    public Munkkitiedot(float rasva, float sokeri, int kalori , float cost, String paiva){
        this.fat = rasva;
        this.sugar = sokeri;
        this.cal = kalori;
        this.hinta = cost;
        this.pvm = paiva;
    }

    public float getFat() {
        return fat;
    }

    public float getSugar() {
        return sugar;
    }

    public int getCal() {
        return cal;
    }

    public float getHinta() {
        return hinta;
    }

    public String getPvm() {
        return pvm;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public void setHinta(float hinta) {
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
