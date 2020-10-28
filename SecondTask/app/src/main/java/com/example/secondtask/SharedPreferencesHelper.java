package com.example.secondtask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class SharedPreferencesHelper {

    private final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    private final String KEY = "KEY";
    public static final Type TYPE = new TypeToken<Searcher>() {
    }.getType();

    private SharedPreferences sharedPreferences;
    private Gson gson = new Gson();

    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    @SuppressLint("CommitPrefEdits")
    public void addSearcherName(Searcher searcher){
        sharedPreferences.edit().putString( KEY,gson.toJson(searcher, TYPE) ).apply();
    }

    public String getSearcherName(){
        Searcher searcher = gson.fromJson(sharedPreferences.getString(KEY,""), TYPE);
        return searcher != null ?searcher.getName():"";
    }

}
