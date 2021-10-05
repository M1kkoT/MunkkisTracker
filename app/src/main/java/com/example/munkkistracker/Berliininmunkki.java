package com.example.munkkistracker;

public class Berliininmunkki implements Munkki{ //luokka berliininmunkin tiedoille
    private float fat;
    private float sugar;
    private int cal;

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



}
