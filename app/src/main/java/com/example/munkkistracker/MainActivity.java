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

        Button tiedot = findViewById(R.id.button);  //nappi siirtyy seuraavaan activityyn
        tiedot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SyotaTiedotActivity.class);
                startActivity(intent);

            }
        });
        Button diary = findViewById(R.id.button2); //nappi siirtyy seuraavaan activityyn
        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaivakirjaActivity.class);
                startActivity(intent);

            }
        });
        Button fame = findViewById(R.id.button);  //nappi siirtyy seuraavaan activityyn
        fame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HallOfFameActivity.class);
                startActivity(intent);

            }
        });

    }
}