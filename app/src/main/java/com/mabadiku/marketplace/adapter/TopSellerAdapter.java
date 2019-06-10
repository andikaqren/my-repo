package com.mabadiku.marketplace.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mabadiku.marketplace.R;

public class TopSellerAdapter extends RecyclerView.Adapter<TopSellerAdapter.ViewHolder> {
    @NonNull
    @Override
    public TopSellerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.popular_seller,viewGroup,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TopSellerAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView popularImage;
        TextView popularName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popularImage = itemView.findViewById(R.id.popularImage);
            popularName=itemView.findViewById(R.id.popularName);
        }
    }
}
