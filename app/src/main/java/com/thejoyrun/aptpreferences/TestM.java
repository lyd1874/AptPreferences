package com.thejoyrun.aptpreferences;


import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;

@AptMMap
public class TestM {

    private UserInfo userInfo;

    private ArrayList<UserInfo> list;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ArrayList<UserInfo> getList() {
        return list;
    }

    public void setList(ArrayList<UserInfo> list) {
        this.list = list;
    }

    public ArrayList<UserInfo> changeList(String str){
        Log.e("lyd","　changeList　"+str);
        return (ArrayList<UserInfo>) JSONObject.parseArray(str,UserInfo.class);
    }
}
