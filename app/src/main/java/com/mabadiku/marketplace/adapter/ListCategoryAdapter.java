package com.mabadiku.marketplace.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.model.Category;

import java.util.ArrayList;

public class ListCategoryAdapter extends RecyclerView.Adapter<ListCategoryAdapter.ViewHolder> {
    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    boolean isMore;
    public ListCategoryAdapter(Context context) {
        this.context = context;
    }

    private Context context;
    public ArrayList<Category> getListCategory() {
        return listCategory;
    }

    public void setListCategory(ArrayList<Category> listCategory) {
        this.listCategory = listCategory;
    }

    private ArrayList<Category> listCategory;
    @NonNull
    @Override
    public ListCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View category= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category,viewGroup,false);
        return new ViewHolder(category);
    }

    @Override
    public void onBindViewHolder(@NonNull ListCategoryAdapter.ViewHolder viewHolder, int i) {
        String linkPoster = "https://lugubrious-forks.000webhostapp.com/gambar/gambar/"+getListCategory().get(i).getResourceImg();
        Glide.with(context)
                .load(linkPoster)
                .into(viewHolder.categoryImg);

        viewHolder.categoryDesc.setText(getListCategory().get(i).getName());


    }

    @Override
    public int getItemCount() {
        if(isMore) {
            return listCategory.size();
        }
        else{
            if(listCategory.isEmpty()){
                return 0;
            }
            else{
                return 5;
            }
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImg;
        TextView categoryDesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryDesc =(TextView)itemView.findViewById(R.id.categoryName);
            categoryImg=(ImageView)itemView.findViewById(R.id.categoryImg);
        }
    }
}
