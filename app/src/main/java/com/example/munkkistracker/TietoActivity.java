package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TietoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tieto);
        Bundle bundle = getIntent().getExtras(); //testikoodia
        int i = bundle.getInt(PaivakirjaActivity.EXTRA, 0); //i on listan indeksi

        TextView teksti = findViewById(R.id.teksti);
        teksti.setText(Integer.toString(i));


    }
}