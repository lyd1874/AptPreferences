package com.thejoyrun.aptpreferences;

import android.app.Application;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wiki on 16/7/15.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AptPreferencesManager.init(this, new AptParser() {

//            Gson gson = new Gson();
            @Override
            public Object deserialize(Type type, String text) {
                if(type.toString().contains("List")){
                    Log.e("lyd"," 有 "+type.toString());
                    try {
                        Class clazz = Class.forName("com.thejoyrun.aptpreferences.UserInfo");
                        return JSON.parseArray(text,clazz);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        return null;
                    }
                }else {
                    Log.e("lyd"," 无 "+type.toString());
                    return JSON.parseObject(text,type);
                }
            }

//            @Override
//            public Object deserializeList(Class clazz, String text) {
//                return JSON.parseArray(text,clazz);
////                return gson.fromJson(text, new TypeToken<ArrayList<UserInfo>>(){}.getType());
//            }
//
//            @Override
//            public Object deserializeType(Type type, String text) {
//                if(type.toString().contains("List")){
//                    Log.e("lyd"," 有 "+type.toString());
//                    try {
//                        Class clazz = Class.forName("com.thejoyrun.aptpreferences.UserInfo");
//                        return JSON.parseArray(text,clazz);
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                        return null;
//                    }
////
//                }else {
//                    Log.e("lyd"," 无 "+type.toString());
//                    return JSON.parseObject(text,type);
//                }
////                return gson.fromJson(text, type);
//            }

            @Override
            public String serialize(Object object) {
                return JSON.toJSONString(object);
//                return gson.toJson(object);
            }
        });
        AptPreferencesManager.setUserInfo("123456");
    }
}
