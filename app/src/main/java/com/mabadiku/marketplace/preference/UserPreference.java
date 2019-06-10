package com.mabadiku.marketplace.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference  {
    private final SharedPreferences sharedPreferences;
    private static String PREFS_NAME = "User_pref";
    private static String IS_LOGIN= "isLogin";
    private static String USER_NAME = "userName";
    private static String MEMBER_STATUS= "memberStatus";


    public UserPreference(Context context) {
        this.sharedPreferences =context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
    }
    public void setIsLogin(boolean isLogin){
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putBoolean(IS_LOGIN,isLogin);
        editor.apply();
    }
    public boolean getIsLogin(){
        return sharedPreferences.getBoolean(IS_LOGIN,false);

    }

    public void setUserName(String userName){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME,userName);
        editor.apply();
    }
    public String getUserName(){
        return sharedPreferences.getString(USER_NAME,"");
    }

    public void setMemberStatus(String memberStatus){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MEMBER_STATUS,memberStatus);
        editor.apply();
    }
    public String getMemberStatus(){
        return sharedPreferences.getString(MEMBER_STATUS,"");
    }
}
