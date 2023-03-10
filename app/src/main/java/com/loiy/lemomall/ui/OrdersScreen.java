package com.loiy.lemomall.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.loiy.lemomall.R;
import com.loiy.lemomall.adapter.RecyclerFruitsAdapter;
import com.loiy.lemomall.adapter.RecyclerOrdersAdapter;
import com.loiy.lemomall.model.BaseMenu;
import com.loiy.lemomall.model.RecyclerFruitsModel;

import java.util.ArrayList;
import java.util.List;

public class OrdersScreen extends BaseMenu {


    // fields declaration.
    RecyclerView orders_recycler;

    // create a list to sent it's data to the adapter.
    public static List<RecyclerFruitsModel> fruitsModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_screen);


        //this method will show the more_option icon and the back arrow.
        showViews(false, getString(R.string.orders_str));

        // initialization.
        orders_recycler = findViewById(R.id.orders_recycler);

        // prepare the adapter to set it to the recycler view.
        RecyclerOrdersAdapter recyclerOrdersAdapter = new RecyclerOrdersAdapter(getApplicationContext(), fruitsModelList);

        //set the adapter to the recycler view, and set the layout to grid with 2 columns.
        orders_recycler.setAdapter(recyclerOrdersAdapter);
        orders_recycler.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

    }
}