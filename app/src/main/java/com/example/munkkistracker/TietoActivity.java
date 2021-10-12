package com.example.munkkistracker;

/**
 * TietoActivity näyttää päiväkohtaiset tiedot käyttäjän syötteestä
 *
 * Activity saa extrana PäiväkirjaActivitystä listan indeksin numeron eli mitä listan alkiota klikattiin
 *
 * tämän indeksin avulla haetaan MunkkiList singleton luokan listasta samalla indeksillä olevan
 * Munkkitiedot olion tiedot näytettäväksi activitynssä
 *
 *
 *
 * Luodaan double muuttuja "kokoluku", missä lasketaan käyttäjän syömien munkkien yhteismäärä
 *
 * Asetetaan UI TextView näkymiin String tekstit ja haetaan päiväkohtaiset munkkitiedot
 * arraylististä.
 *
 * hinta ja arvostelut näytetään kahden desimaalin tarkkuudella
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TietoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tieto);
        Bundle bundle = getIntent().getExtras();
        int i = bundle.getInt(PaivakirjaActivity.EXTRA, 0); //saa extranan listan indeksin päiväkirjaActivitystä

        TextView pvm = findViewById(R.id.tieto_pvm);
        pvm.setText(MunkkiList.getInstance().getMunkit().get(i).getPvm());
        //textview x .setText(MunkkiList.getInstance().getMunkit().get(i).XXXX
        // tällä saa tietyn tiedon jos haluaa monta tekstikenttää
        //korvaa XXXX getRasva yms ja textview x omalla Textvievillä

        //Laskee kuinka monta munkkia on yhteensä syöty
        double kokoluku = (MunkkiList.getInstance().getMunkit().get(i).getHillo()) +
                (MunkkiList.getInstance().getMunkit().get(i).getBerlin()) +
                (MunkkiList.getInstance().getMunkit().get(i).getRinkila());

        TextView maara = findViewById(R.id.tieto_maara);
        maara.setText("Olet syönyt yhteensä "+kokoluku+" munkkia. ");

        TextView ber = findViewById(R.id.tieto_munkit);
        ber.setText("Berliininmunkkeja "+ (MunkkiList.getInstance().getMunkit().get(i).getBerlin())+
                "\nHillomunkkeja "+(MunkkiList.getInstance().getMunkit().get(i).getHillo())+
                "\nMunkkirinkeleitä "+(MunkkiList.getInstance().getMunkit().get(i).getRinkila()));

        TextView valiotsikko =findViewById(R.id.tieto_vali);
        valiotsikko.setText("Niissä on ollut yhteensä:");

        TextView kalori = findViewById(R.id.tieto_ravinto);
        kalori.setText("Kaloreita "+MunkkiList.getInstance().getMunkit().get(i).getCal()+" kcl\n" +
                "rasvaa "+ MunkkiList.getInstance().getMunkit().get(i).getFat()+" g\n" +
                "sokeria "+ MunkkiList.getInstance().getMunkit().get(i).getSugar()+" g");

        TextView hinta = findViewById(R.id.tieto_hinta);
        String cash = String.format("%.2f", MunkkiList.getInstance().getMunkit().get(i).getHinta());
        String average = String.format("%.2f", MunkkiList.getInstance().getMunkit().get(i).getArvostelu());
        hinta.setText("Käytit munkkeihin yhteensä " + cash + " €\n" +
                "Munkkien keskiarvosana on " + average + " ★");

        TextView huom = findViewById(R.id.tieto_huom);
        huom.setText("Huomaathan että ravintoarvot ovat suuntaa antavia");
    }
}