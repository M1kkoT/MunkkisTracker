package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        //Tarvittavat arvot
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

        //Vaihtaa kuvaa sen mukaan mitä munkkia on eniten
        ImageView winner = findViewById(R.id.image_winner);
        if (berlm > hillom && berlm > rinkelim){
            winner.setImageResource(R.drawable.winner_ber);
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
        TextView vali = findViewById(R.id.hall_vali);
        vali.setText("Viimeisen 30 merkinnän yhteenveto");

        TextView munkit = findViewById(R.id.hall_munkit);
        munkit.setText("Olet yhteensä syönyt "+kaikki+" munkkia. \nBerliininmunkkeja "+berlm+"\nHillomunkkeja "+hillom+"\nMunkkirinkeleitä "+rinkelim);

        TextView ravinto = findViewById(R.id.hall_ravinto);
        ravinto.setText("Niissä on ollut yhteensä:\nkaloreita "+ kalori + "kcl \nrasvaa "+rasva+"g \nsokeria "+sokeri+"g");

        TextView arvot = findViewById(R.id.hall_arvot);
        String cash = String.format("%.2f", raha);
        String average = String.format("%.2f", ka);
        arvot.setText("Käytit munkkeihin yhteensä "+cash+"€ \nSyömiesi munkkien keskiarvosana on "+average+" tähteä.");

        TextView huom = findViewById(R.id.hall_huom);
        huom.setText("Huomaathan että ravintoarvot ovat suuntaa antavia");
    }

}