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

    @Override
    public String toString() {
        return "Munkkitiedot{" +
                "fat=" + fat +
                ", sugar=" + sugar +
                ", cal=" + cal +
                ", hinta=" + hinta +
                ", pvm='" + pvm + '\'' +
                '}';
    }
}
