package com.thejoyrun.aptpreferences;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//import com.thejoyrun.aptpreferences.preferences.SettingsPreferences;

import java.util.ArrayList;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SettingsPreferences settingsPreference = SettingsPreferences.get();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("last value firstUse: ").append(settingsPreference.getUseLanguage()).append('\n');
//        settingsPreference.setUseLanguage(new Date().toString());
//        TextView textView = (TextView) findViewById(R.id.text);
//        textView.setText(stringBuilder.toString());
////        SettingsPreferences2.get()
//
//
////        settingsPreference.getRun().getVoiceName();
//        // 普通类型保存
//        settingsPreference.setUseLanguage("zh");
//        settingsPreference.setLastOpenAppTimeMillis(System.currentTimeMillis());
//        // 对象类型保存
//        Settings.LoginUser loginUser = new Settings.LoginUser();
//        loginUser.setUsername("username");
//        loginUser.setPassword("password");
//        settingsPreference.setLoginUser(loginUser);
//        // 对象类型带 @AptField(preferences = true) 注解的保存，相当于把 push相关的放在一个分类
//        settingsPreference.getPush().setOpenPush(true);
//
//
//        // 获取
//        String useLanguage = settingsPreference.getUseLanguage();
//        Settings.LoginUser loginUser1 = settingsPreference.getLoginUser();
//        boolean openPush = settingsPreference.getPush().isOpenPush();

        TextView tvTestP = (TextView) findViewById(R.id.TestP);
        TextView tvTestM = (TextView) findViewById(R.id.TestM);
//
//        tvTestP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                long time = System.currentTimeMillis();
//                for (int i = 0;i<10000;i++){
//                    TestPPreferences.get().setName(i+"");
//                    Log.d("lyd","TestP输出: "+TestPPreferences.get().getName());
//                }
//                Log.e("lyd","　TestP "+(System.currentTimeMillis()-time));
//            }
//        });
        tvTestM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                long time = System.currentTimeMillis();
//                for (int i = 0;i<10000;i++){
//                    TestMPreferences.get().setName(i+"");
//                    Log.d("lyd","TestM输出: "+TestMPreferences.get().getName());
//                }
//                Log.e("lyd","　TestM "+(System.currentTimeMillis()-time));
                ArrayList<UserInfo> list = new ArrayList<>();
                list.add(new UserInfo("林"));
                list.add(new UserInfo("杨"));
                list.add(new UserInfo("刘"));
                list.add(new UserInfo("谢"));
                TestMPreferences.get().setList(list);

                UserInfo userInfo =new  UserInfo("Hello Word");

                TestMPreferences.get().setUserInfo(userInfo);

                ArrayList<UserInfo> list1 = TestMPreferences.get().getList();
                for(UserInfo user:list1){
                    Log.e("lyd","　UserInfoD　"+user.getUserName());
                }
                Log.e("lyd","　UserInfoD　"+userInfo.getUserName());
            }
        });
    }

}
