package com.mabadiku.marketplace.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.model.Produk;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProdukListAdapter extends RecyclerView.Adapter<ProdukListAdapter.ViewHolder> {

    public List<Produk> getProdukList() {
        return produkList;
    }

    public void setProdukList(List<Produk> produkList) {
        this.produkList = produkList;
    }

    List<Produk> produkList;
    Context context;

    public ProdukListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProdukListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.produk, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdukListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.namaProduk.setText(produkList.get(i).getNama());
        int terjual =  produkList.get(i).getJumlah()-produkList.get(i).getSisa();
        viewHolder.produkTerjual.setText("Terjual : " + terjual);
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        viewHolder.hargaProduk.setText(kursIndonesia.format(produkList.get(i).getHarga()));
        String linkGambar = "https://lugubrious-forks.000webhostapp.com/gambar/" + produkList.get(i).getImagepath();
        Glide.with(context)
                .load(linkGambar)
                .into(viewHolder.gambarProduk);

    }

    @Override
    public int getItemCount() {
        return produkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gambarProduk;
        TextView namaProduk;
        TextView hargaProduk;
        TextView produkTerjual;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarProduk = (ImageView) itemView.findViewById(R.id.produkImage);
            namaProduk = (TextView) itemView.findViewById(R.id.namaListProduk);
            hargaProduk = (TextView) itemView.findViewById(R.id.hargaListProduk);
            produkTerjual = (TextView)itemView.findViewById(R.id.listTerjualProduk);


        }
    }
}
