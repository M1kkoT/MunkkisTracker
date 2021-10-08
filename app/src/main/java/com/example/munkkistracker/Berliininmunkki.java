package com.example.munkkistracker;

public class Berliininmunkki implements Munkki{ //luokka berliininmunkin tiedoille
    private double fat;
    private double sugar;
    private int cal;

    public Berliininmunkki(){
        this.fat = 15;
        this.sugar = 36;
        this.cal = 405;
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
        return "Berliininmunkki";
    }
}
