package com.mabadiku.marketplace.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.mabadiku.marketplace.view.DetailProduk;
import com.mabadiku.marketplace.listener.ItemClickSupport;
import com.mabadiku.marketplace.api.LoginAPI;
import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.model.Value;
import com.mabadiku.marketplace.adapter.ListCategoryAdapter;
import com.mabadiku.marketplace.adapter.ProdukListAdapter;
import com.mabadiku.marketplace.loader.KategoriLoader;
import com.mabadiku.marketplace.model.Category;
import com.mabadiku.marketplace.model.Produk;
import com.mabadiku.marketplace.view.CarouselView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener, LoaderManager.LoaderCallbacks<ArrayList<Category>> {

    RecyclerView rvCategory;
    ListCategoryAdapter categoryAdapter;
    Button closeButton, moreButton;
    ProgressBar produkProgressBar;
    CarouselView carouselView;
    String[] categoryName;
    TypedArray categoryPhoto;
    ProgressBar categoryProgressBar;
    RecyclerView rvProdukList;
    List<Produk> produkList;
    ProdukListAdapter produkListAdapter;
    public static String produk ="produk";
    private String url = "https://lugubrious-forks.000webhostapp.com/";


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

        categoryAdapter = new ListCategoryAdapter(this.getContext());
        rvCategory = view.findViewById(R.id.rvCategory);
        rvProdukList=view.findViewById(R.id.recycleProdukList);
        moreButton = view.findViewById(R.id.moreButton);
        produkProgressBar = view.findViewById(R.id.progressListProduk);
        categoryProgressBar =(ProgressBar) view.findViewById(R.id.progressCategoryHome);
        moreButton.setOnClickListener(this);
        long carouselSlideInterval = 3000; // 3 SECONDS
        int[] imageResourceIds = {R.drawable.promo1, R.drawable.promo2, R.drawable.promo3, R.drawable.promo4, R.drawable.promo5};
        carouselView = (CarouselView) view.findViewById(R.id.carousel_view);
        carouselView.setData(getFragmentManager(), imageResourceIds, carouselSlideInterval);
        LoaderManager.getInstance(getActivity()).initLoader(0, null, this);
        prepareProdukList();
    }

    private void init() {

    }
    private void prepareProdukList(){
        rvProdukList.setLayoutManager(new GridLayoutManager(this.getContext(),2));
        produkListAdapter = new ProdukListAdapter(this.getContext());
        loadDataProduk();
        produkProgressBar.setVisibility(View.VISIBLE);

    }
    private void loadDataProduk(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginAPI api = retrofit.create(LoginAPI.class);
        Call<Value> call = api.view();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                Log.d("Success","1");
                produkProgressBar.setVisibility(View.GONE);
                if(value.equals("1")){
                    produkList = response.body().getResult();
                    produkListAdapter.setProdukList(produkList);
                    rvProdukList.setAdapter(produkListAdapter);
                    ItemClickSupport.addTo(rvProdukList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                        @Override
                        public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                            Produk produks = produkList.get(position);
                            Intent detail = new Intent(getActivity(), DetailProduk.class);
                            detail.putExtra(produk,produks);
                            Log.d("Produk",produks.getSellerid());
                            Log.d("Produk",produks.getDeskripsi());
                            startActivity(detail);
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Log.d("Success","0");
                Log.d("success",t.getMessage());
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.moreButton) {
            categoryAdapter.setMore(true);
            moreButton.setVisibility(View.GONE);
            categoryAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        carouselView.onDestroy();
    }


    @NonNull
    @Override
    public Loader<ArrayList<Category>> onCreateLoader(int i, @Nullable Bundle bundle) {
        categoryProgressBar.setVisibility(View.VISIBLE);
        rvCategory.setVisibility(View.INVISIBLE);
        return new KategoriLoader(getActivity());


    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Category>> loader, ArrayList<Category> categories) {
        categoryProgressBar.setVisibility(View.GONE);
        rvCategory.setVisibility(View.VISIBLE);
        categoryAdapter.setListCategory(categories);
        categoryAdapter.setMore(false);
        rvCategory.setNestedScrollingEnabled(false);
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(new GridLayoutManager(this.getContext(), 5));
        rvCategory.setAdapter(categoryAdapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Category>> loader) {
        categoryAdapter.setListCategory(null);
    }
}
