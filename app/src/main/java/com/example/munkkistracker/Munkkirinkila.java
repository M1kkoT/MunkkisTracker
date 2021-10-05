package com.example.munkkistracker;

public class Munkkirinkila implements Munkki{ //luokka munkkirinkilän tiedoille
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


}
