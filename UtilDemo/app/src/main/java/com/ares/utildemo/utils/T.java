package com.ares.utildemo.utils;

import android.os.Handler;
import android.widget.Toast;

import com.ares.utildemo.app.MyApplication;

/**
 * Toast工具类
 * 避免连续点击Toast时显示时间过长
 * Created by kxd on 2016/12/14/014.
 */

public class T {

    private static Toast mToast;
    private static Handler mHandler = new Handler();
    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            /**  取消前一Toast */
            mToast.cancel();
        }
    };

    /**
     * 显示Toast
     * @param str       显示文本
     * @param duration  显示时间
     */
    public static void show(String str, int duration){
        mHandler.removeCallbacks(runnable);
        if(mToast != null)
            mToast.setText(str);
        else
            mToast = Toast.makeText(MyApplication.getContext(),str, Toast.LENGTH_LONG);
        mHandler.postDelayed(runnable,duration);
        mToast.show();
    }

    /**
     * 显示Toast
     * @param res       显示文本对应资源id
     * @param duration  显示时间
     */
    public static void show(int res,int duration){
        show(MyApplication.getContext().getResources().getString(res),duration);
    }

}
