package com.example.munkkistracker;
/**
 * @Author Sara Oksanen
 * @Author Lilian Aasa
 * InfoActivityyn on kerätty tiedot sovelluksen tekijöistä ja sieltä löytyy myös "Reset nappi
 * joka nollaa koko sovelluksen
 *
 * onCreate()
 * Asetetaan tekstit UI TextView näkymiin .setText komennolla
 * Asetetaan kuva UI ImageView näkymään .setImageResource komennolla
 *
 * Button reset
 * OnClick() Poistaa tallennetut tiedot sovelluksesta ja palauttaa käyttäjän MainActivityyn
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView otsikko = findViewById(R.id.info_otsikko);
        otsikko.setText("MunkkiTracker");

        TextView aloitus = findViewById(R.id.info_aloitus);
        aloitus.setText("Tämän sovelluksen teille toi");

        TextView nimet = findViewById(R.id.info_nimet);
        nimet.setText("Aasa Lilian\nKyyrä Kerttu\nOksanen Sara\nTanhola Mikko");

        TextView koulu = findViewById(R.id.info_koulu);
        koulu.setText("Metropolia\nMobiilit Terveyssovellukset\n2021");


        ImageView rkuva = findViewById(R.id.imgRyhma);
        rkuva.setImageResource(R.drawable.ryhma);


        Button reset = findViewById(R.id.resetBtn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMain = new Intent(InfoActivity.this, MainActivity.class); //palaa mainactivityyn
                backToMain.putExtra("talle", 2);
                startActivity(backToMain);
            }
        });
    }
}