package com.example.munkkistracker;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// singleton luokka munkkilistan tallennukseen
// lisää munkki -> MunkkiList.getInstance().getMunkit.add(object);
// koko lista -> MunkkiList.getInstance().getMunkit()

public class MunkkiList {
    private List<Munkki> munkit;
    private static final MunkkiList ourInstance = new MunkkiList();

    public static MunkkiList getInstance() {


        return ourInstance;
    }

    private MunkkiList() {
        munkit = new ArrayList<>();


    }

    public List<Munkki> getMunkit() { //tällä saa koko listan

        return munkit;
    }

    public Munkki getMunkki(int luku){ //tällä saa yhden munkin listasta indeksillä i
        return munkit.get(luku);

    }

}