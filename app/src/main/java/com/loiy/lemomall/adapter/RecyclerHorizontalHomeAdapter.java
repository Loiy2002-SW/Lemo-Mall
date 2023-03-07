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
import com.loiy.lemomall.model.RecyclerHomeModel;

import java.util.List;

public class RecyclerHorizontalHomeAdapter extends RecyclerView.Adapter<RecyclerHorizontalHomeAdapter.RecyclerHolder> {

    // fields declaration.
    Context mContext;
    List<RecyclerHomeModel> fruitList;
    private OnItemClickHorizontalListener listener;

    public RecyclerHorizontalHomeAdapter(Context mContext, List<RecyclerHomeModel> fruitList, OnItemClickHorizontalListener listener) {
        this.mContext = mContext;
        this.fruitList = fruitList;
        this.listener = listener;
    }

    // this interface is used to make a listener from outside the adapter (from the home screen).
    public interface OnItemClickHorizontalListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recycler_horizontal_list_item, parent, false);

        return new RecyclerHolder(view);
    }

    // in this method the data from the list will be filled in the views depending on the position.
    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {


        holder.list_fruit_name_textview.setText(fruitList.get(position).getFruitName());
        holder.list_fruit_image_imageview.setImageResource(fruitList.get(position).getFruitImage());

        holder.list_constraint.setOnClickListener(v -> {


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
        ConstraintLayout list_constraint;
        TextView list_fruit_name_textview;
        ImageView list_fruit_image_imageview;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            // initializations.
            list_constraint = itemView.findViewById(R.id.list_horizontal_constraint);

            list_fruit_name_textview = itemView.findViewById(R.id.list_fruit_name_textview);
            list_fruit_image_imageview = itemView.findViewById(R.id.list_fruit_image_imageview);
        }
    }
}
