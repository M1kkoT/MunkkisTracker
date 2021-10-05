package com.example.munkkistracker;

public class Counter {
    private float cost;
    private int kcal;
    private float fat;
    private float sugar;
    private int kpl;


    public Counter(Munkki munkki, float hinta, int lukum) { //konstruktori saa parametreinä munkin, kplhinnan ja lukumäärän
        this.cost = hinta;
        this.kpl = lukum;
        this. kcal = munkki.getKcal();
        this.fat = munkki.getRasva();
        this.sugar = munkki.getSokeri();
    }

    public float getCost() {
        return cost * kpl;

    }

    public int getKcal() {
        return kcal * kpl;
    }

    public float getFat() {
        return fat * kpl;
    }

    public float getSugar() {
        return sugar * kpl;
    }

    public int getKpl() {
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
