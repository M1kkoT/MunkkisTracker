package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HallOfFameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_of_fame);

        //Asetetaan TextView
        TextView otsikko = findViewById(R.id.hall_otsikko);
        otsikko.setText("Hall Of Fame");

        TextView win = findViewById(R.id.hall_winner);
        win.setText("WINNER");

        //sara testaa, lel
        //muuttujia muistiin
        double berm = 0;
        double hillom = 0;
        double rinkelim = 0;
        double kaikki = berm + hillom + rinkelim;

        //Vaihtaa kuvaa sen mukaan mitä munkkia on eniten
        ImageView winner = findViewById(R.id.image_winner);
        if (berm > hillom && berm > rinkelim){
            winner.setImageResource(R.drawable.winner_ber);
        }else if(hillom > berm && hillom > rinkelim){
            winner.setImageResource(R.drawable.winner_hillo);
        }else if (rinkelim > berm && rinkelim > hillom){
            winner.setImageResource(R.drawable.winner_rinkeli);
        }

    }
}