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

public class RecyclerVerticalAdapter extends RecyclerView.Adapter<RecyclerVerticalAdapter.RecyclerHolder> {

    Context mContext;
    List<RecyclerModel> fruitList;

    public RecyclerVerticalAdapter(Context mContext, List<RecyclerModel> fruitList) {
        this.mContext = mContext;
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recycler_vertical_list_item, parent, false);

        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {


        holder.list_our_fruits_textview.setText(fruitList.get(position).getFruitName());

        holder.list_vertical_constraint.setOnClickListener(v -> {

            switch (position) {

                case 0:
                    Toast.makeText(mContext, fruitList.get(position).getFruitName(), Toast.LENGTH_SHORT).show();
                    break;

                case 1:
                    Toast.makeText(mContext, fruitList.get(position).getFruitName(), Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    Toast.makeText(mContext, fruitList.get(position).getFruitName(), Toast.LENGTH_SHORT).show();
                    break;

                case 3:
                    Toast.makeText(mContext, fruitList.get(position).getFruitName(), Toast.LENGTH_SHORT).show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }



    public class RecyclerHolder extends RecyclerView.ViewHolder {

        ConstraintLayout list_vertical_constraint;
        TextView list_our_fruits_textview;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            list_vertical_constraint = itemView.findViewById(R.id.list_vertical_constraint);

            list_our_fruits_textview = itemView.findViewById(R.id.list_our_fruits_textview);
        }
    }
}
