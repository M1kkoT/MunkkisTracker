package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PaivakirjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
        ListView lv = findViewById(R.id.lista);
        ArrayList<String> paivat = new ArrayList<>();
        paivat.add("Maanantai");
        paivat.add("Tiistai");
        paivat.add("Keskiviikko");
        paivat.add("Torstai");
        paivat.add("Perjantai");
        paivat.add("Lauantai");
        paivat.add("Sunnuntai");


        lv.setAdapter(new  ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                paivat));

    }
}