package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HallOfFameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_of_fame);

        //Asetetaan TextView
        TextView otsikko = findViewById(R.id.tv_otsikko);
        otsikko.setText("Hall Of Fame");

        TextView paras = findViewById(R.id.tv_paras);
        paras.setText("Winner");

        TextView yhtHinta = findViewById(R.id.tv_yhteensa_hinta);
        yhtHinta.setText("Olet käyttänyt $$ ");

        TextView yhtKcl = findViewById(R.id.tv_yhteensa_kcl);
        yhtKcl.setText("Olet syönyt yhteensä KCL");

        TextView yhtMaara = findViewById(R.id.tv_yhteensa_maara);
        yhtMaara.setText("Olet syönyt yhteensä MÄÄRÄ");



    }
}