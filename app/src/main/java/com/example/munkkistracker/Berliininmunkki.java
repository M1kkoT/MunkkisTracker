package com.example.munkkistracker;

public class Berliininmunkki implements Munkki{ //luokka berliininmunkin tiedoille
    private float fat;
    private float sugar;
    private int cal;

    public Berliininmunkki(){
        this.fat = 15;
        this.sugar = 36;
        this.cal = 405;
    }

    @Override
    public float getRasva() {
        return this.fat;
    }

    @Override
    public int getKcal() {
        return this.cal;
    }

    @Override
    public float getSokeri() {
        return this.sugar;
    }

    @Override
    public String toString() {
        return "Berliininmunkki";
    }
}
