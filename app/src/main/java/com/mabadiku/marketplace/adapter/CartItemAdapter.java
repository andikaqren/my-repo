package com.mabadiku.marketplace.adapter;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mabadiku.marketplace.R;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> implements View.OnClickListener{

    @NonNull
    @Override
    public CartItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cartitem,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemAdapter.ViewHolder viewHolder, int i) {

        viewHolder.increase.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tambahJumlahProduk){

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hargaProduk;
        TextView namaProduk;
        Button increase;
        Button decrease;
        Button remove;
        ImageView imageProduk;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hargaProduk = (TextView)itemView.findViewById(R.id.hargaProduk);
            namaProduk= (TextView)itemView.findViewById(R.id.namaProduk);
            increase = (Button)itemView.findViewById(R.id.tambahJumlahProduk);
            decrease = (Button)itemView.findViewById(R.id.kurangJumlahProduk);
            remove = (Button)itemView.findViewById(R.id.deleteProduk);
        }
    }
}
