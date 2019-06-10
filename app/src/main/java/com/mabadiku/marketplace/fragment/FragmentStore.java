package com.mabadiku.marketplace.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.adapter.CategorySellerAdapter;
import com.mabadiku.marketplace.adapter.TopSellerAdapter;
import com.mabadiku.marketplace.view.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStore extends Fragment {
    RecyclerView recycleCategory,recyclePopular;
    TopSellerAdapter topSellerAdapter;
    CategorySellerAdapter categorySellerAdapter;
    Context context;


    public FragmentStore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_store, container, false);
    }
    public void onViewCreated(@NonNull View view , Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        recycleCategory = view.findViewById(R.id.recycleCategory);
        recyclePopular=view.findViewById(R.id.recyclePopular);
        context=view.getContext();
        categorySellerAdapter = new CategorySellerAdapter();
        topSellerAdapter = new TopSellerAdapter();
        LinearLayoutManager horizontalLayoutManager=  new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclePopular.setLayoutManager(horizontalLayoutManager);
        recycleCategory.setNestedScrollingEnabled(false);
        recycleCategory.setLayoutManager(new LinearLayoutManager(context));

        recycleCategory.setAdapter(categorySellerAdapter);
        recyclePopular.setAdapter(topSellerAdapter);


    }

}
