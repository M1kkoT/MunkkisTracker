package com.example.munkkistracker;

/**
 * @author Sara Oksanen
 * HallOfFameactivity kerää kokoon viimeisen 30 päivän tiedot mitkä käyttäjä on syöttänyt
 * ja näyttää niiden arvot TextView näkymissä
 *
 * Alustetaan ja asetetaan arvot myöhemmin tarvittaville muuttujille
 *
 * Luodaan for-looppi
 * joka käy läpi arraylistin, mihin on kerätty kaikki munkkitiedot ja summaa
 * saadut luvut yhteen
 *
 * Luodaan if-lauseke
 * lauseke katsoo mitä munkkia/munkkeja on syöty eniten ja asettaa sen mukaan ImageView näkymään kuvan
 * setImageresource komennolla ja vaihtaa taustaväriä setBackroundColor komennolla
 *
 * TextView.setText
 * Asetetaan tekstit textView näkymiin käyttämällä String ja aiemmin alustettuja muuttujia.
 *
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HallOfFameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_of_fame);

        //Tarvittavat muuttujat
        double rinkelim = 0;
        double berlm = 0;
        double hillom = 0;
        double kaikki = 0;

        int kalori = 0;
        double rasva = 0;
        double sokeri = 0;

        double raha = 0;
        double arvosana = 0;
        double ka = 0;
        int paivat = 0;

        //Looppi mikä käy arraylistin läpi
        int max = MunkkiList.getInstance().getMunkit().size();
        for (int i = 0; i < max; i++){
            rinkelim += MunkkiList.getInstance().getMunkit().get(i).getRinkila();
            berlm += MunkkiList.getInstance().getMunkit().get(i).getBerlin();
            hillom += MunkkiList.getInstance().getMunkit().get(i).getHillo();
            kaikki = rinkelim + berlm + hillom;

            kalori += MunkkiList.getInstance().getMunkit().get(i).getCal();
            rasva += MunkkiList.getInstance().getMunkit().get(i).getFat();
            sokeri += MunkkiList.getInstance().getMunkit().get(i).getSugar();

            raha += MunkkiList.getInstance().getMunkit().get(i).getHinta();

            arvosana += MunkkiList.getInstance().getMunkit().get(i).getArvostelu();
            paivat++;
            ka = arvosana/paivat;
        }

        //Vaihtaa kuvaa ja taustaväriä sen mukaan mitä munkkia on eniten
        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.br_test);
        ImageView winner = findViewById(R.id.image_winner);

        if (berlm > hillom && berlm > rinkelim){
            winner.setImageResource(R.drawable.winner_ber);
            bgElement.setBackgroundColor(Color.rgb(255, 105, 180));
        }else if(hillom > berlm && hillom > rinkelim){
            winner.setImageResource(R.drawable.winner_hillo);
        }else if (rinkelim > berlm && rinkelim > hillom){
            winner.setImageResource(R.drawable.winner_rinkeli);
        }else if (berlm == rinkelim && berlm > hillom){
            winner.setImageResource(R.drawable.berrin);
        }else if (hillom == berlm && hillom > rinkelim){
            winner.setImageResource(R.drawable.hilber);
        }else if (hillom == rinkelim && hillom > berlm){
            winner.setImageResource(R.drawable.hilrin);
        }else{
            winner.setImageResource(R.drawable.tasapeli);
        }

        //TextView asettelu
        TextView otsikko = findViewById(R.id.hall_otsikko);
        otsikko.setText("Hall Of Fame");

        TextView win = findViewById(R.id.hall_winner);
        win.setText("WINNER");

        TextView vali = findViewById(R.id.hall_vali);
        vali.setText("Viimeisen 30 merkinnän yhteenveto");

        TextView munkit = findViewById(R.id.hall_munkit);
        munkit.setText("Olet yhteensä syönyt "+kaikki+" munkkia. \nBerliininmunkkeja "+berlm+" \nHillomunkkeja "+hillom+"\nMunkkirinkeleitä "+rinkelim);

        TextView ravinto = findViewById(R.id.hall_ravinto);
        ravinto.setText("Niissä on ollut yhteensä:\nkaloreita "+ kalori + "kcl \nrasvaa "+rasva+"g \nsokeria "+sokeri+"g");

        TextView arvot = findViewById(R.id.hall_arvot);
        String cash = String.format("%.2f", raha); //muokkaa hinnat ja tähdet tulostettaviksi vain 2 desimaalin tarkkuudella
        String average = String.format("%.2f", ka);
        arvot.setText("Käytit munkkeihin yhteensä "+cash+"€ \nMunkkien keskiarvosana on "+average+" ★");

        TextView huom = findViewById(R.id.hall_huom);
        huom.setText("Huomaathan että ravintoarvot ovat suuntaa antavia");
    }

}