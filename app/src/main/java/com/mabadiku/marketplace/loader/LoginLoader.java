package com.mabadiku.marketplace.loader;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;
import com.mabadiku.marketplace.model.Category;
import com.mabadiku.marketplace.view.LoginActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class LoginLoader extends AsyncTaskLoader<String> {
    private String response = "";
    private String email;
    private String password;
    private boolean mHasResult;
    private String mData;

    public LoginLoader(@NonNull Context context, Bundle bundle) {
        super(context);
        email = bundle.getString(LoginActivity.email);
        password = bundle.getString(LoginActivity.password);
        Log.d("Login", email);
        Log.d("Login", password);
        onContentChanged();
    }

    @Override
    protected void onStartLoading() {
        Log.d("Login","OnStartLoading");
        forceLoad();
    }



    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        Log.d("Login","Onreset");
        if (mHasResult) {
            mData = null;
            mHasResult = false;
        }
    }

    @Nullable
    @Override
    public String loadInBackground() {
        final SyncHttpClient client = new SyncHttpClient();
        String url = "https://lugubrious-forks.000webhostapp.com/inserDB.php";
        RequestParams requestParams = new RequestParams();
        requestParams.add("email", email);
        Log.d("Login", "test");
        requestParams.add("password", password);
        client.post(url, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    response = responseObject.getString("message");
                    Log.d("Login", responseObject.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return response;
    }
}
