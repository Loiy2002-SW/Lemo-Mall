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

import java.util.List;

public class RecyclerOrdersAdapter extends RecyclerView.Adapter<RecyclerOrdersAdapter.RecyclerHolder> {

    // fields declaration.
    Context mContext;
    List<RecyclerFruitsModel> ordersList;



    public RecyclerOrdersAdapter(Context mContext, List<RecyclerFruitsModel> ordersList) {
        this.mContext = mContext;
        this.ordersList = ordersList;
    }



    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.orders_item_list, parent, false);

        return new RecyclerHolder(view);
    }

    // in this method the data from the list will be filled in the views depending on the position.
    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {


        holder.list_id_textview.setText(ordersList.get(position).getOrderId());
        holder.list_total_price_textview.setText(ordersList.get(position).getFruitPrice()+"JD");

        holder.list_delete_imageview.setOnClickListener(v -> {

            Toast.makeText(mContext, ordersList.get(position).getOrderId() +": is "+mContext.getString(R.string.canceled_str), Toast.LENGTH_SHORT).show();

            ordersList.remove(position);

            if(ordersList.size() == 1){
                notifyDataSetChanged();
            }else {

                notifyItemRemoved(position);
            }

            });


    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }



    public class RecyclerHolder extends RecyclerView.ViewHolder {

        // fields declaration.
        ImageView list_delete_imageview;
        TextView list_id_textview, list_total_price_textview;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            // initializations.
            list_delete_imageview = itemView.findViewById(R.id.list_delete_imageview);

            list_id_textview = itemView.findViewById(R.id.list_id_textview);
            list_total_price_textview = itemView.findViewById(R.id.list_total_price_textview);


        }
    }
}
