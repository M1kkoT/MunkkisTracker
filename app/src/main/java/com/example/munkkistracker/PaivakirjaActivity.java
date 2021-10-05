package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PaivakirjaActivity extends AppCompatActivity {
    private static final String EXTRA = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
        ListView lv = findViewById(R.id.lista);

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()); //tällä saa päivämäärän
        TextView teksti = findViewById(R.id.textView4); //testitextview päivämäärälle
        teksti.setText(date);

        //testikoodia listviewiin

        PvmList.getInstance().getPvm().add(date); //lisätään pvm singleton luokkaan
        PvmList.getInstance().getPvm().add(date);


        lv.setAdapter(new ArrayAdapter<String>( //adapteri listviewille
                this,
                android.R.layout.simple_list_item_1,
                PvmList.getInstance().getPvm())); //lista päivämääristä jotka on tallennettu PvmListaan


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(PaivakirjaActivity.this, TietoActivity.class);
                nextActivity.putExtra(EXTRA, i);
                startActivity(nextActivity);
            }
        });

    }

}