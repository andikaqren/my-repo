package com.mabadiku.marketplace.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Produk implements Parcelable {

    int id;

    public int getIdkategory() {
        return idkategory;
    }

    int idkategory;

    public int getId() {
        return id;
    }

    public int getHarga() {
        return harga;
    }

    public String getSellerid() {
        return sellerid;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getSisa() {
        return sisa;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getImagepath() {
        return imagepath;
    }

    int harga;
    String sellerid;
    String nama;
    int jumlah;
    int sisa;
    String deskripsi;
    String imagepath;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.idkategory);
        dest.writeInt(this.harga);
        dest.writeString(this.sellerid);
        dest.writeString(this.nama);
        dest.writeInt(this.jumlah);
        dest.writeInt(this.sisa);
        dest.writeString(this.deskripsi);
        dest.writeString(this.imagepath);
    }

    public Produk() {
    }

    protected Produk(Parcel in) {
        this.id = in.readInt();
        this.idkategory = in.readInt();
        this.harga = in.readInt();
        this.sellerid = in.readString();
        this.nama = in.readString();
        this.jumlah = in.readInt();
        this.sisa = in.readInt();
        this.deskripsi = in.readString();
        this.imagepath = in.readString();
    }

    public static final Parcelable.Creator<Produk> CREATOR = new Parcelable.Creator<Produk>() {
        @Override
        public Produk createFromParcel(Parcel source) {
            return new Produk(source);
        }

        @Override
        public Produk[] newArray(int size) {
            return new Produk[size];
        }
    };
}
