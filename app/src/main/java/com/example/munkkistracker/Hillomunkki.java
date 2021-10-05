package com.example.munkkistracker;

public class Hillomunkki implements Munkki { //luokka hillomunkin tiedoille
    private float fat;
    private float cost;
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

    @Override
    public float getHinta() {
        return this.cost;
    }
}
