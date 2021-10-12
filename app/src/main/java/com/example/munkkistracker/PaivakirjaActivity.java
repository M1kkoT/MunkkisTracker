package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author Kerttu Kyyrä
 * @author Lilian Aasa
 *
 */

public class PaivakirjaActivity extends AppCompatActivity {
    public static final String EXTRA = "index";
    private ArrayList<String> paivat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
        ListView lv = findViewById(R.id.lista);
        paivat = new ArrayList<>();
        for (int i = 0; i < MunkkiList.getInstance().getMunkit().size(); i++){ //tekee listan päivämääristä
            paivat.add(MunkkiList.getInstance().getMunkit().get(i).getPvm());
        }

        lv.setAdapter(new ArrayAdapter<String>( //adapteri listviewille
                this,
                android.R.layout.simple_list_item_1,
                paivat)); //lista päivämääristä tulee listviewiin näkyviin


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(PaivakirjaActivity.this, TietoActivity.class);
                nextActivity.putExtra(EXTRA, i); //lisää extrana listview elementin indexin
                startActivity(nextActivity);
            }
        });
    }
}