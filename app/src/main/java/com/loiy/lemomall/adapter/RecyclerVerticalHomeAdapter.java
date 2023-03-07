package com.loiy.lemomall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.loiy.lemomall.R;
import com.loiy.lemomall.model.RecyclerHomeModel;

import java.util.List;

public class RecyclerVerticalHomeAdapter extends RecyclerView.Adapter<RecyclerVerticalHomeAdapter.RecyclerHolder> {

    // fields declaration.
    Context mContext;
    List<RecyclerHomeModel> fruitList;
    private OnItemClickVerticalListener listener;

    public RecyclerVerticalHomeAdapter(Context mContext, List<RecyclerHomeModel> fruitList, OnItemClickVerticalListener listener) {
        this.mContext = mContext;
        this.fruitList = fruitList;
        this.listener = listener;
    }

    // this interface is used to make a listener from outside the adapter (from the home screen).
    public interface OnItemClickVerticalListener {
        void onItemClick(int position);
    }

    // in this method the data from the list will be filled in the views depending on the position.
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


                    Toast.makeText(mContext, fruitList.get(position).getFruitName(), Toast.LENGTH_SHORT).show();
                    listener.onItemClick(position);



        });


    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }



    public class RecyclerHolder extends RecyclerView.ViewHolder {

        // fields declaration.
        ConstraintLayout list_vertical_constraint;
        TextView list_our_fruits_textview;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            // initializations.
            list_vertical_constraint = itemView.findViewById(R.id.list_vertical_constraint);

            list_our_fruits_textview = itemView.findViewById(R.id.list_our_fruits_textview);
        }
    }
}
