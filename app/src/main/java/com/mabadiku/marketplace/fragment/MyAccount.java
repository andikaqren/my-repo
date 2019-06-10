package com.mabadiku.marketplace.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mabadiku.marketplace.R;
import com.mabadiku.marketplace.preference.UserPreference;
import com.mabadiku.marketplace.view.LoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyAccount extends Fragment implements View.OnClickListener{
    Button btnLogout;
    UserPreference userPreference;


    public MyAccount() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }
    public void onViewCreated(@NonNull View view ,Bundle savedInstanceBundle){
        super.onViewCreated(view,savedInstanceBundle);
        btnLogout = view.findViewById(R.id.myAccountLogout);
        btnLogout.setOnClickListener(this);
        userPreference = new UserPreference(view.getContext());



    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.myAccountLogout){
            userPreference.setIsLogin(false);
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
