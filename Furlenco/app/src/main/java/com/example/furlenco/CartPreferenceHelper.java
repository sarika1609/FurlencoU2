package com.example.furlenco;

import android.content.Context;
import android.content.SharedPreferences;

public final class CartPreferenceHelper {
    public static final String PREF_DB_NAME = "cart_database";
    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences= context.getSharedPreferences(PREF_DB_NAME, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static void WriteString( String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static String getString(String key){
        return sharedPreferences.getString(key,"");
    }
}
