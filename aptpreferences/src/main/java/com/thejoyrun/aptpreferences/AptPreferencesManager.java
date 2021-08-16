package com.thejoyrun.aptpreferences;

import android.content.Context;
import android.util.Log;

import com.tencent.mmkv.MMKV;

public final class AptPreferencesManager {
    private static Context sContext;

    private static AptParser sAptParser;

    private static String sUserInfo;

    public static void init(Context context, AptParser aptParser) {
        sContext = context;
        sAptParser = aptParser;

        String rootDir = MMKV.initialize(context);
        Log.e("AptPreferences","MMKV Root Dir："+rootDir);
    }

    public static Context getContext() {
        return sContext;
    }

    public static AptParser getAptParser() {
        return sAptParser;
    }

    public static void setUserInfo(String userInfo) {
        sUserInfo = userInfo;
    }

    public static String getUserInfo() {
        return sUserInfo;
    }
}
