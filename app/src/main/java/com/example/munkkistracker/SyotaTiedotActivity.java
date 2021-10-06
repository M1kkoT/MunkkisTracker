package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class SyotaTiedotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syota_tiedot);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()); //tällä saa päivämäärän



        //Asetetaan TextView tekstit
        TextView maara = findViewById(R.id.tv_maara);
        maara.setText("Määrä");

        TextView kappale = findViewById(R.id.tv_hinta);
        kappale.setText("Hinta");

        TextView syote = findViewById(R.id.tv_syota);
        syote.setText("Syötä tiedot");

        TextView arvio = findViewById(R.id.tv_arvosana);
        arvio.setText("Arvosana");

        EditText volume = findViewById(R.id.editText_maara);
        EditText hinta = findViewById(R.id.editTextHinta);

        int kpl = 3; //testikoodia
        float cost = 2;
        Munkki b = new Berliininmunkki();

        //onclicklistener tallenna buttonille
        Button tallenna = findViewById(R.id.button_tallenna);
        tallenna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PvmList.getInstance().getPvm().add(date); //lisätään pvm singleton luokkaan
                Counter counter = new Counter(b, cost, kpl); //luodaan counter
                MunkkiList.getInstance().getMunkit().add(new Munkkitiedot(counter.getFat(), counter.getSugar(),counter.getKcal(), cost, date)); //lisää tiedot singleton luokkkaan
                Intent backToMain = new Intent(SyotaTiedotActivity.this, MainActivity.class); //palaa mainactivityyn
                startActivity(backToMain);


            }
        });

    }
}