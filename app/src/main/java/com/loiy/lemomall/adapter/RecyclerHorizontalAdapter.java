package com.loiy.lemomall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.loiy.lemomall.R;
import com.loiy.lemomall.model.RecyclerModel;

import java.util.List;

public class RecyclerHorizontalAdapter extends RecyclerView.Adapter<RecyclerHorizontalAdapter.RecyclerHolder> {

    Context mContext;
    List<RecyclerModel> fruitList;

    public RecyclerHorizontalAdapter(Context mContext, List<RecyclerModel> fruitList) {
        this.mContext = mContext;
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recycler_horizontal_list_item, parent, false);

        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {


        holder.list_fruit_name_textview.setText(fruitList.get(position).getFruitName());
        holder.list_fruit_image_imageview.setImageResource(fruitList.get(position).getFruitImage());

        holder.list_constraint.setOnClickListener(v -> {

            switch (position){

                case 0:
                    Toast.makeText(mContext,fruitList.get(position).getFruitName() , Toast.LENGTH_SHORT).show();
                    break;

                case 1:
                    Toast.makeText(mContext,fruitList.get(position).getFruitName() , Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    Toast.makeText(mContext,fruitList.get(position).getFruitName() , Toast.LENGTH_SHORT).show();
                    break;

                case 3:
                    Toast.makeText(mContext,fruitList.get(position).getFruitName() , Toast.LENGTH_SHORT).show();


            }

        });


    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }



    public class RecyclerHolder extends RecyclerView.ViewHolder {

        ConstraintLayout list_constraint;
        TextView list_fruit_name_textview;
        ImageView list_fruit_image_imageview;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            list_constraint = itemView.findViewById(R.id.list_horizontal_constraint);

            list_fruit_name_textview = itemView.findViewById(R.id.list_fruit_name_textview);
            list_fruit_image_imageview = itemView.findViewById(R.id.list_fruit_image_imageview);
        }
    }
}
