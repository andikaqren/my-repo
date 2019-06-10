package com.mabadiku.marketplace.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.adapter.CartItemAdapter;
import com.mabadiku.marketplace.adapter.CartSellerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {
    RecyclerView cartList;
    CartSellerAdapter cartSellerAdapter;


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }
    public void onViewCreated(@NonNull View view , Bundle savedInstanceState){
        super.onViewCreated(view ,savedInstanceState);
        cartList = view.findViewById(R.id.recycleCartList);
        cartSellerAdapter = new CartSellerAdapter();
        cartList.setLayoutManager(new LinearLayoutManager(getActivity()));
        cartList.setAdapter(cartSellerAdapter);

    }

}
