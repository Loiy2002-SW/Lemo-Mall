package com.loiy.lemomall.ui;

import android.os.Bundle;

import com.loiy.lemomall.R;
import com.loiy.lemomall.modle.BaseMenu;

public class AcceptanceOrderScreen extends BaseMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceptance_order_screen);

        //this method will show the more_option icon
        showViews(false, getString(R.string.home_word_str));
    }
}