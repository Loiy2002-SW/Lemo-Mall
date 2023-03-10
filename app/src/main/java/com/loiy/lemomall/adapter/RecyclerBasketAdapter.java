package com.loiy.lemomall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loiy.lemomall.R;
import com.loiy.lemomall.animation.ViewAnimationUtil;
import com.loiy.lemomall.model.RecyclerFruitsModel;
import com.loiy.lemomall.ui.BasketScreen;

import java.util.List;

public class RecyclerBasketAdapter extends RecyclerView.Adapter<RecyclerBasketAdapter.RecyclerHolder> {

    // fields declaration.
    Context mContext;
    List<RecyclerFruitsModel> fruitList;


    public static double wholeTotal = 0;


    public RecyclerBasketAdapter(Context mContext, List<RecyclerFruitsModel> fruitList) {
        this.mContext = mContext;
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recycler_fruits_small_item_list, parent, false);

        return new RecyclerHolder(view);
    }

    // in this method the data from the list will be filled in the views depending on the position.
    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {


        holder.list_fruit_image_imageview.setImageResource(fruitList.get(position).getFruitImage());

        holder.list_fruit_name_textview.setText(fruitList.get(position).getFruitName());
        holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice()+"JD X"+fruitList.get(position).getNumberOfAdditions());

        double total = Double.parseDouble(fruitList.get(position).getFruitPrice()) * fruitList.get(position).getNumberOfAdditions();
        holder.list_total_price_textview.setText(mContext.getString(R.string.total_str)+total+ "JD");

        if(fruitList.get(position).getNumberOfAdditions() == 0){
            holder.list_total_price_textview.setText(mContext.getString(R.string.canceled_str));
            holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice() + "JD");
        }

//            wholeTotal += total;
//            isNotCalculated[position] = false;
//            Toast.makeText(mContext, ""+ position, Toast.LENGTH_SHORT).show();





        holder.list_fruit_add_imageview.setOnClickListener(v -> {


            fruitList.get(position).setNumberOfAdditions(fruitList.get(position).getNumberOfAdditions()+1);
            RecyclerFruitsAdapter.staticFruitArray[position] += 1;
            holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice() + "JD X"  + fruitList.get(position).getNumberOfAdditions());

            double totalA = Double.parseDouble(fruitList.get(position).getFruitPrice()) * fruitList.get(position).getNumberOfAdditions();


            holder.list_total_price_textview.setText(mContext.getString(R.string.total_str)+totalA+ "JD");

            wholeTotal += Double.parseDouble(fruitList.get(position).getFruitPrice());
            BasketScreen.setTotalOfAllFruits(wholeTotal);


        });

        holder.list_fruit_remove_imageview.setOnClickListener(v -> {

            if(fruitList.get(position).getNumberOfAdditions() == 0){

                Toast.makeText(mContext,mContext.getString(R.string.already_zero_str) , Toast.LENGTH_SHORT).show();

            }else if(fruitList.get(position).getNumberOfAdditions() == 1) {

                fruitList.get(position).setNumberOfAdditions(fruitList.get(position).getNumberOfAdditions() - 1);
                RecyclerFruitsAdapter.staticFruitArray[position] = 0;

                holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice() + "JD");

                holder.list_total_price_textview.setText(mContext.getString(R.string.canceled_str));

                wholeTotal -= Double.parseDouble(fruitList.get(position).getFruitPrice());
                BasketScreen.setTotalOfAllFruits(wholeTotal);


            }else {

                fruitList.get(position).setNumberOfAdditions(fruitList.get(position).getNumberOfAdditions()-1);
                RecyclerFruitsAdapter.staticFruitArray[position] -= 1;

                holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice() + "JD X"  + fruitList.get(position).getNumberOfAdditions());

                double totalR = Double.parseDouble(fruitList.get(position).getFruitPrice()) * fruitList.get(position).getNumberOfAdditions();

                holder.list_total_price_textview.setText(mContext.getString(R.string.total_str)+totalR+ "JD");

                wholeTotal -= Double.parseDouble(fruitList.get(position).getFruitPrice());
                BasketScreen.setTotalOfAllFruits(wholeTotal);

            }



        });


    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }



    public class RecyclerHolder extends RecyclerView.ViewHolder {

        // fields declaration.
        ImageView list_fruit_image_imageview, list_fruit_add_imageview, list_fruit_remove_imageview;
        TextView list_fruit_name_textview, list_fruit_price_textview, list_total_price_textview;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            // initializations.
            list_fruit_image_imageview = itemView.findViewById(R.id.list_fruit_image_imageview);
            list_fruit_add_imageview = itemView.findViewById(R.id.list_fruit_add_imageview);
            list_fruit_remove_imageview = itemView.findViewById(R.id.list_fruit_remove_imageview);

            list_fruit_name_textview = itemView.findViewById(R.id.list_fruit_name_textview);
            list_fruit_price_textview = itemView.findViewById(R.id.list_fruit_price_textview);
            list_total_price_textview = itemView.findViewById(R.id.list_total_price_textview);

        }
    }
}
