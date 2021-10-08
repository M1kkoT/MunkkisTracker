package com.example.munkkistracker;

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
        return "Hillomunkki{";
    }
}
