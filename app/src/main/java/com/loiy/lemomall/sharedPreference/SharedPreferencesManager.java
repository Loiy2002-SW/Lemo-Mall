package com.loiy.lemomall.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

import com.loiy.lemomall.model.RecyclerFruitsModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreferencesManager {

    private static final String SHARED_PREF_NAME= "SharedPreferences";
    private static final String KEY_IS_LOGIN= "keyIsLogin";
    private static final String KEY_ORDERS_IDS= "keyOrdersId";
    private static final String KEY_ORDERS_PRICES= "keyOrdersPrices";


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

//
//    public void addOrders(String orderId, String orderPrice){
//
//        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putBoolean(KEY_IS_LOGIN, isLogin);
//        editor.apply();
//
//
//    }
//
//    public List<RecyclerFruitsModel> getOrders(){
//
//        SharedPreferences  sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//
//        String IDs = sharedPreferences.getString("keyOrdersId", null);
//        List<String> IdList = new ArrayList<>();
//        if (IDs != null) {
//            IdList = new ArrayList<>(Arrays.asList(listString.split(",")));
//        }
//        return sharedPreferences.getBoolean(KEY_IS_LOGIN,false);
//
//    }
//


}