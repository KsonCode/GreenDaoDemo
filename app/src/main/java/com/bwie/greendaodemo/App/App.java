package com.bwie.greendaodemo.App;

import android.app.Application;
import android.content.Context;

import com.bwie.greendaodemo.utils.GreenDaoUtils;

public class App extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        //初始化各对象
        GreenDaoUtils.getInstance().init();

    }
}
