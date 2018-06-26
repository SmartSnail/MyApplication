package com.example.liulichao.myapplication.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

public class MyApplication extends Application {
    private static Context sContext;
    private static String sCacheDir;
    public static Context getContext(){
        return sContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        if(getExternalCacheDir() != null && ExistSDCard()){
            sCacheDir = getExternalCacheDir().toString();
        }else{
            sCacheDir = getCacheDir().toString();
        }
    }

    private boolean ExistSDCard(){
        return android.os.Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
}
