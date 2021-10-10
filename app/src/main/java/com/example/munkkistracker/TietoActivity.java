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
        pvm.setText(MunkkiList.getInstance().getMunkit().get(i).getPvm());
        //textview x .setText(MunkkiList.getInstance().getMunkit().get(i).XXXX tällä saa tietyn tiedon jos haluaa monta tekstikenttää
        //korvaa XXXX getRasva yms ja textview x omalla Textvievillä

        //Laskee kuinka monta munkkia on yhteensä syöty
        double kokoluku = (MunkkiList.getInstance().getMunkit().get(i).getHillo()) + (MunkkiList.getInstance().getMunkit().get(i).getBerlin()) + (MunkkiList.getInstance().getMunkit().get(i).getRinkila());

        TextView maara = findViewById(R.id.tieto_maara);
        maara.setText("Olet syönyt yhteensä "+kokoluku+" munkkia.\n ");

        TextView ber = findViewById(R.id.tieto_munkit);
        ber.setText("Berliininmunkkeja "+ (MunkkiList.getInstance().getMunkit().get(i).getBerlin())+
                "\nHillomunkkeja "+(MunkkiList.getInstance().getMunkit().get(i).getHillo())+
                "\nMunkkirinkeleitä "+(MunkkiList.getInstance().getMunkit().get(i).getRinkila()));

        TextView valiotsikko =findViewById(R.id.tieto_vali);
        valiotsikko.setText("Niissä on ollut yhteensä:");

        TextView kalori = findViewById(R.id.tieto_ravinto);
        kalori.setText("Kaloreita "+MunkkiList.getInstance().getMunkit().get(i).getCal()+"kcl\n" +
                "rasvaa "+ MunkkiList.getInstance().getMunkit().get(i).getFat()+"g\n" +
                "sokeria "+ MunkkiList.getInstance().getMunkit().get(i).getSugar()+"g");

        TextView hinta = findViewById(R.id.tieto_hinta);
        hinta.setText("Käytit munkkeihin yhteensä " + MunkkiList.getInstance().getMunkit().get(i).getHinta() + " €\n" +
                "Syömiesi munkkien keskiarvosana on " + MunkkiList.getInstance().getMunkit().get(i).getArvostelu() + " tähteä");

        TextView huom = findViewById(R.id.tieto_huom);
        huom.setText("Huomaathan että ravintoarvot ovat suuntaa antavia");
    }

}