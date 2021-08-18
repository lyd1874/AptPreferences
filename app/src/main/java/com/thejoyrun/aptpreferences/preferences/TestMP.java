package com.thejoyrun.aptpreferences.preferences;

import com.tencent.mmkv.MMKV;
import com.thejoyrun.aptpreferences.AptPreferencesManager;
import com.thejoyrun.aptpreferences.TestM;
import com.thejoyrun.aptpreferences.TypeReference;
import com.thejoyrun.aptpreferences.UserInfo;

import java.util.ArrayList;

public class TestMP extends TestM {
    private static TestMP sInstance = new TestMP();

    private final MMKV kv;

    public TestMP() {
        kv = MMKV.mmkvWithID("TestM");
    }

    @Override
    public ArrayList<UserInfo> getList() {
        String text = kv.getString(getRealKey("list",true), null);
//        Object object = null;
//        if (text != null){
//            object = AptPreferencesManager.getAptParser().deserializeList(UserInfo.class,text);
//        }
//        if (object != null){
//            return (ArrayList<UserInfo>) object;
//        }
//        return super.getList();

        Object object = null;
        if (text != null){
            object = AptPreferencesManager.getAptParser().deserialize(new TypeReference<ArrayList<UserInfo>>(){}.getType(),text);
        }
        if (object != null){
            return (ArrayList<UserInfo>) object;
        }
        return super.getList();

//        return super.changeList(text);
    }

    @Override
    public void setList(ArrayList<UserInfo> list) {
        kv.putString(getRealKey("list",true), AptPreferencesManager.getAptParser().serialize(list));
    }

    public static TestMP get() {
        if (sInstance == null){
            synchronized (TestMP.class){
                if (sInstance == null){
                    sInstance = new TestMP();
                }
            }
        }
        return sInstance;
    }

    public void clear() {
        kv.clear().commit();
    }

    public String getRealKey(String key, boolean global) {
        return global ? key : AptPreferencesManager.getUserInfo() + key;
    }

    @Override
    public UserInfo getUserInfo() {
        String text = kv.getString(getRealKey("userInfo",true), null);
        Object object = null;
        if (text != null){
            object = AptPreferencesManager.getAptParser().deserialize(new TypeReference<ArrayList<UserInfo>>(){}.getType(),text);
        }
        if (object != null){
            return (UserInfo) object;
        }
        return super.getUserInfo();
    }


    @Override
    public void setUserInfo(UserInfo userInfo) {
        kv.putString(getRealKey("userInfo",true), AptPreferencesManager.getAptParser().serialize(userInfo));
    }
}
