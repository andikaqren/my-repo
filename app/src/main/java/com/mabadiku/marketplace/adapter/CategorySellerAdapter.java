package com.mabadiku.marketplace.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mabadiku.marketplace.R;

public class CategorySellerAdapter extends RecyclerView.Adapter<CategorySellerAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categoryseller,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView posterCategory;
        TextView deskripsiCategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            posterCategory=(ImageView)itemView.findViewById(R.id.posterCategory);
            deskripsiCategory=(TextView)itemView.findViewById(R.id.namaKategori);
        }
    }
}
