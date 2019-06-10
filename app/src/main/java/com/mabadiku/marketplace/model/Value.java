package com.mabadiku.marketplace.model;

import com.mabadiku.marketplace.model.Produk;

import java.util.List;

import javax.xml.transform.Result;

public class Value {

    String value;
    String message;

    public List<Produk> getResult() {
        return result;
    }

    List<Produk> result;

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
