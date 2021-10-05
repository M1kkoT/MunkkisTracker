package com.example.munkkistracker;

public class Munkkirinkila implements Munkki{ //luokka munkkirinkilän tiedoille
    private float fat;
    private float sugar;
    private int cal;

    public Munkkirinkila() {
        this.cal = 328;
        this.fat = 14;
        this.sugar = 7;
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
        return "Munkkirinkila{";
    }
}
