package com.loiy.lemomall.ui;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.loiy.lemomall.R;
import com.loiy.lemomall.adapter.RecyclerFruitsAdapter;
import com.loiy.lemomall.model.BaseMenu;
import com.loiy.lemomall.model.RecyclerFruitsModel;

import java.util.ArrayList;
import java.util.List;

public class SummerFruits extends BaseMenu {

    // fields declaration.
    RecyclerView summer_fruits_recycler;

    // create a list to sent it's data to the adapter.
    List<RecyclerFruitsModel> fruitsModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_fruits);

        //this method will show the more_option icon and the back arrow.
        showViews(false, getString(R.string.summer_fruits_str));


        // initialization.
        summer_fruits_recycler = findViewById(R.id.summer_fruits_recycler);

        //get the array-string from string.xml into the java file using getStringArray method.
        String[] fruitNames = getResources().getStringArray(R.array.fruitNames);
        String[] fruitPrices = getResources().getStringArray(R.array.fruitPrices);

        // fill the list with fruits data
        fruitsModelList.add(new RecyclerFruitsModel(R.drawable.ic_apple, fruitNames[0], fruitPrices[0], 0));
        fruitsModelList.add(new RecyclerFruitsModel(R.drawable.ic_orange, fruitNames[1], fruitPrices[1], 0));
        fruitsModelList.add(new RecyclerFruitsModel(R.drawable.ic_bananas, fruitNames[2], fruitPrices[2], 0));
        fruitsModelList.add(new RecyclerFruitsModel(R.drawable.ic_strawberry, fruitNames[3], fruitPrices[3], 0));
        fruitsModelList.add(new RecyclerFruitsModel(R.drawable.ic_kiwi, fruitNames[4], fruitPrices[4], 0));
        fruitsModelList.add(new RecyclerFruitsModel(R.drawable.ic_melon, fruitNames[5], fruitPrices[5], 0));
        fruitsModelList.add(new RecyclerFruitsModel(R.drawable.ic_pineapple, fruitNames[6], fruitPrices[6], 0));
        fruitsModelList.add(new RecyclerFruitsModel(R.drawable.ic_lemon, fruitNames[7], fruitPrices[7], 0));

        // prepare the adapter to set it to the recycler view.
        RecyclerFruitsAdapter recyclerFruitsAdapter = new RecyclerFruitsAdapter(getApplicationContext(), fruitsModelList);

        //set the adapter to the recycler view, and set the layout to grid with 2 columns.
        summer_fruits_recycler.setAdapter(recyclerFruitsAdapter);
        summer_fruits_recycler.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

    }
}