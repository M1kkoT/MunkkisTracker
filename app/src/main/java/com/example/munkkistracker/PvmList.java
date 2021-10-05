package com.example.munkkistracker;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// singleton luokka päivämäärän tallennukseen
// lisää pvm -> PvmList.getInstance().getPvm.add(object);
// koko lista -> PvmList.getInstance().getPvm()

public class PvmList {
    private List<String> paivat;
    private static final PvmList ourInstance = new PvmList();

    public static PvmList getInstance() {


        return ourInstance;
    }

    private PvmList() {
        paivat = new ArrayList<>();


    }

    public List<String> getPvm() { //tällä saa koko listan

        return paivat;
    }
}
