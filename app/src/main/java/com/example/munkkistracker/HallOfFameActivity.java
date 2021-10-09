package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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

        //sara testaa, lel
        int i = 0;
        double testi = (MunkkiList.getInstance().getMunkit().get(i).getHillo())+(MunkkiList.getInstance().getMunkit().get(i).getBerlin());

        TextView test = findViewById(R.id.hall_testi);
        test.setText(String.valueOf(testi));





    }
}