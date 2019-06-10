package com.mabadiku.marketplace.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.fragment.HomeFragment;
import com.mabadiku.marketplace.model.Produk;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DetailProduk extends AppCompatActivity {
    Produk produk;
    ImageView gambarProduk;
    TextView namaProduk, hargaProduk, deskripsiProduk, jumlahProduk, sisaProduk, namaToko,lokasiToko;
    Button kunjungiToko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);
        produk = getIntent().getParcelableExtra(HomeFragment.produk);
        prepare();
        setView();

    }
    private void prepare(){
        gambarProduk = findViewById(R.id.detailGambarProduk);
        namaProduk = findViewById(R.id.detailNamaProduk);
        hargaProduk = findViewById(R.id.detailHargaProduk);
        deskripsiProduk = findViewById(R.id.detailDeskripsiProduk);
        jumlahProduk = findViewById(R.id.detailJumlahStokProduk);
        sisaProduk = findViewById(R.id.detailSisaProduk);
        namaToko= findViewById(R.id.detailNamaToko);
        lokasiToko = findViewById(R.id.detailLokasiTOko);
        kunjungiToko = findViewById(R.id.detailKunjungiToko);


    }

    private void setView(){
        String linkGambar = "https://lugubrious-forks.000webhostapp.com/gambar/" + produk.getImagepath();
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        Glide.with(this)
                .load(linkGambar)
                .into(gambarProduk);
        namaProduk.setText(produk.getNama());
        deskripsiProduk.setText(produk.getDeskripsi());
        jumlahProduk.setText("Jumlah Produk : " + produk.getJumlah());
        hargaProduk.setText(kursIndonesia.format(produk.getHarga()));
        sisaProduk.setText("Sisa Produk : " + produk.getSisa());
        Log.d("Produk",produk.getSellerid());
        Log.d("Produk",produk.getDeskripsi());
        namaToko.setText(produk.getSellerid());
        lokasiToko.setText(produk.getSellerid());

    }
}
