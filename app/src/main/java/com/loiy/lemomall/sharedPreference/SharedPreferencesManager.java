package com.loiy.lemomall.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

    private static final String SHARED_PREF_NAME= "SharedPreferences";
    private static final String KEY_IS_LOGIN= "keyIsLogin";


    private static SharedPreferencesManager mInstance;
    private static Context mCtx;

    //singleton
    private SharedPreferencesManager(Context context){
        mCtx = context;
    }

    //initialization SharedPreferencesManager class only from this method
    public static synchronized SharedPreferencesManager getInstance(Context context){
        if (mInstance == null){
            mInstance = new SharedPreferencesManager(context);
        }

        return mInstance;
    }

    public void saveLogin(boolean isLogin){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(KEY_IS_LOGIN, isLogin);
        editor.apply();


    }

    public boolean getLogin(){

        SharedPreferences  sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getBoolean(KEY_IS_LOGIN,false);

    }



}