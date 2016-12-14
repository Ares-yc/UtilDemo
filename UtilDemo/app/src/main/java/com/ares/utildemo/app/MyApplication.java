package com.ares.utildemo.app;

import android.app.Application;
import android.content.Context;

/**
 * 自定义Application
 * Created by Ares on 2016/12/14/014.
 */

public class MyApplication extends Application{

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = getApplicationContext();
    }

    /**
     * 获取全局的上下文对象
     * @return 上下文对象
     */
    public static Context getContext(){
        return mContext;
    }
}
