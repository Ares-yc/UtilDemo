package com.ares.utildemo.utils;

import android.util.Log;

/**
 * Created by Yan Cui on 2017/3/20/020.
 */

public class LogUtil {

    private static final String TAG = "LogUtil";
    private static boolean isShow = true;

    private LogUtil(){
        throw new UnsupportedOperationException("This Class cant't");
    }

    public static void v(String msg){
        if (isShow) {
            show(msg,Level.Verbose);
        }
    }

    public static void d(String msg){
        if (isShow) {
            show(msg,Level.Debug);
        }
    }

    public static void i(String msg){
        if (isShow) {
            show(msg,Level.Info);
        }
    }

    public static void w(String msg){
        if (isShow) {
            show(msg,Level.Warn);
        }
    }

    public static void e(String msg){
        if (isShow) {
            show(msg,Level.Error);
        }
    }

    private static void show(String msg,Level level){//32
        while (msg.length()<28){
            msg = msg+" ";
        }
        switch (level){
            case Verbose:
                Log.v(TAG,"--------------------------------");
                Log.v(TAG,"|Verbose                       |");
                Log.v(TAG,"================================");
                Log.v(TAG,"|"+msg+"|");
                Log.v(TAG,"--------------------------------");
                break;
            case Debug:
                Log.d(TAG,"--------------------------------");
                Log.d(TAG,"|Debug                         |");
                Log.d(TAG,"================================");
                Log.d(TAG,"|"+msg+"|");
                Log.d(TAG,"--------------------------------");
                break;
            case Info:
                Log.i(TAG,"--------------------------------");
                Log.i(TAG,"|Info                          |");
                Log.i(TAG,"================================");
                Log.i(TAG,"|"+msg+"|");
                Log.i(TAG,"--------------------------------");
                break;
            case Warn:
                Log.w(TAG,"--------------------------------");
                Log.w(TAG,"|Warn                          |");
                Log.w(TAG,"================================");
                Log.w(TAG,"|"+msg+"|");
                Log.w(TAG,"--------------------------------");
                break;
            case Error:
                Log.e(TAG,"--------------------------------");
                Log.e(TAG,"|Error                         |");
                Log.e(TAG,"================================");
                Log.e(TAG,"|"+msg+"|");
                Log.e(TAG,"--------------------------------");
                break;
        }
    }

    enum Level{
        Verbose,Debug,Info,Warn,Error
    }
}
