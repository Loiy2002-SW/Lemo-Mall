package com.loiy.lemomall.ui;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.loiy.lemomall.R;
import com.loiy.lemomall.adapter.RecyclerFruitsAdapter;
import com.loiy.lemomall.adapter.RecyclerVerticalHomeAdapter;
import com.loiy.lemomall.model.BaseMenu;
import com.loiy.lemomall.model.RecyclerFruitsModel;

import java.util.ArrayList;
import java.util.List;

public class WinterFruits extends BaseMenu {

    // fields declaration.
    RecyclerView winter_fruits_recycler;

    // create a list to sent it's data to the adapter.
    List<RecyclerFruitsModel> fruitsModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winter_fruits);


        //this method will show the more_option icon and the back arrow.
        showViews(false, getString(R.string.winter_fruits_str));

        // initialization.
        winter_fruits_recycler = findViewById(R.id.winter_fruits_recycler);

        //get the array-string from string.xml into the java file using getStringArray method.
        String[] fruitNames = getResources().getStringArray(R.array.fruitNames);
        String[] fruitPrices = getResources().getStringArray(R.array.fruitPrices);

        // fill the list with fruits data
        for (int i = 0; i < GreenFruits.fruitsImages.length; i++) {
            fruitsModelList.add(new RecyclerFruitsModel(GreenFruits.fruitsImages[i], fruitNames[i], fruitPrices[i], GreenFruits.numberOfAdditions[i]));
        }
        // prepare the adapter to set it to the recycler view.
        RecyclerFruitsAdapter recyclerFruitsAdapter = new RecyclerFruitsAdapter(getApplicationContext(), fruitsModelList);

        //set the adapter to the recycler view, and set the layout to grid with 2 columns.
        winter_fruits_recycler.setAdapter(recyclerFruitsAdapter);
        winter_fruits_recycler.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

    }
}