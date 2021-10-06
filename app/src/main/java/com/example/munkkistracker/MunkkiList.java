package com.example.munkkistracker;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// singleton luokka munkkilistan tallennukseen
// lisää munkki -> MunkkiList.getInstance().getMunkit.add(object);
// koko lista -> MunkkiList.getInstance().getMunkit();

public class MunkkiList {
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

    public Munkkitiedot getMunkkiTiedot(int luku){ //tällä saa yhden munkin listasta indeksillä luku
        return munkit.get(luku);

    }

}