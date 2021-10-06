package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tiedot = findViewById(R.id.button_syota_tiedot);  //nappi siirtyy syötä tiedot activityyn
        tiedot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SyotaTiedotActivity.class);
                startActivity(intent);

            }
        });
        Button diary = findViewById(R.id.button_paivaskirja); //nappi siirtyy päiväkirjaactivityyn
        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, PaivakirjaActivity.class);
                startActivity(intent2);

            }
        });
        Button fame = findViewById(R.id.button_halloffame);  //nappi siirtyy hall of fame activityyn
        fame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, HallOfFameActivity.class);
                startActivity(intent3);

            }
        });
        Button info = findViewById(R.id.button5); //Nappi siirtää Info-Activityyn
        info.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               Intent intent5 = new Intent(MainActivity.this,InfoActivity.class);
               startActivity(intent5);
           }
        });





    }
}