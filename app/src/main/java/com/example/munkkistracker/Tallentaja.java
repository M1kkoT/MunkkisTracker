package com.example.munkkistracker;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.savedstate.SavedStateRegistry;

public class Tallentaja {
    private List<Munkkitiedot> lista;
    private Gson gson;
    public static final String  Pref = "talle";
    private Context context;

    public Tallentaja(Context context){
        lista = MunkkiList.getInstance().getMunkit();
        gson = new Gson();
        this.context = context;

    }

    public void Save(){
        String json = gson.toJson(lista);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Pref, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("lista", json);
        editor.commit();




    }
    public void Load(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(Pref, 0);
        String json = sharedPreferences.getString("lista", "tyhjä");
        if (json.equals("tyhjä")){
            return;
        }
        TypeToken<List<Munkkitiedot>> token = new TypeToken<List<Munkkitiedot>>() {};
        lista = gson.fromJson(json, token.getType());
        for (int i = 0; i < lista.size(); i++){
            MunkkiList.getInstance().getMunkit().add(lista.get(i));

        }





    }

}
