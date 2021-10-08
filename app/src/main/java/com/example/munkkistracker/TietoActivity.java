package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TietoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tieto);
        Bundle bundle = getIntent().getExtras(); //testikoodia
        int i = bundle.getInt(PaivakirjaActivity.EXTRA, 0); //i on listan indeksi

        TextView pvm = findViewById(R.id.tieto_pvm);
        pvm.setText(MunkkiList.getInstance().getMunkit().get(i).getPvm()); //palauttaa listan alkion tostring metodin
        //textview x .setText(MunkkiList.getInstance().getMunkit().get(i).XXXX tällä saa tietyn tiedon jos haluaa monta tekstikenttää
        //korvaa XXXX getRasva yms ja textview x omalla Textvievillä

        TextView maara = findViewById(R.id.tieto_maara);
        maara.setText("Olet syönyt yhteensä "+"X-MÄÄRÄ"+" munkkia.");

        TextView valiotsikko =findViewById(R.id.tieto_vali);
        valiotsikko.setText("Niissä on ollut yhteensä:");

        TextView kalori = findViewById(R.id.tieto_kcl);
        kalori.setText(String.valueOf(MunkkiList.getInstance().getMunkit().get(i).getCal())+" kaloria.");

        TextView rasva = findViewById(R.id.tieto_rasva);
        rasva.setText("rasvaa "+String.valueOf(MunkkiList.getInstance().getMunkit().get(i).getFat())+"g");

        TextView sokeri = findViewById(R.id.tieto_sokeri);
        sokeri.setText("sokeria "+String.valueOf(MunkkiList.getInstance().getMunkit().get(i).getSugar())+"g");

        TextView hinta = findViewById(R.id.tieto_hinta);
        hinta.setText("Käytit munkkeihin yhteensä "+"€");


        TextView arvosana = findViewById(R.id.tieto_arvosana);
        arvosana.setText("Syömiesi munkkien keskiarvo on");




    }
}