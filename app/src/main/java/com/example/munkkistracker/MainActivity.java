package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Gson gson;
    private static final String  Pref = "talle"; //sharedpreferences munkkilistan nimi
    private static final String Lista = "lista"; //sharedpreferenceseihin tallennetun json stringin nimi



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();
        //tämä osa koodista katsoo, kutsutaanko onCreate() metodia painamalla tallenna nappia SyotatiedotActivityssä
        //jos kutsutaan, niin ei tarvitse ladata tietoja sharedpreferenceistä
        Intent intent = getIntent();
        int talle = intent.getIntExtra(SyotaTiedotActivity.Talle, 0); //talle on "1", jos tullaan SyotatiedotActivitystä
        if (talle == 0){
            SharedPreferences loadpreferences = getSharedPreferences(Pref, 0); //jos tullaan muualta kuin Syotatiedotactivitystä,
            String json = loadpreferences.getString(Lista, "tyhja");                //ladataan json string sharedpreferenceistä
            if (!json.equals("tyhja")){                                                 //jos MunkkiList oli jo tyhjä, ei tehdä mitään
                MunkkiList.getInstance().getMunkit().clear();
                TypeToken<List<Munkkitiedot>> token = new TypeToken<List<Munkkitiedot>>() {}; //muutetaan json string takaisin MunkkiListaksi
                ArrayList<Munkkitiedot> alist = gson.fromJson(json, token.getType());
                for (int i = 0; i < alist.size(); i++) {
                    MunkkiList.getInstance().getMunkit().add(alist.get(i));
                }
            }
        } if(talle == 2) {
            MunkkiList.getInstance().getMunkit().clear();
            SharedPreferences sharedPreferences = getSharedPreferences(Pref,0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
        }












        Button tiedot = findViewById(R.id.button_syota_tiedot);  //nappi siirtyy syötä tiedot activityyn
        tiedot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SyotaTiedotActivity.class);
                startActivity(intent);
            }
        });

        Button diary = findViewById(R.id.button_paivakirja); //nappi siirtyy päiväkirjaactivityyn
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
    @Override
    protected void onPause(){
        super.onPause();
        List lista = MunkkiList.getInstance().getMunkit(); //tallentaa MunkkiListin tiedot sharedpreferenceihin
        if (!lista.isEmpty()){
            String tekst = gson.toJson(lista);
            SharedPreferences talleprefs = getSharedPreferences(Pref, 0);
            SharedPreferences.Editor editor = talleprefs.edit();
            editor.putString(Lista, tekst);
            editor.commit();

        }

    }




}