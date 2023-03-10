package com.loiy.lemomall.ui;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loiy.lemomall.R;
import com.loiy.lemomall.adapter.RecyclerBasketAdapter;
import com.loiy.lemomall.adapter.RecyclerFruitsAdapter;
import com.loiy.lemomall.model.BaseMenu;
import com.loiy.lemomall.model.RecyclerFruitsModel;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;

public class BasketScreen extends BaseMenu{

    // fields declaration.
    RecyclerView basket_recycler;
    static TextView basket_total_price_textview, basket_orders_textview;
    EditText basket_address_edittext;


    public static void setTotalOfAllFruits(double totalOfAllFruits) {
        basket_total_price_textview.setText(totalOfAllFruits + "JD");
    }



    // create  lists to sent their data to the adapters.
    List<RecyclerFruitsModel> fruitBasket = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_screen);


        //this method will show the more_option icon
        showViews(false, getString(R.string.basket_str));


        // initializations.
        basket_recycler = findViewById(R.id.basket_recycler);

        basket_total_price_textview = findViewById(R.id.basket_total_price_textview);
        basket_orders_textview = findViewById(R.id.basket_orders_textview);

        basket_address_edittext = findViewById(R.id.basket_address_edittext);


        //get the array-string from string.xml into the java file using getStringArray method.
        String[] fruitNames = getResources().getStringArray(R.array.fruitNames);
        String[] fruitPrices = getResources().getStringArray(R.array.fruitPrices);
        int[] fruitImage = {R.drawable.ic_apple, R.drawable.ic_orange, R.drawable.ic_bananas, R.drawable.ic_strawberry,
                R.drawable.ic_kiwi, R.drawable.ic_melon, R.drawable.ic_pineapple, R.drawable.ic_lemon};

        for (int i = 0; i < RecyclerFruitsAdapter.staticFruitArray.length; i++){

            if(RecyclerFruitsAdapter.staticFruitArray[i] > 0){
                fruitBasket.add(new RecyclerFruitsModel(fruitImage[i], fruitNames[i], fruitPrices[i], RecyclerFruitsAdapter.staticFruitArray[i]));
            RecyclerBasketAdapter.wholeTotal += (Double.parseDouble(fruitPrices[i]) * RecyclerFruitsAdapter.staticFruitArray[i]);
            }
        }

        basket_total_price_textview.setText(RecyclerBasketAdapter.wholeTotal +"JD");

        // prepare the adapter to set it to the recycler view.
        RecyclerBasketAdapter recyclerBasketAdapter = new RecyclerBasketAdapter(getApplicationContext(), fruitBasket);

        //set the adapter to the recycler view, and set the layout to grid with 2 columns.
        basket_recycler.setAdapter(recyclerBasketAdapter);
        basket_recycler.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));

        basket_orders_textview.setOnClickListener(this::onOrderClicked);

    }

    //when order is clicked.
    private void onOrderClicked(View v) {

        if(!basket_address_edittext.getText().toString().isEmpty()){

            Intent goToOrder = new Intent(getApplicationContext(), OrdersScreen.class);
            startActivity(goToOrder);
            //finish();

        }else {

            Toast.makeText(this, getString(R.string.empty_address_str), Toast.LENGTH_SHORT).show();

        }
    }

}