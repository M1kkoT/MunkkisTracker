package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        nimet.setText("Aasa Lilian \n Kyyrä Kerttu \n Oksanen Sara \n Tanhola Mikko");




    }
}