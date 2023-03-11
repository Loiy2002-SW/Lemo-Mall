package com.loiy.lemomall.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.loiy.lemomall.R;
import com.loiy.lemomall.data.UserData;
import com.loiy.lemomall.sharedPreference.SharedPreferencesManager;

public class SplashScreen extends AppCompatActivity implements UserData {

    private boolean isLogin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        fillUserDataArrayList();
        //check the login state
        if(SharedPreferencesManager.getInstance(getApplicationContext()).getLogin()){
            isLogin = true;
        }

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isLogin){

                    startActivity(new Intent(getApplicationContext(), HomeScreen.class));
                    finish();
                }else {
                    startActivity(new Intent(getApplicationContext(), LoginScreen.class));
                    finish();
                }


            }
        },3000);

    }

    private void fillUserDataArrayList(){


        // fill the primary data

        fullNames_arrayList.add("Hassan Karraz");
        fullNames_arrayList.add("Omar Ahmad");
        fullNames_arrayList.add("Loiy Al-hasan");


        emails_arrayList.add("hassan@gmail.com");
        emails_arrayList.add("omar@gmail.com");
        emails_arrayList.add("loiy@gmail.com");

        phoneNumbers_arrayList.add("0777888999");
        phoneNumbers_arrayList.add("0796777888");
        phoneNumbers_arrayList.add("0788899977");

        passwords_arrayList.add("0000Hhhh");
        passwords_arrayList.add("1111Oooo");
        passwords_arrayList.add("2222Llll");

    }



}