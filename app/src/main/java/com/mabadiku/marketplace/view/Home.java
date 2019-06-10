package com.mabadiku.marketplace.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.mabadiku.marketplace.fragment.FragmentStore;
import com.mabadiku.marketplace.fragment.HomeFragment;
import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.fragment.CartFragment;
import com.mabadiku.marketplace.fragment.MyAccount;
import com.mabadiku.marketplace.preference.UserPreference;

public class Home extends AppCompatActivity implements View.OnClickListener {
    WebView webView;
    ProgressBar progressBar;
    Button closeButton;
    UserPreference userPreference;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.myCart:
                    item.setChecked(true);

                    fragment = new CartFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contentFragment, fragment)
                            .commit();
                    break;
            }
            switch (item.getItemId()) {
                case R.id.myHome:
                    item.setChecked(true);

                    fragment = new HomeFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contentFragment, fragment)
                            .commit();
                    break;
            }
            switch (item.getItemId()) {
                case R.id.officialStore:
                    item.setChecked(true);

                    fragment = new FragmentStore();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contentFragment, fragment)
                            .commit();
                    break;
            }
            switch (item.getItemId()) {
                case R.id.myAccount:
                    if (!userPreference.getIsLogin()) {
                        Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(login);
                    }
                    else{
                        item.setChecked(true);
                        fragment = new MyAccount();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentFragment,fragment)
                                .commit();
                    }
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        webView = findViewById(R.id.bannerhome);
        progressBar = findViewById(R.id.progress_home);
        closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(this);
        closeButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        if (savedInstanceState == null) {
            Fragment fragment;
            fragment = new HomeFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contentFragment, fragment)
                    .commit();

        }
        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navigationBototm);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        userPreference = new UserPreference(this);

        webView.setWebViewClient(new Home.myWebclient());
        webView.setVisibility(View.VISIBLE);
        webView.loadUrl("https://www.tokopedia.com/promo/");

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.closeButton) {
            webView.setVisibility(View.GONE);
            closeButton.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
        }
    }


    public class myWebclient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else if (webView.getVisibility() == View.VISIBLE) {
            webView.setVisibility(View.GONE);
            closeButton.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
        } else {
            super.onBackPressed();

        }

    }

}
