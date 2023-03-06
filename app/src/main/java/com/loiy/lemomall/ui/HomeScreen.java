package com.loiy.lemomall.ui;


import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.loiy.lemomall.R;
import com.loiy.lemomall.modle.BaseMenu;

public class HomeScreen extends BaseMenu {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this method will show the more_option icon
        showViews(true, null);

    }
}