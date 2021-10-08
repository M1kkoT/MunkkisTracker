package com.example.munkkistracker;

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
