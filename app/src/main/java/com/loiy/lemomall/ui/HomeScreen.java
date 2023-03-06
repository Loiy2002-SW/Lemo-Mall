package com.loiy.lemomall.ui;


import android.os.Bundle;
import android.widget.GridLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loiy.lemomall.R;
import com.loiy.lemomall.adapter.RecyclerHorizontalAdapter;
import com.loiy.lemomall.adapter.RecyclerVerticalAdapter;
import com.loiy.lemomall.model.BaseMenu;
import com.loiy.lemomall.model.RecyclerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends BaseMenu {

    // fields declaration.
    RecyclerView home_recycler_horizontal, home_recycler_vertical;


    // create a list to sent it to the adapter.
    List<RecyclerModel> fruitListHor = new ArrayList<>();

    List<RecyclerModel> fruitListVer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this method will show the more_option icon
        showViews(true, null);

        // initialization.
        home_recycler_horizontal = findViewById(R.id.home_recycler_horizontal);
        home_recycler_vertical = findViewById(R.id.home_recycler_vertical);

        String[] fruitNames = getResources().getStringArray(R.array.fruitNames);

        // fill the list with fruits data
        fruitListHor.add(new RecyclerModel(fruitNames[0], R.drawable.ic_apple));
        fruitListHor.add(new RecyclerModel(fruitNames[1], R.drawable.ic_bananas));
        fruitListHor.add(new RecyclerModel(fruitNames[2], R.drawable.ic_orange));
        fruitListHor.add(new RecyclerModel(fruitNames[3], R.drawable.ic_strawberry));

        RecyclerHorizontalAdapter recyclerHorizontalAdapter = new RecyclerHorizontalAdapter(getApplicationContext(), fruitListHor);

        home_recycler_horizontal.setAdapter(recyclerHorizontalAdapter);
        home_recycler_horizontal.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        // fill the list with fruits data
        fruitListVer.add(new RecyclerModel(fruitNames[0]));
        fruitListVer.add(new RecyclerModel(fruitNames[1]));
        fruitListVer.add(new RecyclerModel(fruitNames[2]));
        fruitListVer.add(new RecyclerModel(fruitNames[3]));

        RecyclerVerticalAdapter recyclerVerticalAdapter = new RecyclerVerticalAdapter(getApplicationContext(), fruitListVer);

        home_recycler_vertical.setAdapter(recyclerVerticalAdapter);
        home_recycler_vertical.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));


    }
}