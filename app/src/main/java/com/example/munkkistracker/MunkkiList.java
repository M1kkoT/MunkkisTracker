package com.example.munkkistracker;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikko Tanhola
 * singleton luokka tietojen tallennukseen
 * tiedot tallennetaan listaan Munkkitiedot-olioina
 * MunkkiListiin pääsee käsiksi kaikkialta sovelluksesta
 *
 */


public class MunkkiList {   //kopioitu opetusdioista
    private List<Munkkitiedot> munkit;
    private static final MunkkiList ourInstance = new MunkkiList();

    public static MunkkiList getInstance() {
        return ourInstance;
    }

    private MunkkiList() {
        munkit = new ArrayList<>();
    }

    public List<Munkkitiedot> getMunkit() { //tällä saa koko listan
        return munkit;
    }



}