package com.mabadiku.marketplace.model;

public class CartItem {
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public int getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(int priceItem) {
        this.priceItem = priceItem;
    }

    public int getJumlahItem() {
        return jumlahItem;
    }

    public void setJumlahItem(int jumlahItem) {
        this.jumlahItem = jumlahItem;
    }

    public int getGambarItem() {
        return gambarItem;
    }

    public void setGambarItem(int gambarItem) {
        this.gambarItem = gambarItem;
    }

    private int idItem;
    private String namaItem;
    private int priceItem;
    private int jumlahItem;
    private int gambarItem;
}
