package com.example.munkkistracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author Mikko Tanhola
 *
 * SyötäTiedotActivityssä käyttäjältä kerätään tietoja ja ne tallennetaan sovellukseen
 * käyttäjän syötettä kerätään radiobuttoneilla, EditTextillä ja Ratingbarilla
 *
 * Luokkamuuttujia
 * arvosteltu (boolean) defaulttina "false" - käytetään tarkistamaan onko käyttäjä arvostellut munkit
 * rating (double) defaulttina 0.0; - arvostelu desimaalilukuna (0-5)
 * Talle (static final String) "talle" - Mainactivityyn lähetettävän Extran nimi
 *
 * aluksi ohjelma tallentaa tämänhetkisen päivän päivämäärän "date" muuttujaan
 *
 * alustetaan TextView ja EditText elementit
 *
 * alustetaan RatinBar ja asetetaan sille OnRatingChangeListener, jonka avulla tarkistetaan, onko
 * käyttäjä antanut arvostelun -> jos käyttäjä on antanut arvostelun §
 *
 *
 *
 */

public class SyotaTiedotActivity extends AppCompatActivity {
    private boolean arvosteltu = false;
    private double rating = 0.0;
    public static final String Talle = "talle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syota_tiedot);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()); //tällä saa päivämäärän


        //Asetetaan TextView tekstit
        TextView maara = findViewById(R.id.tv_maara);
        maara.setText("Määrä");

        TextView kappale = findViewById(R.id.tv_hinta);
        kappale.setText("Hinta/Kpl");

        TextView syote = findViewById(R.id.tv_syota);
        syote.setText("Syötä tiedot");

        TextView arvio = findViewById(R.id.tv_arvosana);
        arvio.setText("Arvosana");

        EditText volume = findViewById(R.id.editText_maara);
        EditText hinta = findViewById(R.id.editTextHinta);


        Button testi = findViewById(R.id.button_testi); // testinappula jolla voi lisätä listoille alkioita
        testi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tekst = Integer.toString(MunkkiList.getInstance().getMunkit().size());
                double testi = Double.parseDouble(tekst);
                MunkkiList.getInstance().getMunkit().add(new Munkkitiedot( 15, 15, 15, testi, "testi" + tekst, 3.5, "Berliininmunkki", 1));

                //koodi rajoittamaan listan alkioiden määrää testaukseen
                if (MunkkiList.getInstance().getMunkit().size() > 6) { // vihda tähän luku kuinka ison listan haluat

                    MunkkiList.getInstance().getMunkit().remove(0);

                }
                Intent backToMain = new Intent(SyotaTiedotActivity.this, MainActivity.class); //palaa mainactivityyn
                backToMain.putExtra(Talle, 1);
                startActivity(backToMain);
            }
        });
        RatingBar arvostelu = findViewById(R.id.ratingBar);//ratingbarin alustus
        arvostelu.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if (b){ //katsoo onko käyttäjä arvostellut munkit
                    arvosteltu = true;
                    rating = arvostelu.getRating();

                }
            }
        });


        //onclicklistener tallenna buttonille
        Button tallenna = findViewById(R.id.button_tallenna);
        tallenna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int koko = MunkkiList.getInstance().getMunkit().size(); //tallennettujen tietojen listan koko
                boolean totuus = false; //false niin pvm ei ole jo listalla, true niin on
                if (koko > 0){
                    for (int i = 0; i < koko ; i++){ //for looppi käy läpi pvmlistan ja vaihtaa totuuden arvoon "true" jos nykyinen pvm on jo listalla
                        String pvm = MunkkiList.getInstance().getMunkit().get(i).getPvm();
                        if (pvm.equals(date)){
                            totuus = true;
                        }
                    }
                }
                Munkki b; //alustaa munkin

                RadioButton rb = findViewById(R.id.rb_Berlin); //alustaa radiobuttonit
                RadioButton rh = findViewById(R.id.rb_Hillo);
                RadioButton rr = findViewById(R.id.rb_rinkila);

                if(rb.isChecked()){  //katsoo mikä radiobutton on painettu ja jos ei mitään antaa ilmoituksen nappia painettaessa
                    Munkki uusi = new Berliininmunkki();
                    b = uusi;
                }else if(rh.isChecked()){
                    Munkki uusi = new Hillomunkki();
                    b = uusi;
                }else if(rr.isChecked()){
                    Munkki uusi = new Munkkirinkila();
                    b = uusi;
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Valitse munkki", Toast.LENGTH_LONG); //ilmoitus jos ei ole valittu munkkia ja lopettaa toiminnan
                    toast.show();
                    return;

                }
                if (volume.getText().toString().isEmpty() || hinta.getText().toString().isEmpty()){ //katsoo onko syötteet tyhjiä
                    Toast toast = Toast.makeText(getApplicationContext(), "Syötä tiedot", Toast.LENGTH_LONG); //ilmoitus jos ei ole valittu munkkia ja lopettaa toiminnan
                    toast.show();
                    return;
                }
                if (volume.getText().toString().equals("0")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Kappalemäärä ei voi olla 0!", Toast.LENGTH_LONG); //ilmoitus jos käyttäjä syöttää kappalemääräksi "0"
                    toast.show();
                    return;

                }
                if (!arvosteltu){
                    Toast toast = Toast.makeText(getApplicationContext(), "Arvostele munkit!", Toast.LENGTH_LONG); //pyytää käyttäjää arvostelemaan munkit
                    toast.show();
                    return;
                }
                double kpl = Double.parseDouble(volume.getText().toString()); // ottaa kplmäärän syötteestä
                double cost = Double.parseDouble(hinta.getText().toString());//ottaa hinnan syötteestä
                Counter counter = new Counter(b, cost, kpl); //luodaan counter

                if (!totuus){  //lisätään tiedot singleton luokkaan jos tältä päivältä ei ole tietoja vielä
                    MunkkiList.getInstance().getMunkit().add(new Munkkitiedot(counter.getFat(), counter.getSugar(),
                            counter.getKcal(), counter.getCost(), date, rating, b.toString(), kpl)); //lisää tiedot singleton luokkkaan
                }
                else{
                    Munkkitiedot munkki = MunkkiList.getInstance().getMunkit().get(MunkkiList.getInstance().getMunkit().size() - 1); //muokkaa viimeistä alkiota jos tältä päivältä on jo tietoja
                    munkki.setCal(munkki.getCal() + counter.getKcal());  //lisätään uudet arvot vanhoihin
                    munkki.setFat(munkki.getFat() + counter.getFat());
                    munkki.setSugar(munkki.getSugar() + counter.getSugar());
                    munkki.setHinta(munkki.getHinta() + counter.getCost());
                    munkki.addArvostelu(rating); // arvostelut tallentuvat päiväkohtaisesti listaan ja näin saadaan laskettua keskiarvo jos päivältä tulee useita arvosteluja
                    munkki.addMunkkiKpl(b.toString(), kpl);

                }
                if (MunkkiList.getInstance().getMunkit().size() > 30){ //pitää listassa maksimissaan 30 alkiota
                    MunkkiList.getInstance().getMunkit().remove(0);
                }

                Intent backToMain = new Intent(SyotaTiedotActivity.this, MainActivity.class); //palaa mainactivityyn
                backToMain.putExtra(Talle, 1);
                startActivity(backToMain);
            }
        });
    }
}