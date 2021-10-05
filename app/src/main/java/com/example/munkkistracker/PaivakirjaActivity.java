package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PaivakirjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
        ListView lv = findViewById(R.id.lista);
        ArrayList<String> paivat = new ArrayList<>(); //testikoodia listwieviä varten varten
        paivat.add("Maanantai");
        paivat.add("Tiistai");
        paivat.add("Keskiviikko");
        paivat.add("Torstai");
        paivat.add("Perjantai");
        paivat.add("Lauantai");
        paivat.add("Sunnuntai");

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()); //tällä saa päivämäärän
        TextView teksti = findViewById(R.id.textView4); //testitextview päivämäärälle
        teksti.setText(date);


        lv.setAdapter(new  ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                paivat));

    }
}