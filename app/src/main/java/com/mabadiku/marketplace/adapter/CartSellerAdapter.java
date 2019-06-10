package com.mabadiku.marketplace.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.model.CartSeller;

import java.util.ArrayList;

public class CartSellerAdapter extends RecyclerView.Adapter<CartSellerAdapter.ViewHolder> {
    CartItemAdapter cartItemAdapter;
    public Context context;

    public ArrayList<CartSeller> getCartSellerList() {
        return cartSellerList;
    }

    public void setCartSellerList(ArrayList<CartSeller> cartSellerList) {
        this.cartSellerList = cartSellerList;
    }

    private ArrayList<CartSeller> cartSellerList;

    @NonNull
    @Override
    public CartSellerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart, viewGroup, false);
        context = viewGroup.getContext();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartSellerAdapter.ViewHolder viewHolder, int i) {
        cartItemAdapter = new CartItemAdapter();
        viewHolder.cartItemRecycle.setLayoutManager(new LinearLayoutManager(context));
        viewHolder.cartItemRecycle.setAdapter(cartItemAdapter);


    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView cartItemRecycle;
        CheckBox checkBoxSeller;
        TextView totalPrice;
        Button buy;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cartItemRecycle = (RecyclerView) itemView.findViewById(R.id.recycleCartItem);
            checkBoxSeller = (CheckBox) itemView.findViewById(R.id.checkBoxToko);
            totalPrice = (TextView) itemView.findViewById(R.id.textViewTotalPrice);
            buy = (Button) itemView.findViewById(R.id.buttonBuy);
        }


    }
}
