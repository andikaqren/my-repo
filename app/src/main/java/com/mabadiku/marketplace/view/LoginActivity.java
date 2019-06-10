package com.mabadiku.marketplace.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mabadiku.marketplace.api.LoginAPI;
import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.model.Value;
import com.mabadiku.marketplace.preference.UserPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static String email = "email";
    public static String password = "password";
    private String url = "https://lugubrious-forks.000webhostapp.com/";
    EditText usernameEditText;
    EditText passwordEditText;
    ProgressBar progressBar;
    Button loginBtn;
    UserPreference sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditText = findViewById(R.id.loginEditTextEmail);
        passwordEditText = findViewById(R.id.loginEditTextPassword);
        progressBar = findViewById(R.id.progress_login);
        loginBtn = findViewById(R.id.loginBtnLogin);
        loginBtn.setOnClickListener(this);
        progressBar.setVisibility(View.GONE);
        sharedPreferences = new UserPreference(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginBtnLogin) {
            String email = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            Log.d("Login", "LoaderStart");
            progressBar.setVisibility(View.VISIBLE);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            LoginAPI api = retrofit.create(LoginAPI.class);
            Call<Value> call = api.login(email,password);
            call.enqueue(new Callback<Value>() {
                @Override
                public void onResponse(Call<Value> call, Response<Value> response) {
                    Log.d("Result",response.toString());
                    String value = response.body().getValue();
                    String message = response.body().getMessage();

                    if (message.equals("success")) {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        sharedPreferences.setIsLogin(true);
                        sharedPreferences.setUserName(usernameEditText.getText().toString());
                        finish();
                        progressBar.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<Value> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    Log.d("TMessage",t.getMessage());
                }
            });
        }

    }


}
