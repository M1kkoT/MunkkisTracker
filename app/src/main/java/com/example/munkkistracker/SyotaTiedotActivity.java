package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
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






        Munkki b = new Berliininmunkki();



        //onclicklistener tallenna buttonille

        Button tallenna = findViewById(R.id.button_tallenna);
        tallenna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int koko = PvmList.getInstance().getPvm().size(); //tallennettujen tietojen listan koko
                boolean totuus = false; //false niin pvm ei ole jo listalla, true niin on
                if (koko > 0){
                    for (int i = 0; i < koko ; i++){ //for looppi käy läpi pvmlistan ja vaihtaa totuuden arvoon "true" jos nykyinen pvm on jo listalla
                        String pvm = PvmList.getInstance().getPaiva(i);
                        if (pvm.equals(date)){
                            totuus = true;
                        }


                    }

                }
                int kpl = Integer.parseInt(volume.getText().toString()); // ottaa kplmäärän syötteestä
                float cost = Integer.parseInt(hinta.getText().toString());//ottaa hinnan syötteestä
                Counter counter = new Counter(b, cost, kpl); //luodaan counter

                if (!totuus){
                    PvmList.getInstance().getPvm().add(date); //lisätään pvm singleton luokkaan
                    MunkkiList.getInstance().getMunkit().add(new Munkkitiedot(counter.getFat(), counter.getSugar(),counter.getKcal(), counter.getCost(), date)); //lisää tiedot singleton luokkkaan
                }
                else{
                    Munkkitiedot munkki = MunkkiList.getInstance().getMunkit().get(MunkkiList.getInstance().getMunkit().size() - 1); //muokkaa viimeistä alkiota
                    munkki.setCal(munkki.getCal() + counter.getKcal());  //lisätään uudet arvot vanhoihin
                    munkki.setFat(munkki.getFat() + counter.getFat());
                    munkki.setSugar(munkki.getSugar() + counter.getSugar());
                    munkki.setHinta(munkki.getHinta() + counter.getCost());

                }


                Intent backToMain = new Intent(SyotaTiedotActivity.this, MainActivity.class); //palaa mainactivityyn
                startActivity(backToMain);


            }
        });

    }
}