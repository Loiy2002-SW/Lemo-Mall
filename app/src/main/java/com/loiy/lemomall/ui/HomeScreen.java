package com.loiy.lemomall.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loiy.lemomall.R;
import com.loiy.lemomall.adapter.RecyclerHorizontalHomeAdapter;
import com.loiy.lemomall.adapter.RecyclerVerticalHomeAdapter;
import com.loiy.lemomall.model.BaseMenu;
import com.loiy.lemomall.model.RecyclerHomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends BaseMenu {

    // fields declaration.
    RecyclerView home_recycler_horizontal, home_recycler_vertical;


    // create  lists to sent their data to the adapters.
    List<RecyclerHomeModel> fruitListHor = new ArrayList<>();
    List<RecyclerHomeModel> fruitListVer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this method will show the more_option icon
        showViews(true, null);

        // initializations.
        home_recycler_horizontal = findViewById(R.id.home_recycler_horizontal);
        home_recycler_vertical = findViewById(R.id.home_recycler_vertical);

        //get the array-string from string.xml into the java file using getStringArray method.
        String[] fruitNames = getResources().getStringArray(R.array.fruitTypeNames);

        // fill the list with fruits data
        fruitListHor.add(new RecyclerHomeModel(fruitNames[0], R.drawable.ic_apple));
        fruitListHor.add(new RecyclerHomeModel(fruitNames[1], R.drawable.ic_bananas));
        fruitListHor.add(new RecyclerHomeModel(fruitNames[2], R.drawable.ic_orange));
        fruitListHor.add(new RecyclerHomeModel(fruitNames[3], R.drawable.ic_strawberry));

        // prepare the adapter to set it to the recycler view.
        RecyclerHorizontalHomeAdapter recyclerHorizontalHomeAdapter = new RecyclerHorizontalHomeAdapter(getApplicationContext(), fruitListHor, position -> {

            // open the activity of the chosen fruit type.
            switch (position) {

                case 0:
                    startActivity(new Intent(getApplicationContext(), SummerFruits.class));
                    break;

                case 1:
                    startActivity(new Intent(getApplicationContext(), NewFruits.class));
                    break;

                case 2:
                    startActivity(new Intent(getApplicationContext(), GreenFruits.class));
                    break;

                case 3:
                    startActivity(new Intent(getApplicationContext(), WinterFruits.class));

            }
        });

        //set the adapter to the recycler view, and set the layout to grid with 2 columns.
        home_recycler_horizontal.setAdapter(recyclerHorizontalHomeAdapter);
        home_recycler_horizontal.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        // fill the list with fruits data
        fruitListVer.add(new RecyclerHomeModel(fruitNames[0]));
        fruitListVer.add(new RecyclerHomeModel(fruitNames[1]));
        fruitListVer.add(new RecyclerHomeModel(fruitNames[2]));
        fruitListVer.add(new RecyclerHomeModel(fruitNames[3]));

        // prepare the adapter to set it to the recycler view.
        RecyclerVerticalHomeAdapter recyclerVerticalHomeAdapter = new RecyclerVerticalHomeAdapter(getApplicationContext(), fruitListVer, position -> {

            // open the activity of the chosen fruit type.
            switch (position) {

                case 0:
                    startActivity(new Intent(getApplicationContext(), SummerFruits.class));
                    break;

                case 1:
                    startActivity(new Intent(getApplicationContext(), NewFruits.class));
                    break;

                case 2:
                    startActivity(new Intent(getApplicationContext(), GreenFruits.class));
                    break;

                case 3:
                    startActivity(new Intent(getApplicationContext(), WinterFruits.class));

            }
        });

        //set the adapter to the recycler view, and set the layout to grid with 2 columns.
        home_recycler_vertical.setAdapter(recyclerVerticalHomeAdapter);
        home_recycler_vertical.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));


    }
}