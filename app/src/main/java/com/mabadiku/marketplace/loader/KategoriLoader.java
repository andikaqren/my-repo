package com.mabadiku.marketplace.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;
import com.mabadiku.marketplace.model.Category;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class KategoriLoader extends AsyncTaskLoader<ArrayList<Category>> {
    private ArrayList<Category> mData;
    private boolean mHasResult = false;

    public KategoriLoader(@NonNull Context context) {
        super(context);
        onContentChanged();
    }
    @Override
    protected void onStartLoading() {
        if (takeContentChanged())
            forceLoad();
        else if (mHasResult)
            deliverResult(mData);
    }

    @Override
    public void deliverResult(final ArrayList<Category> data) {
        mData = data;
        mHasResult = true;
        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (mHasResult) {
            mData = null;
            mHasResult = false;
        }
    }

    @Nullable
    @Override
    public ArrayList<Category> loadInBackground() {
        SyncHttpClient client = new SyncHttpClient();
        final ArrayList<Category> categories = new ArrayList<>();

        String url = "https://lugubrious-forks.000webhostapp.com/get.php";
        Log.d("aaa",url);
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("result");
                    Log.d("aaa",list.toString());
                    for (int i = 0; i < list.length(); i++) {
                        JSONObject kategori = list.getJSONObject(i);
                        Category category = new Category(kategori);
                        categories.add(category);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return categories;
    }
}
