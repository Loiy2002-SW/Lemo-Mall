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
import com.loiy.lemomall.ui.GreenFruits;

import java.util.List;

public class RecyclerFruitsAdapter extends RecyclerView.Adapter<RecyclerFruitsAdapter.RecyclerHolder> {

    // fields declaration.
    Context mContext;
    List<RecyclerFruitsModel> fruitList;


    //public static int[] addThisFruit = new int[8];
    //this array will contain the user orders to be shown in the Orders screen.
    public static int[] staticFruitArray = new int[8];

    public RecyclerFruitsAdapter(Context mContext, List<RecyclerFruitsModel> fruitList) {
        this.mContext = mContext;
        this.fruitList = fruitList;
    }



    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recycler_fruits_item_list, parent, false);

        return new RecyclerHolder(view);
    }

    // in this method the data from the list will be filled in the views depending on the position.
    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

        // set the list_total_price_textview to Visible with an animation
        if(fruitList.get(position).getNumberOfAdditions() > 0){
            ViewAnimationUtil.animateViewVisible(holder.list_total_price_textview, 1500,null);
            holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice()+"JD X" + fruitList.get(position).getNumberOfAdditions());

            double total = Double.parseDouble(fruitList.get(position).getFruitPrice()) * fruitList.get(position).getNumberOfAdditions();
            holder.list_total_price_textview.setText(mContext.getString(R.string.total_str)+total+ "JD");
        }else {

            holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice()+"JD");
        }

        holder.list_fruit_image_imageview.setImageResource(fruitList.get(position).getFruitImage());

        holder.list_fruit_name_textview.setText(fruitList.get(position).getFruitName());

        holder.list_fruit_add_imageview.setOnClickListener(v -> {

            // set the list_total_price_textview to Visible with an animation
            if(fruitList.get(position).getNumberOfAdditions() == 0){
                ViewAnimationUtil.animateViewVisible(holder.list_total_price_textview, 1500,null);
            }

                fruitList.get(position).setNumberOfAdditions(fruitList.get(position).getNumberOfAdditions()+1);
                holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice() + "JD X"  + fruitList.get(position).getNumberOfAdditions());

                double total = Double.parseDouble(fruitList.get(position).getFruitPrice()) * fruitList.get(position).getNumberOfAdditions();


                holder.list_total_price_textview.setText(mContext.getString(R.string.total_str)+total+ "JD");

                staticFruitArray[position] +=1;

            GreenFruits.numberOfAdditions[position] = fruitList.get(position).getNumberOfAdditions();

        });

        holder.list_fruit_remove_imageview.setOnClickListener(v -> {

            if(fruitList.get(position).getNumberOfAdditions() == 1){

                // set the list_total_price_textview to gone with an animation
                ViewAnimationUtil.animateViewInvisible(holder.list_total_price_textview, 1000, null);

                fruitList.get(position).setNumberOfAdditions(fruitList.get(position).getNumberOfAdditions()-1);
                holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice() + "JD");


                staticFruitArray[position] -=1;

            }else if (fruitList.get(position).getNumberOfAdditions() == 0){
                Toast.makeText(mContext, mContext.getString(R.string.already_zero_str), Toast.LENGTH_SHORT).show();

            }else {

                fruitList.get(position).setNumberOfAdditions(fruitList.get(position).getNumberOfAdditions()-1);
                holder.list_fruit_price_textview.setText(fruitList.get(position).getFruitPrice() + "JD X"  + fruitList.get(position).getNumberOfAdditions());

                double total = Double.parseDouble(fruitList.get(position).getFruitPrice()) * fruitList.get(position).getNumberOfAdditions();

                holder.list_total_price_textview.setText(mContext.getString(R.string.total_str)+total+ "JD");

                staticFruitArray[position] -=1;

            }


            GreenFruits.numberOfAdditions[position] = fruitList.get(position).getNumberOfAdditions();

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
