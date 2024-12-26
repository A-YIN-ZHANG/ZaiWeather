package com.zaiweather.android;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

public class ZaiWeatherApplication extends Application{
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    public static final String TOKEN = "umjyUvcRBZ15PtVo";
    @Override
    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();
    }
}
